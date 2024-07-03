package com.keerthana.demo.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.keerthana.demo.model.LeaveRequest;
import com.keerthana.demo.repoisatory.LeaveRequestRepo;

@Service
public class LeaveRequestServiceImpl {
	
	
	LeaveRequestRepo leaverepo;
	

	public LeaveRequestServiceImpl(LeaveRequestRepo leaverepo) {
		super();
		this.leaverepo = leaverepo;
	}


	//to add leave details
	public void addLeaveRequest(LeaveRequest leave) {
		leaverepo.save(leave);
		
	}


	//to fetch all leave deatils
	public List<LeaveRequest> getAllLeave() {
		return leaverepo.findAll();
	}

	//to update leave details
	public void updateLeave(LeaveRequest leave) {
		leaverepo.save(leave);
		
	}


	//to find leave details by ID
	public LeaveRequest getLeave(int id) {
	    Optional<LeaveRequest> leaveOptional = leaverepo.findById(id);
	    if (leaveOptional.isPresent()) {
	        return leaveOptional.get();
	    } else {
	       return null; 
	    }
	}


	

}
