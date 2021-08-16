package com.mertkaraman.springtutorial.student.controller;

import com.mertkaraman.springtutorial.student.entity.Student;
import com.mertkaraman.springtutorial.student.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentController {

    private final StudentServiceImpl studentService;

    @Autowired
    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = studentService.getStudents();
        return ResponseEntity.status(HttpStatus.OK).body(students);  //  //return ResponseEntity.ok(students);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //for delete and put, status can be 204(no content) or 200 (OK)
    //HTTP 200 OK: Standard response for successful HTTP requests. The actual response will depend on the request method used.
    //HTTP 204 No Content: The server successfully processed the request, but is not returning any content
    @DeleteMapping(path = "/delete/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(path = "/update/{studentId}")
    public ResponseEntity<Void> updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
