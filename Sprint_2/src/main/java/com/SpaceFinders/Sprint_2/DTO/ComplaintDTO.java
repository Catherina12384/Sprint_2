package com.SpaceFinders.Sprint_2.DTO;

import java.time.LocalDate;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import com.SpaceFinders.Sprint_2.Entity.ComplaintsEnum.ComplaintType;
import com.SpaceFinders.Sprint_2.Entity.ComplaintsEnum.Severity;
import com.SpaceFinders.Sprint_2.Entity.ComplaintsEnum.Status;

public class ComplaintDTO {
	private int user_id;
	
	private int property_id;
	
	private int booking_id;
	
	private String title;
	
	private String desc;
	
	@Enumerated(EnumType.STRING)
	private ComplaintType complaint_type;
	
	@Enumerated(EnumType.STRING)
	private Severity severity;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private LocalDate resolution_date;
	
	private String resolution_note;
	

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

	public ComplaintDTO(int user_id, int property_id, int booking_id, String title, String desc,
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
	
}
