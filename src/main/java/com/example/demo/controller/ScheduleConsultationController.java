package com.example.demo.controller;

import com.example.demo.dto.Hadzi.ConsultationScheduleDTO;
import com.example.demo.dto.Hadzi.PharmacyDTOHadzi;
import com.example.demo.dto.PharmacistDTO;
import com.example.demo.model.*;
import com.example.demo.model.enums.AppointmentStatusValue;
import com.example.demo.model.enums.AppointmentTypeValues;
import com.example.demo.security.TokenUtils;
import com.example.demo.service.*;
import com.example.demo.service.impl.TimeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping(value = "/scheduleConsultation", produces = MediaType.APPLICATION_JSON_VALUE)
public class ScheduleConsultationController {

    private Map<Pharmacist, List<TimeInterval>> freePharmacists;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private PatientService patientService;

    @Autowired
    private PharmacistService pharmacistService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PharmacyService pharmacyService;

    @Autowired
    private AppointmentStatusService appointmentStatusService;

    @Autowired
    private AppointmentTypeService appointmentTypeService;


    private void findAvailablePharmacists(TimeInterval timeInterval){
        TimeGenerator timeGenerator = new TimeGenerator(30, 10, timeInterval.getStart().toLocalDateTime().toLocalDate());
        Set<TimeInterval> timeIntervalSet = timeGenerator.generateForChosenPeriod(timeInterval);
        Map<Pharmacist, List<TimeInterval>> freePharmacists = new HashMap<>();
        List<Pharmacist> pharmacists =  pharmacistService.findAll();
        for( Pharmacist pharmacist : pharmacists ){
            List<Appointment> appointments = appointmentService.findAllByDoctor(pharmacist);
            List<TimeInterval> availbaleTimeIntervals = new ArrayList<>();
            for(TimeInterval ti : timeIntervalSet){
                boolean overlaps = false;
                for(Appointment ap : appointments){
                    TimeInterval timeInt = new TimeInterval(ap.getStartTime(), ap.getEndTime());
                    if(ti.overlaps(timeInt)){
                        overlaps = true;
                        break;
                    }
                }
                if(!overlaps){
                    availbaleTimeIntervals.add(ti);
                }
            }
            if(availbaleTimeIntervals.size() > 0){
                freePharmacists.put(pharmacist, availbaleTimeIntervals);
            }
        }
        this.freePharmacists = freePharmacists;
    }

    @PostMapping("/pharmacies")
    public ResponseEntity<Set<PharmacyDTOHadzi>> availablePharmacies(@RequestBody TimeInterval timeInterval){
        findAvailablePharmacists(timeInterval);
        Set<PharmacyDTOHadzi> pharmacies = new HashSet<>();
        for(Pharmacist pharmacist : freePharmacists.keySet()){
            pharmacies.add(new PharmacyDTOHadzi(pharmacist.getPharmacy()));
        }
        return new ResponseEntity<>(pharmacies, HttpStatus.OK);
    }

    @PostMapping("/pharmacists")
    public ResponseEntity<Set<PharmacistDTO>> availablePharmacists(@RequestBody PharmacyDTOHadzi pharmacyDTO){
        if(freePharmacists == null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Set<PharmacistDTO> pharmacists = new HashSet<>();
        for(Pharmacist pharmacist : freePharmacists.keySet()){
            if(pharmacist.getPharmacy().getId() == pharmacyDTO.getId()){
                pharmacists.add(new PharmacistDTO(pharmacist));
            }
        }
        return new ResponseEntity<>(pharmacists, HttpStatus.OK);
    }

    @PostMapping("/timeIntervals")
    public ResponseEntity<List<TimeInterval>> availableTimeIntervals(@RequestBody PharmacistDTO pharmacist){
        Pharmacist p = pharmacistService.findOne(pharmacist.getId());
        return new ResponseEntity<>(freePharmacists.get(p), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Appointment> schedule(HttpServletRequest request, @RequestBody ConsultationScheduleDTO consultationScheduleDTO){

        Appointment appointment = new Appointment();

        String token = tokenUtils.getToken(request);
        if( token == null ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        String username = tokenUtils.getUsernameFromToken(token);
        Patient patient = patientService.findOneByEmail(username);

        appointment.setDoctor( pharmacistService.findOne(consultationScheduleDTO.getPharmacistID()));
        appointment.setStartTime( consultationScheduleDTO.getTimeInterval().getStart() );
        appointment.setEndTime( consultationScheduleDTO.getTimeInterval().getEnd() );
        appointment.setPatient( patient );
        appointment.setStatus( appointmentStatusService.findByValue(AppointmentStatusValue.UPCOMING) );
        appointment.setAppointmentType( appointmentTypeService.findByTypeValue(AppointmentTypeValues.CONSULTATION));

        appointmentService.save(appointment);

        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }

}
