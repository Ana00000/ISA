package com.example.demo.model;

import javax.persistence.*;

import com.example.demo.dto.AppointmentStatusDTO;
import com.example.demo.model.enums.AppointmentStatusValue;

@Entity
public class AppointmentStatus {
	
    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointmentStatusIdSeqGen")
	@SequenceGenerator(name = "appointmentStatusIdSeqGen", sequenceName = "appointmentStatusIdSeqGen", initialValue = 20, allocationSize = 1)
    @Column(name="id", unique=true, nullable=false)
    private Long id;
    
    @Column(name="statusValue", unique=false, nullable=false)
    private AppointmentStatusValue statusValue;

    public AppointmentStatus() {
    }

	public AppointmentStatus(Long id, AppointmentStatusValue statusValue) {
		super();
		this.id = id;
		this.statusValue = statusValue;
	}

	public AppointmentStatus(AppointmentStatusDTO appointmentStatusDTO) {
		super();
		this.id = appointmentStatusDTO.getId();
		this.statusValue = appointmentStatusDTO.getStatusValue();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AppointmentStatusValue getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(AppointmentStatusValue statusValue) {
		this.statusValue = statusValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((statusValue == null) ? 0 : statusValue.hashCode());
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
		AppointmentStatus other = (AppointmentStatus) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (statusValue != other.statusValue)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AppointmentStatus [id=" + id + ", statusValue=" + statusValue + "]";
	}
}
