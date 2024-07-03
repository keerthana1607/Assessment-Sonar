package com.keerthana.demo.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//acts as a bean class for leave request
@Entity
@Table
public class LeaveRequest {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int leaveID;
	private String leaveType;
	private String reason;
	
	@OneToMany(mappedBy = "leaveRequest")
	private List<Employee> employees;

	public LeaveRequest() {
		super();
		
	}

	public LeaveRequest(int leaveID, String leaveType, String reason) {
		super();
		this.leaveID = leaveID;
		this.leaveType = leaveType;
		this.reason = reason;
		
	}

	public int getLeaveID() {
		return leaveID;
	}

	public void setLeaveID(int leaveID) {
		this.leaveID = leaveID;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	

}