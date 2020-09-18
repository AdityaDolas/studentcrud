package com.example.demo.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    
    public List<Student> findAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students;
    }
    
    public Optional<Student> findStudentById(int studentId){
        Optional<Student> student = studentRepository.findById(studentId);
        return student;
    }
    
    
    public Student saveStudent(Student student) {
        student = studentRepository.save(student);
        return student;
    }
    
    public String deleteStudentById(int studentId) {
        studentRepository.deleteById(studentId);
        return studentId + " deleted";
    }
}
