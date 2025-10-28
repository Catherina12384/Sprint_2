package com.SpaceFinders.Sprint_2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpaceFinders.Sprint_2.Entity.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Integer>{

	// In your repository interface
	List<Complaint> findByStatus(com.SpaceFinders.Sprint_2.Entity.ComplaintsEnum.Status status);

	
	
}
