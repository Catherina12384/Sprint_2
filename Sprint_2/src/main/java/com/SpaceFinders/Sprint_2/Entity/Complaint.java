package com.SpaceFinders.Sprint_2.Entity;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

import com.SpaceFinders.Sprint_2.Entity.ComplaintsEnum.ComplaintType;
import com.SpaceFinders.Sprint_2.Entity.ComplaintsEnum.Severity;
import com.SpaceFinders.Sprint_2.Entity.ComplaintsEnum.Status;

@Entity
@Table(name="Complaint")
public class Complaint {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int complaint_id;
	
	int user_id;
	
	int property_id;
	
	int booking_id;
	
	String title;
	
	String desc;
	
	@Enumerated(EnumType.STRING)
	ComplaintType complaint_type;
	
	@Enumerated(EnumType.STRING)
	Severity severity;
	
	@Enumerated(EnumType.STRING)
	Status status;
	
	LocalDate resolution_date;
	
	String resolution_note;
	
	
	public Complaint() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Complaint(int user_id, int property_id, int booking_id, String title, String desc,
			ComplaintType complaint_type, Severity severity, Status status, LocalDate resolution_date,
			String resolution_note) {
		super();
		
		this.user_id = user_id;
		this.property_id = property_id;
		this.booking_id = booking_id;
		this.title = title;
		this.desc = desc;
		this.complaint_type = complaint_type;
		this.severity = severity;
		this.status = status;
		this.resolution_date = resolution_date;
		this.resolution_note = resolution_note;
	}

	public int getComplaint_id() {
		return complaint_id;
	}

	public void setComplaint_id(int complaint_id) {
		this.complaint_id = complaint_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getProperty_id() {
		return property_id;
	}

	public void setProperty_id(int property_id) {
		this.property_id = property_id;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public ComplaintType getComplaint_type() {
		return complaint_type;
	}

	public void setComplaint_type(ComplaintType complaint_type) {
		this.complaint_type = complaint_type;
	}

	public Severity getSeverity() {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getResolution_date() {
		return resolution_date;
	}

	public void setResolution_date(LocalDate resolution_date) {
		this.resolution_date = resolution_date;
	}

	public String getResolution_note() {
		return resolution_note;
	}

	public void setResolution_note(String resolution_note) {
		this.resolution_note = resolution_note;
	}

	
}

