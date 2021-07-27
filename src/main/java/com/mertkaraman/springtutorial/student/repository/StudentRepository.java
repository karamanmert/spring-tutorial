package com.mertkaraman.springtutorial.student.repository;

import com.mertkaraman.springtutorial.student.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    //@Query("SELECT s FROM Student s WHERE s.email=?1")  --> //SAME
    Optional<StudentEntity> findStudentByEmail(String email);
}
