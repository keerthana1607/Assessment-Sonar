package com.keerthana.demo.repoisatory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keerthana.demo.model.LeaveRequest;


@Repository
public interface LeaveRequestRepo extends JpaRepository<LeaveRequest, Integer> {

}
