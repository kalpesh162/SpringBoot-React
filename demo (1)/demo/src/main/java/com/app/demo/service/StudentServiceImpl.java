package com.app.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.app.demo.entity.Student;
import com.app.demo.repos.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;

	@Override
	public Student saveStudent(Student student) {
		return repository.save(student);
	}

	@Override
	public Page<Student> getAllStudents(int page, int size) {
		return repository.findAll(PageRequest.of(page, size));
	}

	@Override
	public Student getStudentById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
	}

	@Override
	public Student updateStudent(Long id, Student student) {
		Student existing = getStudentById(id);
		existing.setName(student.getName());
		existing.setAge(student.getAge());
		existing.setCourse(student.getCourse());
		return repository.save(existing);
	}

	@Override
	public void deleteStudent(Long id) {
		repository.deleteById(id);
	}
}
