package com.keerthana.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.keerthana.demo.model.Employee;
import com.keerthana.demo.serviceimpl.EmployeeServiceImpl;

@RestController
@RequestMapping("/emp")
@CrossOrigin("http://localhost:3000/")

public class EmployeeController {

	
	EmployeeServiceImpl empservice;
	
	public EmployeeController(EmployeeServiceImpl empservice) {
		super();
		this.empservice = empservice;
	}

	//for adding employees in employee table -post
	@PostMapping
	public String insertEmployee(@RequestBody Employee emp, @RequestParam int pId) {
		return empservice.addEmployee(emp, pId);

		}
	
	//for getting employees id to fetch details for updating process in employee table -get
	@GetMapping("{id}")
	public Employee getEmployeeById(@PathVariable("id") int id) {
		return empservice.getEmployee(id);
	}
	
	//for getting all employees details in employee table -get
	@GetMapping("/all")
	public List<Employee> getEmployees() {
		return empservice.getAllEmployee();
	}
	
	//for updating new values for employees in employee table -put
	@PutMapping("{eid}")
		public String updationEmployee(@RequestBody Employee emp,@PathVariable int eid) {
			return empservice.updateEmployee(emp, eid);

	}
	
	//for deleting employees in employee table -delete
	@DeleteMapping("{id}")
	public String deleteEmployeetById(@PathVariable("id") int id) {
		String msg="";
		try {
			empservice.deleteEmployee(id);
			msg="deleted Success";
		} catch (Exception e) {
			msg="deleted Failure";
		}
		return msg;
	}
	
}
