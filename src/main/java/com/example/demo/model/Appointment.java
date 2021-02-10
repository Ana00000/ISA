package com.example.demo.model;

import com.example.demo.dto.AppointmentDTO;
import com.example.demo.model.enums.AppointmentStatusValue;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Appointment {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointmentIdSeqGen")
	@SequenceGenerator(name = "appointmentIdSeqGen", sequenceName = "appointmentIdSeq", initialValue = 20, allocationSize = 1)
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Column(name="price", unique=false)
    private double price;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AppointmentType appointmentType;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AppointmentStatus status;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Patient patient;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Doctor doctor;

    @Column(nullable = false)
    private Timestamp startTime;

    @Column(nullable = false)
    private Timestamp endTime;
    
    @Column(name="penalty", unique=false)
    private int penalty;

	public Appointment() {
	}

	public Appointment(Long id, double price, AppointmentType appointmentType, AppointmentStatus status, Patient patient,
			Doctor doctor, Timestamp startTime, Timestamp endTime, int penalty) {
		super();
		this.id = id;
		this.price = price;
		this.appointmentType = appointmentType;
		this.status = status;
		this.patient = patient;
		this.doctor = doctor;
		this.startTime = startTime;
		this.endTime = endTime;
		this.penalty = penalty;
	}

	public Appointment(AppointmentDTO appointmentDTO) {
		super();
		this.id = appointmentDTO.getId();
		this.price = appointmentDTO.getPrice();
		if (appointmentDTO.getAppointmentType() != null) this.appointmentType = new AppointmentType(appointmentDTO.getAppointmentType());
		if (appointmentDTO.getStatus() != null) this.status = new AppointmentStatus(appointmentDTO.getStatus());
		else {
			this.status = new AppointmentStatus();
			this.status.setStatusValue(AppointmentStatusValue.UPCOMING);
		}
		if (appointmentDTO.getPatient() != null) this.patient = new Patient(appointmentDTO.getPatient());
		if (appointmentDTO.getDoctor() != null) this.doctor = new Doctor(appointmentDTO.getDoctor());
		this.startTime = appointmentDTO.getStartTime();
		this.endTime = appointmentDTO.getEndTime();
		this.penalty = appointmentDTO.getPenalty();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public AppointmentType getAppointmentType() {
		return appointmentType;
	}

	public void setAppointmentType(AppointmentType appointmentType) {
		this.appointmentType = appointmentType;
	}

	public AppointmentStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public int getPenalty() {
		return penalty;
	}

	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appointmentType == null) ? 0 : appointmentType.hashCode());
		result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
		result = prime * result + penalty;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		if (appointmentType == null) {
			if (other.appointmentType != null)
				return false;
		} else if (!appointmentType.equals(other.appointmentType))
			return false;
		if (doctor == null) {
			if (other.doctor != null)
				return false;
		} else if (!doctor.equals(other.doctor))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		if (penalty != other.penalty)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", price=" + price + ", appointmentType=" + appointmentType + ", status="
				+ status + ", patient=" + patient + ", doctor=" + doctor + ", startTime=" + startTime + ", endTime="
				+ endTime + ", penalty=" + penalty + "]";
	}
}
