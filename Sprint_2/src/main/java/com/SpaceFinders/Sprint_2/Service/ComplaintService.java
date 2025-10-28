package com.SpaceFinders.Sprint_2.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpaceFinders.Sprint_2.DTO.ComplaintDTO;
import com.SpaceFinders.Sprint_2.Entity.Complaint;
import com.SpaceFinders.Sprint_2.Entity.ComplaintsEnum;
import com.SpaceFinders.Sprint_2.Repository.ComplaintRepository;

@Service
public class ComplaintService {
	@Autowired
	ComplaintRepository cp;
	
	public List<Complaint> getComplaint() {
		return cp.findAll();
	}
	
	public Complaint addComplaint(ComplaintDTO c) {
		Complaint complaint = new Complaint();
        complaint.setUser_id(c.getUser_id());
        complaint.setProperty_id(c.getProperty_id());
        complaint.setBooking_id(c.getBooking_id());
        complaint.setTitle(c.getTitle());
        complaint.setDesc(c.getDesc());
        complaint.setComplaint_type(c.getComplaint_type());
        complaint.setSeverity(c.getSeverity());
        complaint.setStatus(c.getStatus());
        complaint.setResolution_date(c.getResolution_date());
        complaint.setResolution_note(c.getResolution_note());

        return cp.save(complaint);	
	}
	
	public Complaint updateComplaintData(int id, ComplaintDTO c) {
	        
	        if (cp.existsById(id)) {
	        	Complaint complaint = cp.findById(id).orElseThrow();
	            
	            complaint.setUser_id(c.getUser_id());
	            complaint.setProperty_id(c.getProperty_id());
	            complaint.setBooking_id(c.getBooking_id());
	            complaint.setTitle(c.getTitle());
	            complaint.setDesc(c.getDesc());
	            complaint.setComplaint_type(c.getComplaint_type());
	            complaint.setSeverity(c.getSeverity());
	            complaint.setStatus(c.getStatus());
	            complaint.setResolution_date(c.getResolution_date());
	            complaint.setResolution_note(c.getResolution_note());
	            
	            return cp.save(complaint);
	        }
	    return null; 
	}
	
	public List<Complaint> SortByStatus(String status) {
		if(status.equalsIgnoreCase("open")) {
			return cp.findByStatus(ComplaintsEnum.Status.open);
		}
		else if(status.equalsIgnoreCase("closed")) {
			return cp.findByStatus(ComplaintsEnum.Status.closed);
		}
		else {
			return null;
		}	
	}

}
