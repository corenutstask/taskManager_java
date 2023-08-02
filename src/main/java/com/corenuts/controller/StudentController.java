package com.corenuts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.corenuts.dto.StudentDTO;
import com.corenuts.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Endpoint to create a new student
    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDetailsDTO) {
        StudentDTO createdStudent = studentService.createStudent(studentDetailsDTO);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }
    

    // Endpoint to get a student by ID
    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable int studentId) {
        StudentDTO studentDTO = studentService.getStudentById(studentId);
        if (studentDTO != null) {
            return new ResponseEntity<>(studentDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to get all students
    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> studentsDTO = studentService.getAllStudents();
        return new ResponseEntity<>(studentsDTO, HttpStatus.OK);
    }

    // Endpoint to update a student by ID
    @PutMapping("/{studentId}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable int studentId, @RequestBody StudentDTO studentDetailsDTO) {
        StudentDTO updatedStudent = studentService.updateStudent(studentId, studentDetailsDTO);
        if (updatedStudent != null) {
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint to delete a student by ID
    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int studentId) {
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
