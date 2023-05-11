package com.bjit.main.service;

import com.bjit.main.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
//@Service
public class StudentService {

    List<Student> students = new ArrayList<>();

    public StudentService() {
        students.add(new Student(1, "Alice", 18, "123 Main St"));
        students.add(new Student(2, "Bob", 19, "456 Oak Ave"));
        students.add(new Student(3, "Charlie", 20, "789 Elm St"));
        students.add(new Student(4, "David", 21, "321 Pine St"));
        students.add(new Student(5, "Eve", 22, "654 Maple Ave"));
    }

    public ResponseEntity<Object> getAllStudent(){

        return new ResponseEntity<>(students, HttpStatus.OK);

    }
}
