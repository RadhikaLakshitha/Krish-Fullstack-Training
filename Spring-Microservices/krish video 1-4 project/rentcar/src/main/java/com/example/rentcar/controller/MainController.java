package com.example.rentcar.controller;

import com.example.rentcar.model.Student;
import com.example.rentcar.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Autowired
    StudentServiceImpl studentService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String greeting(){
        return "Hello";
    }
    
   

    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public Student save(@RequestBody Student student){
       return studentService.save(student);
    }

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public ResponseEntity<Student> fetchStudent(@RequestParam int id){
        Student student = studentService.fetchStudentById(id);
        if (student==null){
           return ResponseEntity.notFound().build();
        }else {
           return ResponseEntity.ok().body(student);
        }
    }
}
