package com.keerthana.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//acts as a bean class of employee
@Entity
@Table
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empID;
	private String username;
	private String city;
	
	
	@ManyToOne
	@JoinColumn(name="leaveType")
	
	private LeaveRequest leaveRequest;
	
	public Employee(LeaveRequest leaveRequest) {
		super();
		this.leaveRequest = leaveRequest;
	}


	public Employee() {
		super();
		
	}


	public Employee(int empID, String username, String city,LeaveRequest leaveRequest) {
		super();
		this.empID = empID;
		this.username = username;
		this.city = city;
		this.leaveRequest = leaveRequest;
		
	}
	
	public int getEmpID() {
		return empID;
	}


	public void setEmpID(int empID) {
		this.empID = empID;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public LeaveRequest getLeaveRequest() {
		return leaveRequest;
	}


	public void setLeaveRequest(LeaveRequest leaveRequest) {
		this.leaveRequest = leaveRequest;
	}
	

}
