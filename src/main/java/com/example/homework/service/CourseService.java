package com.example.homework.service;

import com.example.homework.common.R;
import com.example.homework.pojo.Course;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    R<Course> findCourseByNum(int num);

    R<PageInfo<Course>> findAllCourse(int pageNum, int pageSize);

    R<String> insertCourse(Course course);

    R<String> deleteCourse(int num);

    R<String> updateCourse(Course course);
}
