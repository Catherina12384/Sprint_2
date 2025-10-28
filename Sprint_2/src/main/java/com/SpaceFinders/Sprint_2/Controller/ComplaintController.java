package com.SpaceFinders.Sprint_2.Controller;

import java.util.List;

import com.SpaceFinders.Sprint_2.Entity.ComplaintsEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.SpaceFinders.Sprint_2.Service.ComplaintService;
import com.SpaceFinders.Sprint_2.DTO.ComplaintDTO;
import com.SpaceFinders.Sprint_2.Entity.Complaint;

@RestController
@RequestMapping("/v1/api/complaints")
public class ComplaintController {
    @Autowired
    ComplaintService cs;

    @GetMapping
    public ResponseEntity<List<Complaint>> viewAllComplaints() {
        return cs.getComplaint();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Complaint> viewComplaintById(@PathVariable int id) {
        return cs.getComplaintById(id);
    }

    @PostMapping
    public ResponseEntity<Complaint> insertComplaint(@RequestBody ComplaintDTO c) {
        return cs.addComplaint(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Complaint> updateComplaint(@PathVariable int id, @RequestBody ComplaintDTO c) {
        return cs.updateComplaintData(id, c);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Complaint> updateComplaintStatus(@PathVariable int id,@RequestParam ComplaintsEnum.Status status) {
        return cs.updateComplaintStatus(id, status);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Complaint>> viewByComplaintStatus(@PathVariable String status) {
        return cs.sortByStatus(status);
    }

    @GetMapping("/status/{status}/active")
    public ResponseEntity<List<Complaint>> viewActiveComplaintsByStatus(@PathVariable String status) {
        return cs.getComplaintsByStatusAndNotClosed(status);
    }

    @GetMapping("/severity/{severity}")
    public ResponseEntity<List<Complaint>> viewComplaintsBySeverity(@PathVariable String severity) {
        return cs.getComplaintsBySeverity(severity);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Complaint>> viewComplaintsByUser(@PathVariable int userId) {
        return cs.getComplaintsByUserId(userId);
    }

    @GetMapping("/open")
    public ResponseEntity<List<Complaint>> viewOpenComplaints() {
        return cs.getOpenComplaints();
    }
}
