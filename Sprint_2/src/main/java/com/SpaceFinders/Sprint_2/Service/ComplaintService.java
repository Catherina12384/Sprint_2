package com.SpaceFinders.Sprint_2.Service;

import java.util.List;

import com.SpaceFinders.Sprint_2.Utility.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SpaceFinders.Sprint_2.DTO.ComplaintDTO;
import com.SpaceFinders.Sprint_2.Entity.Complaint;
import com.SpaceFinders.Sprint_2.Entity.ComplaintsEnum;
import com.SpaceFinders.Sprint_2.Repository.ComplaintRepository;

@Service
public class ComplaintService {
    @Autowired
    ComplaintRepository cp;

    public ResponseEntity<List<Complaint>> getComplaint() {
        List<Complaint> complaints = cp.findAll();
        if (complaints.isEmpty()) {
            throw new DataNotFoundException("No complaints found in the system");
        }
        return ResponseEntity.ok(complaints);
    }

    public ResponseEntity<Complaint> addComplaint(ComplaintDTO c) {
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

        Complaint savedComplaint = cp.save(complaint);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedComplaint);
    }

    public ResponseEntity<Complaint> updateComplaintData(int id, ComplaintDTO c) {
        Complaint complaint = cp.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Complaint not found with id: " + id));

        // Prevent updates on closed complaints
        if (complaint.getStatus() == ComplaintsEnum.Status.closed) {
            throw new IllegalStateException("Cannot update a closed complaint");
        }

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

        Complaint updatedComplaint = cp.save(complaint);
        return ResponseEntity.ok(updatedComplaint);
    }

    public ResponseEntity<List<Complaint>> sortByStatus(String status) {
        ComplaintsEnum.Status statusEnum;

        try {
            statusEnum = ComplaintsEnum.Status.valueOf(status.toLowerCase());
        } catch (IllegalArgumentException e) {
            throw new DataNotFoundException(
                    "Invalid status: '" + status + "'. Valid values are: open, investigating, resolved, closed"
            );
        }

        List<Complaint> complaints = cp.findByStatus(statusEnum);

        if (complaints.isEmpty()) {
            throw new DataNotFoundException("No complaints found with status: " + status);
        }

        return ResponseEntity.ok(complaints);
    }

    public ResponseEntity<Complaint> getComplaintById(int id) {
        Complaint complaint = cp.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Complaint not found with id: " + id));
        return ResponseEntity.ok(complaint);
    }

    public ResponseEntity<Complaint> updateComplaintStatus(int id, ComplaintsEnum.Status newStatus) {
        Complaint complaint = cp.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Complaint not found with id: " + id));

        // Prevent status updates on closed complaints
        if (complaint.getStatus() == ComplaintsEnum.Status.closed) {
            throw new IllegalStateException("Cannot update status of a closed complaint");
        }

        complaint.setStatus(newStatus);
        Complaint updatedComplaint = cp.save(complaint);
        return ResponseEntity.ok(updatedComplaint);
    }

    public ResponseEntity<List<Complaint>> getComplaintsByStatusAndNotClosed(String status) {
        ComplaintsEnum.Status statusEnum;

        try {
            statusEnum = ComplaintsEnum.Status.valueOf(status.toLowerCase());
        } catch (IllegalArgumentException e) {
            throw new DataNotFoundException(
                    "Invalid status: '" + status + "'. Valid values are: open, investigating, resolved, closed"
            );
        }

        List<Complaint> complaints = cp.findByStatusAndStatusNotClosed(statusEnum, ComplaintsEnum.Status.closed);

        if (complaints.isEmpty()) {
            throw new DataNotFoundException("No open complaints found with status: " + status);
        }

        return ResponseEntity.ok(complaints);
    }

    public ResponseEntity<List<Complaint>> getComplaintsBySeverity(String severity) {
        ComplaintsEnum.Severity severityEnum;

        try {
            severityEnum = ComplaintsEnum.Severity.valueOf(severity.toLowerCase());
        } catch (IllegalArgumentException e) {
            throw new DataNotFoundException(
                    "Invalid severity: '" + severity + "'. Valid values are: low, medium, high, critical"
            );
        }

        List<Complaint> complaints = cp.findBySeverityAndStatusNotClosed(severityEnum, ComplaintsEnum.Status.closed);

        if (complaints.isEmpty()) {
            throw new DataNotFoundException("No open complaints found with severity: " + severity);
        }

        return ResponseEntity.ok(complaints);
    }

    public ResponseEntity<List<Complaint>> getComplaintsByUserId(int userId) {
        List<Complaint> complaints = cp.findByUserIdAndStatusNotClosed(userId, ComplaintsEnum.Status.closed);

        if (complaints.isEmpty()) {
            throw new DataNotFoundException("No open complaints found for user id: " + userId);
        }

        return ResponseEntity.ok(complaints);
    }

}
