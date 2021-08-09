package com.mertkaraman.springtutorial.student.repository;

import com.mertkaraman.springtutorial.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    //@Query("SELECT s FROM Student s WHERE s.email=?1")  --> //SAME
    Optional<Student> findStudentByEmail(String email);
}
