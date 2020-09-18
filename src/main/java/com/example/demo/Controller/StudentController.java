package com.example.demo.Controller;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {
    
    @Autowired
    StudentService studentService;
    
    // findAll
    @GetMapping("/students")
    public List<Student> findAllStudents(){
        return studentService.findAllStudents();
    }
    
    // findById
    @GetMapping("/students/{studentId}")
    public Optional<Student> findStudentById(int studentId){
        Optional<Student> students = studentService.findStudentById(studentId) != null ? studentService.findStudentById(studentId) : null;
        return students;
    }
    
    // addStudent
    @PostMapping("/addStudent")
    public Student addStudentById(Student student){
        student.setId(0);
        return studentService.saveStudent(student);
    }
    
    // updateStudent
    @PostMapping("/updateStudent")
    public Student updateStudentById(Student student){
        student = studentService.saveStudent(student);
        return student;
    }
    
    // deleteStudent
    @DeleteMapping("/student/{studentId}")
    public String deleteStudentById(int studentId){
        Optional<Student> student = studentService.findStudentById(studentId);
        return studentService.deleteStudentById(studentId);
    }
}
