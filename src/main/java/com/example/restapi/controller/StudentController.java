package com.example.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.entity.Student;
import com.example.restapi.service.IStudentService;

@RestController
public class StudentController {

	@Autowired
	IStudentService repo;

	//get all the students
	@GetMapping("/students")
	public List<Student> getAllStudents()
	{
		List<Student> list=repo.findAll();
		return list;
		
	}
	
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable int id)
	{
		Student stu=repo.findById(id).get();
		return stu;
		
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void insertStudent(@RequestBody Student student)
	{
		repo.save(student);
		
	}
	
	
	@PutMapping("/update/{id}")
	public Student updateStudent(@PathVariable int id)
	{
		Student student=repo.findById(id).get();
		student.setName("Poonam");
		student.setPercentage(92);
		repo.save(student);
		return student;
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable int id)
	{
		Student student=repo.findById(id).get();
		repo.delete(student);
	}
	
}
