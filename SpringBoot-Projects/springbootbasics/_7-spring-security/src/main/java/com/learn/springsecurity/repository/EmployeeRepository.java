package com.learn.springsecurity.repository;


import com.learn.springsecurity.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
