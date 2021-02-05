package com.example.demo.controller;

import java.util.List;

import com.example.demo.bean.Course;
import com.example.demo.jpa.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/course/{id}")
    public Course getAllCourses(@PathVariable long id) {
        return courseRepository.findById(id);
    }
}
