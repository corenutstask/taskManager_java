package com.corenuts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corenuts.dto.StudentDTO;
import com.corenuts.entity.StudentDetails;
import com.corenuts.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentService(StudentRepository studentRepository,StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper=studentMapper;
    }

  
    public StudentDTO createStudent(StudentDTO studentDetailsDTO) {
        StudentDetails studentEntity = studentMapper.convertToEntity(studentDetailsDTO);
        StudentDetails savedStudent = studentRepository.save(studentEntity);
        return studentMapper.convertToDTO(savedStudent);
    }

    
    public StudentDTO getStudentById(int studentId) {
        Optional<StudentDetails> optionalStudent = studentRepository.findById(studentId);
        return optionalStudent.map(stude->{
        return studentMapper.convertToDTO(stude);
        }).orElse(null);
        
    }

    public List<StudentDTO> getAllStudents() {
        List<StudentDetails> studentList = studentRepository.findAll();
        return studentList.stream().map(stude->{
            return studentMapper.convertToDTO(stude);
            }).collect(Collectors.toList());
    }


    public StudentDTO updateStudent(int studentId, StudentDTO studentDetailsDTO) {
        Optional<StudentDetails> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            StudentDetails existingStudent = optionalStudent.get();

            // Update the fields of the existingStudent with studentDetailsDTO
            existingStudent.setStudent_name(null);
            existingStudent.setEmail(null);
            existingStudent.setPassword(studentDetailsDTO.getPassword());
            existingStudent.setStatus(studentDetailsDTO.getStatus());

           studentRepository.save(existingStudent);
            return studentMapper.convertToDTO(existingStudent);
        }
        return null;
    }

    public void deleteStudent(int studentId) {
        studentRepository.deleteById(studentId);
    }
}








   

