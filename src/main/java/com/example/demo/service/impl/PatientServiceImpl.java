package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.*;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.LoyalityProgramRepository;
import com.example.demo.repository.MedicineReservationRepository;
import com.example.demo.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;
	private AuthorityService authorityService;
	private AppointmentRepository appointmentRepository;
	private LoyalityProgramRepository loyalityProgramRepository;
	private MedicineReservationRepository medicineReservationRepository;

	@Autowired
	public PatientServiceImpl(PatientRepository patientRepository, AuthorityService authorityService, AppointmentRepository appointmentRepository, LoyalityProgramRepository loyalityProgramRepository, MedicineReservationRepository medicineReservationRepository) {
		this.patientRepository = patientRepository;
		this.authorityService = authorityService;
		this.appointmentRepository = appointmentRepository;
		this.loyalityProgramRepository = loyalityProgramRepository;
		this.medicineReservationRepository = medicineReservationRepository;
	}
    
    public Patient findOne(Long id) {
		return patientRepository.findById(id).orElseGet(null);
	}
    
    public Patient findOneByPassword(String password) {
		return patientRepository.findOneByPassword(password);
	}

	public List<Patient> findAll() {
		return patientRepository.findAll();
	}
	
	public Page<Patient> findAll(Pageable page) {
		return patientRepository.findAll(page);
	}
	
	public List<Patient> findAllByName(String name) {
		return patientRepository.findAllByName(name);
	}
	
	public List<Patient> findAllByLastName(String lastName) {
		return patientRepository.findAllByLastName(lastName);
	}
	
	public List<Patient> findByNameAndLastNameAllIgnoringCase(String name, String lastName) {
		return patientRepository.findByNameAndLastNameAllIgnoringCase(name, lastName);
	}
	
	public List<Patient> findAllByEmail(String email) {
		return patientRepository.findAllByEmail(email);
	}

	@Override
	public Patient findOneByEmail(String email) {
		return patientRepository.findOneByEmail(email);
	}

	@Override
	public List<Patient> findAllBySubscribedToPromotions(Boolean subscribedToPromotions) {
		return patientRepository.findAllBySubscribedToPromotions(subscribedToPromotions);
	}

	public Patient save(Patient patient) {
		List<Authority> authorities = new ArrayList<>();
		authorities.add(authorityService.findByName("ROLE_USER"));
		patient.setAuthorities(authorities);
		return patientRepository.save(patient);
	}

	@Override
	public int CalculateDiscauntForUser(Long id) {
		Patient patient = patientRepository.findById(id).get();
		List<Appointment> appointments = appointmentRepository.findAllByPatient(patient);
		LoyaltyProgram loyaltyProgram = loyalityProgramRepository.findAll().get(0);
		patient.setPoints(0);
		CalculatePointsForAppointments(patient, appointments, loyaltyProgram);
		CalcutatePointsForMedicine(patient);

		if(patient.getPoints()>loyaltyProgram.getPointsForGold()){
			return loyaltyProgram.getDiscauntForGold();
		}
		if(patient.getPoints()>loyaltyProgram.getPointsForSilver()){
			return loyaltyProgram.getDiscauntForSilver();
		}
		return 0;
	}

	private void CalcutatePointsForMedicine(Patient patient) {
		List<MedicineReservation> medicineReservations = medicineReservationRepository.findAllByPatient(patient);
		for(MedicineReservation mr: medicineReservations){
			if(mr.getReservationStatus().getText().equals("active")){
				patient.setPoints(patient.getPoints()+ mr.getMedicine().getPoints());
			}
		}
	}

	private void CalculatePointsForAppointments(Patient patient, List<Appointment> appointments, LoyaltyProgram loyaltyProgram) {
		for(Appointment a : appointments){
			if(a.getAppointmentType().getAppointmentTypeValue().getText().equals("consultation")){
				patient.setPoints(patient.getPoints()+ loyaltyProgram.getPointsForConsultation());
			}
			else{
				patient.setPoints(patient.getPoints()+ loyaltyProgram.getPointsForExamination());
			}
		}
	}

	public void remove(Long id) {
		patientRepository.deleteById(id);
	}
}