package com.keerthana.demo.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.keerthana.demo.model.Employee;
import com.keerthana.demo.model.LeaveRequest;
import com.keerthana.demo.repoisatory.EmployeeRepo;
import com.keerthana.demo.service.EmployeeService;

import jakarta.persistence.EntityManager;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	EmployeeRepo emprepo;
	EntityManager eman;
	
	public EmployeeServiceImpl(EmployeeRepo emprepo, EntityManager eman) {
		super();
		this.emprepo = emprepo;
		this.eman = eman;
	}


	//to fetch all employee details
	public List<Employee> getAllEmployee() {
		return emprepo.findAll();
	}

	//to delete employee by ID
	public void deleteEmployee(int id) {
		emprepo.deleteById(id);
		
	}

	//to add employee details
	@Override
	public String addEmployee(Employee emp, int pId) {
		LeaveRequest leave=eman.find(LeaveRequest.class, pId);
		if(leave!=null) {
			emp.setLeaveRequest(leave);
		emprepo.save(emp);
			return "saved";
			
		}else {
			return "no";
		}

     }

	//to update employee details
	public String updateEmployee(Employee emp, int eid) {
		Employee em=eman.find(Employee.class, eid);
		if(em!=null) {
			em.setUsername(emp.getUsername());
			em.setCity(emp.getCity());
			emprepo.save(em);
			return "saved";
		}else {
			return "no";
		}
		
	}


	//to get employee values by ID
	public Employee getEmployee(int id) {
	    Optional<Employee> employeeOptional = emprepo.findById(id);
	    if (employeeOptional.isPresent()) {
	        return employeeOptional.get();
	    } else {
	         return null;
	    }
	}
	
	
}
