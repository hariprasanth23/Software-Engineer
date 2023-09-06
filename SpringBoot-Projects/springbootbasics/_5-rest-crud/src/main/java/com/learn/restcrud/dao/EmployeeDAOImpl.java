package com.learn.restcrud.dao;

import com.learn.restcrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeDAOImpl implements EmployeeDAO{

    private final EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employeeList = theQuery.getResultList();

        return employeeList;
    }

    @Override
    public Employee findById(int theId) {
        Employee employee = entityManager.find(Employee.class,theId);
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        Employee employee = entityManager.find(Employee.class,theId);
        entityManager.remove(employee);
    }
}
