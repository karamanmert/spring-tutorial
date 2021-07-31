package com.mertkaraman.springtutorial.student.controller;

import com.mertkaraman.springtutorial.student.entity.StudentEntity;
import com.mertkaraman.springtutorial.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String hello(){
        return "hello";
    }

    @GetMapping
    public ResponseEntity<List<StudentEntity>> getStudents() {
        List<StudentEntity> students = studentService.getStudents();
        return ResponseEntity.status(HttpStatus.OK).body(students);  //  //return ResponseEntity.ok(students);
    }

    @PostMapping
    public ResponseEntity<Void> registerNewStudent(@RequestBody StudentEntity student) {
        studentService.addNewStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //for delete and put, status can be 204(no content) or 200 (OK)
    //HTTP 200 OK: Standard response for successful HTTP requests. The actual response will depend on the request method used.
    //HTTP 204 No Content: The server successfully processed the request, but is not returning any content
    @DeleteMapping(path = "{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(path = "{studentId}")
    public ResponseEntity<Void> updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


//    @GetMapping
//    public List<StudentEntity> getStudents() {
//        return studentService.getStudents();
//    }
//
//    @PostMapping
//    public void registerNewStudent(@RequestBody StudentEntity student) {
//        studentService.addNewStudent(student);
//    }
//
//    @DeleteMapping(path = "{studentId}")
//    public void deleteStudent(@PathVariable("studentId") Long studentId) {
//        studentService.deleteStudent(studentId);
//    }
//
//    @PutMapping(path = "{studentId}")
//    public void updateStudent(@PathVariable("studentId") Long studentId,
//                              @RequestParam(required = false) String name,
//                              @RequestParam(required = false) String email) {
//        studentService.updateStudent(studentId, name, email);
//    }
}
