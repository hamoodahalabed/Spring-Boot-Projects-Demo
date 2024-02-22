package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//rest service
@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData () {

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Mohammad","Alabed"));
        theStudents.add(new Student("Boshra","Shaheer"));
        theStudents.add(new Student("Jad","Hamze"));

    }

    @GetMapping("/students")
    public List<Student> getStudents () {


        return theStudents;
    }

    //                     {} mean in request u will accept value (index)
    //                     {studentId} is path variable
    @GetMapping("/students/{studentId}")        // must match
    public Student getStudent(@PathVariable int studentId) {

        if(studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);
    }


}
