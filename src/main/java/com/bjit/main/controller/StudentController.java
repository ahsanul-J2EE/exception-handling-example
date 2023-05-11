package com.bjit.main.controller;


import com.bjit.main.exception.AdminNotFoundException;
import com.bjit.main.exception.StudentNotFoundException;
import com.bjit.main.model.Candidate;
import com.bjit.main.model.Student;
import com.bjit.main.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

//    @Autowired
//    StudentService studentService;

    List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(1, "Alice", 18, "123 Main St"));
        students.add(new Student(2, "Bob", 19, "456 Oak Ave"));
        students.add(new Student(3, "Charlie", 20, "789 Elm St"));
        students.add(new Student(4, "David", 21, "321 Pine St"));
        students.add(new Student(5, "Eve", 22, "654 Maple Ave"));
    }


    @GetMapping("/get-all-student")
    public ResponseEntity<Object> getAllStudent() {


        return new ResponseEntity<>(students, HttpStatus.OK);


    }



    @GetMapping("/student-info/{id}")
    public ResponseEntity<Object> getCandidateInfo(@PathVariable Integer id) {

        for (Student student : students) {
            if (student.getId() == id) {
                return new ResponseEntity<>(student, HttpStatus.OK);
            }
        }

        throw new StudentNotFoundException("Student not found");
    }

    @PostMapping("/create-student")
    public ResponseEntity<Object> createStudent(@RequestBody Student student) {

        if(student.getId()>0 && student.getName()!=null && student.getAge()>0 && student.getsubject()!=null){
            System.out.println(student.getId());
            students.add(student);

            return new ResponseEntity<>("Student profile created successfully", HttpStatus.CREATED);
        }


        throw new StudentNotFoundException("Insert Data perfectly");

    }

    @GetMapping("/some-method")
    public ResponseEntity<Object> someMethod() {
        throw new ArithmeticException("Error");
    }

}
