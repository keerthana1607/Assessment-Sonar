package com.keerthana.demo.repoisatory;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.keerthana.demo.model.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
