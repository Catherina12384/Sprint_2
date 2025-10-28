package com.SpaceFinders.Sprint_2.Repository;

import java.util.List;

import com.SpaceFinders.Sprint_2.Entity.ComplaintsEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpaceFinders.Sprint_2.Entity.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Integer>{

    List<Complaint> findByStatus(ComplaintsEnum.Status status);

    // Find by status and exclude another status
    List<Complaint> findByStatusAndStatusNot(ComplaintsEnum.Status status, ComplaintsEnum.Status excludeStatus);

    // Find by severity excluding closed complaints
    List<Complaint> findBySeverityAndStatusNot(ComplaintsEnum.Severity severity, ComplaintsEnum.Status excludeStatus);

    // Find by user ID excluding closed complaints
    List<Complaint> findByUserIdAndStatusNot(int userId, ComplaintsEnum.Status excludeStatus);

	
	
}
