package com.learn.cruddemo.dao;

import com.learn.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findByID(Integer id);

    List<Student> findAll();

    List<Student> findAllSortByLastName();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void delete(Integer id);

    int deleteAll();
}
