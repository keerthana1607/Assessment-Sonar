package com.keerthana.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.keerthana.demo.model.LeaveRequest;
import com.keerthana.demo.serviceimpl.LeaveRequestServiceImpl;

@RestController
@RequestMapping("/leave")
@CrossOrigin("http://localhost:3000/")
public class LeaveRequestController {

	
	LeaveRequestServiceImpl leaveservice;
	
	
	public LeaveRequestController(LeaveRequestServiceImpl leaveservice) {
		super();
		this.leaveservice = leaveservice;
	}

	//for adding leave details in leave request table -post
	@PostMapping
	public String insertLeave(@RequestBody LeaveRequest leave) {
		String msg="";
		try {
			leaveservice.addLeaveRequest(leave);
			msg="adding Success";
		}catch(Exception e) {
			msg="adding Failure";
		}
		return msg;
		
	}
	
	//for getting leave request details in leave table -get
	@GetMapping("/all")
	public List<LeaveRequest> getLeave() {
		return leaveservice.getAllLeave();
	}
	
	//for getting leave request details by their id from leave table for fetching  -get
	@GetMapping("{id}")
	public LeaveRequest getLeavelById(@PathVariable("id") int id) {
		return leaveservice.getLeave(id);
	}
	
	//for updating leave details-put
	@PutMapping
	public String updationLeave(@RequestBody LeaveRequest leave) {
		String msg="";
		try {
			leaveservice.updateLeave(leave);
			msg="updation Success";
		} catch (Exception e) {
			msg="updation Failure";
		}
		return msg;
	}
	
	
}
