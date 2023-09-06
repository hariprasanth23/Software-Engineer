package com.learn.restAPI.rest;

import com.learn.restAPI.entity.Student;
import com.learn.restAPI.entity.StudentErrorResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> studentList;

    @PostConstruct
    public void loadData(){

        studentList = new ArrayList<>();

        studentList.add(Student.builder().firstName("hari1").lastName("prasanth1").build());
        studentList.add(Student.builder().firstName("hari2").lastName("prasanth2").build());
        studentList.add(Student.builder().firstName("hari3").lastName("prasanth3").build());
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentList;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if(studentId >= studentList.size() || studentId<0){
            throw new StudentNotFoundException("Student id not found - "+ studentId);
        }
        return studentList.get(studentId);
    }


}
