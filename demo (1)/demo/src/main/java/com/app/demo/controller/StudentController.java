package com.app.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.entity.Student;
import com.app.demo.service.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return service.saveStudent(student);
	}

	@GetMapping
	public Page<Student> getStudents(@RequestParam int page, @RequestParam int size) {
		return service.getAllStudents(page, size);
	}

	@GetMapping("/{id}")
	public Student getStudent(@PathVariable Long id) {
		return service.getStudentById(id);
	}

	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
		return service.updateStudent(id, student);
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		service.deleteStudent(id);
	}
}
