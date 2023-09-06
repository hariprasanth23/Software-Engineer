package com.learn.springsecurity.service;



import com.learn.springsecurity.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
