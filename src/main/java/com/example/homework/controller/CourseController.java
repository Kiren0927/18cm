package com.example.homework.controller;

import com.example.homework.common.R;
import com.example.homework.pojo.Course;
import com.example.homework.service.CourseService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;
    /**
     * 根据课程编号查课
     * @param num 课程编号
     * @return
     */
    @GetMapping("/{num}")
    public R<Course> findCourseByNum(@PathVariable int num){
        R<Course> r = courseService.findCourseByNum(num);
        return r;
    }

    /**
     * 查所有课，并分页
     * @param pageNum 第几页
     * @return
     */
    @GetMapping("/page/{pageNum}")
    public R<PageInfo<Course>> findAllCourse(@PathVariable int pageNum){
        int pageSize = 8;
        R<PageInfo<Course>> r = courseService.findAllCourse(pageNum,pageSize);
        return r;
    }

    @PostMapping
    public R<String> insertCourse(@RequestBody Course course){
        R<String> r = courseService.insertCourse(course);
        return r;
    }

    @DeleteMapping("/{num}")
    public R<String> deleteCourse(@PathVariable int num){
        R<String> r = courseService.deleteCourse(num);
        return r;
    }

    @PutMapping
    public R<String> updateCourse(@RequestBody Course course){
        R<String> r = courseService.updateCourse(course);
        return r;
    }
}
