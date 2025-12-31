package com.app.demo.service;

import org.springframework.data.domain.Page;

import com.app.demo.entity.Student;

public interface StudentService {
	Student saveStudent(Student student);

	Page<Student> getAllStudents(int page, int size);

	Student getStudentById(Long id);

	Student updateStudent(Long id, Student student);

	void deleteStudent(Long id);
}
