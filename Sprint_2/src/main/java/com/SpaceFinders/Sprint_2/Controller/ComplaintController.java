package com.SpaceFinders.Sprint_2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpaceFinders.Sprint_2.Service.ComplaintService;
import com.SpaceFinders.Sprint_2.DTO.ComplaintDTO;
import com.SpaceFinders.Sprint_2.Entity.Complaint;

@RestController
@RequestMapping("/v1/api/complaints")
public class ComplaintController {
	@Autowired
	ComplaintService cs;
	
	@GetMapping("/viewAllComplaint")
	public List<Complaint> viewAll(){
		return cs.getComplaint();
	}
	
	@PostMapping("/insertComplaint")
	public Complaint insertComplaint(@RequestBody ComplaintDTO c) {
		return cs.addComplaint(c);
	}
	
	@PutMapping("/{id}")
	public Complaint updateComplaint(@PathVariable int id, @RequestBody ComplaintDTO c) {
		return cs.updateComplaintData(id, c);
	}
	
	@GetMapping("/{status}")
	public List<Complaint> viewByComplaintStatus(@PathVariable String status){
		return cs.SortByStatus(status);
	}
}
