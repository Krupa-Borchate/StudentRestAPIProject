package com.example.restapi.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.entity.Student;

public interface IStudentService extends JpaRepository<Student, Integer>{

}
