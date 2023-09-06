package com.learn.restcrud.service;

import com.learn.restcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
