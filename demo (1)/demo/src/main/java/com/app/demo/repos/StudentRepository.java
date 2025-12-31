package com.app.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
