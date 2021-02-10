package com.example.demo.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.example.demo.security.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AppointmentDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.model.Appointment;
import com.example.demo.model.AppointmentStatus;
import com.example.demo.model.AppointmentType;
import com.example.demo.model.Dermatologist;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.model.Pharmacy;
import com.example.demo.model.Vacation;
import com.example.demo.model.enums.AppointmentStatusValue;
import com.example.demo.model.enums.AppointmentTypeValues;
import com.example.demo.service.AppointmentService;
import com.example.demo.service.AppointmentStatusService;
import com.example.demo.service.AppointmentTypeService;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PatientService;
import com.example.demo.service.PharmacyService;
import com.example.demo.service.VacationService;
import com.example.demo.service.email.EmailServiceImpl;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/appointments", produces = MediaType.APPLICATION_JSON_VALUE)
public class AppointmentController {
	@Autowired
	private TokenUtils tokenUtils;

	private AppointmentService appointmentService;
	private AppointmentTypeService appointmentTypeService;
	private AppointmentStatusService appointmentStatusService;
	private DoctorService doctorService;
	private PatientService patientService;
	private VacationService vacationService;
    private PharmacyService pharmacyService;
    private final EmailServiceImpl emailService;
    
	@Autowired
	public AppointmentController(AppointmentService appointmentService,
			DoctorService doctorService, PatientService patientService,
			AppointmentTypeService appointmentTypeService,
			AppointmentStatusService appointmentStatusService,
			VacationService vacationService,
			PharmacyService pharmacyService,
			EmailServiceImpl emailService) {
		this.appointmentService = appointmentService;
		this.appointmentTypeService = appointmentTypeService;
		this.appointmentStatusService = appointmentStatusService;
		this.doctorService = doctorService;
		this.patientService = patientService;
		this.vacationService = vacationService;
		this.pharmacyService = pharmacyService;
		this.emailService = emailService;
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {

		List<Appointment> appointments = appointmentService.findAll();

		List<AppointmentDTO> appointmentsDTO = new ArrayList<>();
		for (Appointment a : appointments) {
			appointmentsDTO.add(new AppointmentDTO(a));
		}

		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/upcomingPatients/{id}")
	public ResponseEntity<List<PatientDTO>> getAllPatientsFromAppointmentsOfDoctor(@PathVariable Long id) {

		List<Appointment> appointments = appointmentService.findAll();
		List<Patient> patients = new ArrayList<Patient>();
		for (Appointment a : appointments) {
			if(a.getStatus().getStatusValue() == AppointmentStatusValue.UPCOMING
				& a.getDoctor().getId() == id & a.getPatient() != null)
			patients.add(a.getPatient());
		}

		List<PatientDTO> patientDTO = new ArrayList<>();
		for (Patient p : patients) {
			patientDTO.add(new PatientDTO(p));
		}

		return new ResponseEntity<>(patientDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/allConsultations")
	public ResponseEntity<List<AppointmentDTO>> getAllConsultations() {

		List<Appointment> appointments = new ArrayList<>();
		for(Appointment a : appointmentService.findAll())
			if(a.getAppointmentType().getAppointmentTypeValue().getText().contentEquals("consultation"))
				appointments.add(a);

		List<AppointmentDTO> appointmentsDTO = new ArrayList<>();
		for (Appointment a : appointments) {
			appointmentsDTO.add(new AppointmentDTO(a));
		}

		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/allExaminations")
	public ResponseEntity<List<AppointmentDTO>> getAllExaminations() {

		List<Appointment> appointments = new ArrayList<>();
		for(Appointment a : appointmentService.findAll())
			if(a.getAppointmentType().getAppointmentTypeValue().getText().contentEquals("examination"))
				appointments.add(a);

		List<AppointmentDTO> appointmentsDTO = new ArrayList<>();
		for (Appointment a : appointments) {
			appointmentsDTO.add(new AppointmentDTO(a));
		}

		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/allConsultations/{id}")
	public ResponseEntity<List<AppointmentDTO>> getAllPharmacistConsultations(@PathVariable Long id) {

		List<Appointment> appointments = new ArrayList<>();
		for(Appointment a : appointmentService.findAll())
			if(a.getAppointmentType().getAppointmentTypeValue().getText().contentEquals("consultation")
			   & a.getDoctor().getId() == id)
				appointments.add(a);

		List<AppointmentDTO> appointmentsDTO = new ArrayList<>();
		for (Appointment a : appointments) {
			appointmentsDTO.add(new AppointmentDTO(a));
		}

		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/allExaminations/{id}")
	public ResponseEntity<List<AppointmentDTO>> getAllDermatologistExaminations(@PathVariable Long id) {

		List<Appointment> appointments = new ArrayList<>();
		for(Appointment a : appointmentService.findAll())
			if(a.getAppointmentType().getAppointmentTypeValue().getText().contentEquals("examination")
			   & a.getDoctor().getId() == id)
				appointments.add(a);

		List<AppointmentDTO> appointmentsDTO = new ArrayList<>();
		for (Appointment a : appointments) {
			appointmentsDTO.add(new AppointmentDTO(a));
		}

		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/allNotEmptyExaminations/{id}")
	public ResponseEntity<List<AppointmentDTO>> getAllNotEmptyDermatologistExaminations(@PathVariable Long id) {

		List<Appointment> appointments = new ArrayList<>();
		for(Appointment a : appointmentService.findAll())
			if(a.getAppointmentType().getAppointmentTypeValue().getText().contentEquals("examination")
			   & a.getDoctor().getId() == id & a.getPatient() != null)
				appointments.add(a);

		List<AppointmentDTO> appointmentsDTO = new ArrayList<>();
		for (Appointment a : appointments) {
			appointmentsDTO.add(new AppointmentDTO(a));
		}

		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/allNotEmptyConsultations/{id}")
	public ResponseEntity<List<AppointmentDTO>> getAllNotEmptyPharmacistConsultations(@PathVariable Long id) {

		List<Appointment> appointments = new ArrayList<>();
		for(Appointment a : appointmentService.findAll())
			if(a.getAppointmentType().getAppointmentTypeValue().getText().contentEquals("consultation")
			   & a.getDoctor().getId() == id & a.getPatient() != null)
				appointments.add(a);

		List<AppointmentDTO> appointmentsDTO = new ArrayList<>();
		for (Appointment a : appointments) {
			appointmentsDTO.add(new AppointmentDTO(a));
		}

		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/allEmptyExaminations")
	public ResponseEntity<List<AppointmentDTO>> getAllEmptyExaminations() {
		
		List<Appointment> appointments = new ArrayList<>();
		for(Appointment a : appointmentService.findAll())
			if(a.getAppointmentType().getAppointmentTypeValue().getText().contentEquals("examination")
					& a.getPatient() == null)
				appointments.add(a);
		
		List<AppointmentDTO> appointmentsDTO = new ArrayList<>();
		for (Appointment a : appointments) {
			appointmentsDTO.add(new AppointmentDTO(a));
		}

		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/allEmptyExaminations/{id}")
	public ResponseEntity<List<AppointmentDTO>> getAllEmptyExaminationsByDermatologist(@PathVariable Long id) {
		
		List<Appointment> appointments = new ArrayList<>();
		for(Appointment a : appointmentService.findAll())
			if(a.getPatient() == null & a.getDoctor().getId() == id)
				appointments.add(a);
		
		List<AppointmentDTO> appointmentsDTO = new ArrayList<>();
		for (Appointment a : appointments) {
			appointmentsDTO.add(new AppointmentDTO(a));
		}

		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AppointmentDTO> getAppointment(@PathVariable Long id) {

		Appointment appointment = appointmentService.findOne(id);

		if (appointment == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(new AppointmentDTO(appointment), HttpStatus.OK);
	}

	@PostMapping(value = "/defineNewAppointment")
	//@PreAuthorize("hasRole('PHARMACY_ADMIN')")
	public ResponseEntity<AppointmentDTO> defineNewAppointment(@RequestBody AppointmentDTO appointmentDTO) {
		System.out.println("-------- Defining new Appointment --------");
		System.out.println(appointmentDTO.toString());
		Doctor doctor = doctorService.findOne(appointmentDTO.getDoctor().getId());
		appointmentDTO.setDoctor(null);
		Appointment appointment  = new Appointment(appointmentDTO);
		appointment.setDoctor(doctor);

		AppointmentType appointmentType = new AppointmentType();
		if ( appointmentDTO.getAppointmentType().getAppointmentTypeValue() == AppointmentTypeValues.CONSULTATION)
			appointmentType.setAppointmentTypeValue(AppointmentTypeValues.CONSULTATION);
		else
			appointmentType.setAppointmentTypeValue(AppointmentTypeValues.EXAMINATION);
		appointmentTypeService.save(appointmentType);

		System.out.println(appointment.toString());

		appointmentService.save(appointment);

		return new ResponseEntity<>(new AppointmentDTO(appointment), HttpStatus.OK);
	}

	@GetMapping(value = "/patient")
//	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<AppointmentDTO>> getDoneByPatient(HttpServletRequest request) {
		//Get patient from session
		String token = tokenUtils.getToken(request);
		if( token == null ){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		String username = tokenUtils.getUsernameFromToken(token);
		Patient patient = patientService.findOneByEmail(username);

		List<Appointment> appointments = appointmentService.findAllByPatient(patient);

		List<AppointmentDTO> appointmentsDTO = new ArrayList<>();
		for (Appointment a : appointments) {
			if(a.getStatus().getStatusValue() == AppointmentStatusValue.DONE)
				appointmentsDTO.add(new AppointmentDTO(a));
		}

		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/upcomingExaminations/{id}")
	public ResponseEntity<List<AppointmentDTO>> getDermatologistUpcomingExaminations(@PathVariable Long id) {

		List<Appointment> appointments = new ArrayList<>();
		for(Appointment a : appointmentService.findAll())
			if(a.getAppointmentType().getAppointmentTypeValue().getText().contentEquals("examination")
			   & a.getDoctor().getId() == id
			   & a.getStatus().getStatusValue() == AppointmentStatusValue.UPCOMING)
				appointments.add(a);

		List<AppointmentDTO> appointmentsDTO = new ArrayList<>();
		for (Appointment a : appointments) {
			appointmentsDTO.add(new AppointmentDTO(a));
		}

		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/patientUpcomming")
//	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<AppointmentDTO>> getUpcommingByPatient() {

		//Izdvojimo pacijenta iz sesije
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("OOOOOO" + currentUser.getName());
		Patient patient = new Patient();
		patient.setEmail(currentUser.getName());
		patient.setId(6L);
		List<Appointment> appointments = appointmentService.findAllByPatient(patient);

		List<AppointmentDTO> appointmentsDTO = new ArrayList<>();
		for (Appointment a : appointments) {
			if(a.getStatus().getStatusValue() == AppointmentStatusValue.UPCOMING)
				appointmentsDTO.add(new AppointmentDTO(a));
		}

		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}
	@PostMapping(value = "/byDoctor")
//	@PreAuthorize("hasRole('PHARMACY_ADMIN')")
	public ResponseEntity<List<AppointmentDTO>> getUpcommingByDoctor(@RequestBody Doctor doctor) {
		System.out.println("-------- Get Appointments by Doctor --------");

		System.out.println("Doctor user : " + doctor.toString());

		List<Appointment> appointments = appointmentService.findAllByDoctor(doctor);

		List<AppointmentDTO> appointmentsDTO = new ArrayList<>();

		for (Appointment a : appointments) {
			System.out.println(a.getId() + ": " + a.getStatus().getStatusValue());
			System.out.println("endTime: " + a.getStartTime());
			System.out.println("startTime: " + a.getEndTime());
			if(a.getStatus().getStatusValue() == AppointmentStatusValue.UPCOMING)
				appointmentsDTO.add(new AppointmentDTO(a));
		}

		return new ResponseEntity<>(appointmentsDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/saveExamination")
    public ResponseEntity<AppointmentDTO> saveExamination(@RequestBody AppointmentDTO appointmentDTO) {
		
		if (appointmentDTO == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
        
        Appointment appointment = new Appointment();
		
		AppointmentType appointmentType = new AppointmentType();
		appointmentType.setAppointmentTypeValue(AppointmentTypeValues.EXAMINATION);
		appointmentType = appointmentTypeService.save(appointmentType);
		appointment.setAppointmentType(appointmentType);
		
		AppointmentStatus appointmentStatus = new AppointmentStatus();
		appointmentStatus.setStatusValue(AppointmentStatusValue.UPCOMING);
		appointmentStatus = appointmentStatusService.save(appointmentStatus); 
		appointment.setStatus(appointmentStatus);
		
		Long doctorId = appointmentDTO.getDoctor().getId();
		Doctor doctor = doctorService.findOne(doctorId);
		appointment.setDoctor(doctor);
		
		setOfValidPatient(appointmentDTO, appointment);
		setOfValidIntervalForExamination(appointmentDTO, appointment);
		
		addAppointmentInPharmacy(appointment);
			
		appointment = appointmentService.save(appointment);
		
		emailService.sendEmail(appointment.getPatient().getEmail(),
				"Greetings, new examination is scheduled from "+appointment.getStartTime()+" to "+appointment.getEndTime()
				+". Regards, "+appointment.getDoctor().getName()+' '+appointment.getDoctor().getLastName(), 
				"New examination");
		
        return new ResponseEntity<>(new AppointmentDTO(appointment), HttpStatus.CREATED);
    }
	
	@PostMapping(value = "/saveConsultation")
    public ResponseEntity<AppointmentDTO> saveConsultation(@RequestBody AppointmentDTO appointmentDTO) {
        
		if (appointmentDTO == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
        Appointment appointment = new Appointment();
		
		AppointmentType appointmentType = new AppointmentType();
		appointmentType.setAppointmentTypeValue(AppointmentTypeValues.CONSULTATION);
		appointmentType = appointmentTypeService.save(appointmentType);
		appointment.setAppointmentType(appointmentType);
		
		AppointmentStatus appointmentStatus = new AppointmentStatus();
		appointmentStatus.setStatusValue(AppointmentStatusValue.UPCOMING);
		appointmentStatus = appointmentStatusService.save(appointmentStatus); 
		appointment.setStatus(appointmentStatus);
		
		Long doctorId = appointmentDTO.getDoctor().getId();
		Doctor doctor = doctorService.findOne(doctorId);
		appointment.setDoctor(doctor);
		
		setOfValidPatient(appointmentDTO, appointment);
		setOfValidIntervalForConsultation(appointmentDTO, appointment);

		appointment = appointmentService.save(appointment);
		
		emailService.sendEmail(appointment.getPatient().getEmail(),
				"Greetings, new consultation is scheduled from "+appointment.getStartTime()+" to "+appointment.getEndTime()
				+". Regards, "+appointment.getDoctor().getName()+' '+appointment.getDoctor().getLastName(), 
				"New consultation");
    
        return new ResponseEntity<>(new AppointmentDTO(appointment), HttpStatus.CREATED);
    }

	private void setOfValidPatient(AppointmentDTO appointmentDTO, Appointment appointment) {
		Long patientId = appointmentDTO.getPatient().getId();
		Patient patient = patientService.findOne(patientId);
		if(patient == null) {
	    	 System.out.println("You did not select a patient.");
	    	 return;
	    }else
	    	appointment.setPatient(patient);
	}
	
	private void setOfValidIntervalForExamination(AppointmentDTO appointmentDTO, Appointment appointment) {
		
		Timestamp start = appointmentDTO.getStartTime();
		Timestamp end = appointmentDTO.getEndTime();
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		int flag = isPatientOccupied(appointmentDTO, appointment, start, end);
		flag += isDoctorBusy(appointment, start, end);
		flag += isDoctorActive(appointmentDTO, appointment, start, end);
		flag += isIntervalCorrect(appointmentDTO, appointment, start, end, currentTime);
		
		if(flag != 0)
			return;
		else {
			appointment.setStartTime(appointmentDTO.getStartTime());
			appointment.setEndTime(appointmentDTO.getEndTime());
		}
	}

	private void setOfValidIntervalForConsultation(AppointmentDTO appointmentDTO, Appointment appointment) {
		
		Timestamp start = appointmentDTO.getStartTime();
		Timestamp end = appointmentDTO.getEndTime();
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		int flag = isPatientOccupied(appointmentDTO, appointment, start, end);
		flag += isDoctorBusy(appointment, start, end);
		flag += isDoctorActive(appointmentDTO, appointment, start, end);
		flag += isIntervalCorrect(appointmentDTO, appointment, start, end, currentTime);
		
		if(flag != 0)
			return;
		else {
			appointment.setStartTime(appointmentDTO.getStartTime());
			appointment.setEndTime(appointmentDTO.getEndTime());
		}
	}
	
	private void addAppointmentInPharmacy(Appointment appointment) {
		
		Pharmacy pharmacy = null;
		for(Pharmacy p : pharmacyService.findAll()) 
			for(Dermatologist d : p.getDermatologists()) 
				if(appointment.getDoctor() == d) 
					for(Appointment a : appointmentService.findAll()) 
						if(a.getPatient() == appointment.getPatient() 
						& a.getStatus().getStatusValue() == AppointmentStatusValue.UPCOMING
						& a != appointment & a.getDoctor() == d) 
							pharmacy = p;	
		
		Set<Appointment> appointments = pharmacy.getAppointments();
		appointments.add(appointment);
		pharmacy.setAppointments(appointments);
	}
	
	private int isPatientOccupied(AppointmentDTO appointmentDTO, Appointment appointment, Timestamp start, Timestamp end) {
		
		for(Appointment a : appointmentService.findAll()) {
			if(a.getPatient() == appointment.getPatient() & a != appointment 
			& a.getStartTime().before(start) & a.getEndTime().after(start)) {
				 System.out.println("Interval is occupied!");
				 return 1;
			}else if(a.getPatient() == appointment.getPatient() & a != appointment 
					& a.getStartTime().before(end) & a.getEndTime().after(end)){
				 System.out.println("Interval is occupied!");
				 return 1;
			}else if(a.getPatient() == appointment.getPatient() & a != appointment 
					& a.getStartTime().before(start) & a.getEndTime().after(end)){
				 System.out.println("Interval is occupied!");
				 return 1;
			}else if(a.getPatient() == appointment.getPatient() & a != appointment 
					& a.getStartTime().after(start) & a.getEndTime().before(end)){
				 System.out.println("Interval is occupied!");
				 return 1;
			}else if(a.getPatient() == appointment.getPatient() & a != appointment 
					& a.getStartTime().after(start) & a.getEndTime().before(end)){
				 System.out.println("Interval is occupied!");
				 return 1;
			}else if(a.getPatient() == appointment.getPatient() & a != appointment 
					& a.getStartTime().equals(start)){
				 System.out.println("Interval is occupied!");
				 return 1;
			}else if(a.getPatient() == appointment.getPatient() & a != appointment 
					& a.getEndTime().equals(end)){
				 System.out.println("Interval is occupied!");
				 return 1;
			}
		}
		
		return 0;
	}

	private int isDoctorBusy(Appointment appointment, Timestamp start, Timestamp end) {
		
		for(Appointment a : appointmentService.findAll()) {
			if(a.getDoctor() == appointment.getDoctor() & a != appointment 
			& a.getStartTime().before(start) & a.getEndTime().after(start)
			& a.getPatient() != null) {
				 System.out.println("Interval is occupied!");
				 return 1;
			}else if(a.getDoctor() == appointment.getDoctor() & a != appointment 
					& a.getStartTime().before(end) & a.getEndTime().after(end)
					& a.getPatient() != null) {
				 System.out.println("Interval is occupied!");
				 return 1;
			}else if(a.getDoctor() == appointment.getDoctor() & a != appointment 
					& a.getStartTime().before(start) & a.getEndTime().after(end)
					& a.getPatient() != null) {
				 System.out.println("Interval is occupied!");
				 return 1;
			}else if(a.getDoctor() == appointment.getDoctor() & a != appointment 
					& a.getStartTime().after(start) & a.getEndTime().before(end)
					& a.getPatient() != null) {
				 System.out.println("Interval is occupied!");
				 return 1;
			}else if(a.getDoctor() == appointment.getDoctor() & a != appointment 
					& a.getStartTime().after(start) & a.getEndTime().before(end)
					& a.getPatient() != null) {
				 System.out.println("Interval is occupied!");
				 return 1;
			}else if(a.getDoctor() == appointment.getDoctor() & a != appointment 
					& a.getStartTime().equals(start) & a.getPatient() != null) {
				 System.out.println("Interval is occupied!");
				 return 1;
			}else if(a.getDoctor() == appointment.getDoctor() & a != appointment 
					& a.getEndTime().equals(end) & a.getPatient() != null) {
				 System.out.println("Interval is occupied!");
				 return 1;
			}
		}
		
		return 0;
	}
	
	private int isDoctorActive(AppointmentDTO appointmentDTO, Appointment appointment, Timestamp start, Timestamp end) {
		
		for(Vacation v : vacationService.findAll()) {
			if(v.getDoctor() == appointment.getDoctor() 
			& v.getStartTime().before(start) & v.getEndTime().after(start)) {
				 System.out.println("Interval is occupied!");
				 return 1;
			}else if(v.getDoctor() == appointment.getDoctor() 
					& v.getStartTime().before(end) & v.getEndTime().after(end)){
				 System.out.println("Interval is occupied!");
				 return 1;
			}else if(v.getDoctor() == appointment.getDoctor() 
					& v.getStartTime().before(start) & v.getEndTime().after(end)){
				 System.out.println("Interval is occupied!");
				 return 1;
			}else if(v.getDoctor() == appointment.getDoctor() 
					& v.getStartTime().after(start) & v.getEndTime().before(end)){
				 System.out.println("Interval is occupied!");
				 return 1;
			}else if(v.getDoctor() == appointment.getDoctor()
					& v.getStartTime().equals(start)){
				 System.out.println("Interval is occupied!");
				 return 1;
			}else if(v.getDoctor() == appointment.getDoctor() 
					& v.getEndTime().equals(end)){
				 System.out.println("Interval is occupied!");
				 return 1;
			}
		}
		
		return 0;
	}
	
	private int isIntervalCorrect(AppointmentDTO appointmentDTO, Appointment appointment, 
			Timestamp start, Timestamp end, Timestamp currentTime) {
		
		if(end == null) {
			 System.out.println("End time needs a value!");
			 return 1;
	    }else if(start == null) {
	    	 System.out.println("Start time needs a value!");
	    	 return 1;
	    }else if (end.before(start)) {
	    	 System.out.println("Start time comes before end time!");
	    	 return 1;
	    }else if(start.before(currentTime)) {
	    	 System.out.println("Start time has passed!");
	    	 return 1;
	    }else if(end.before(currentTime)) {
	    	 System.out.println("End time has passed!");
	    	 return 1;
	    }
		
		return 0;
	}
}