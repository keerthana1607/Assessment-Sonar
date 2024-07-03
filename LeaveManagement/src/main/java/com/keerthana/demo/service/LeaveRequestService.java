package com.keerthana.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.keerthana.demo.model.LeaveRequest;

//methods declared in service Implementation package
@Service
public interface LeaveRequestService {
	
	public void addLeaveRequest(LeaveRequest leave);
	public LeaveRequest getLeave(int id);
	public List<LeaveRequest> getAllLeave();
	public void updateLeave(LeaveRequest leave);
	
}
