package com.example.homework.service.impl;

import com.example.homework.common.R;
import com.example.homework.mapper.CourseMapper;
import com.example.homework.mapper.UserMapper;
import com.example.homework.pojo.Course;
import com.example.homework.pojo.User;
import com.example.homework.service.CourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public R<Course> findCourseByNum(int num) {
        Course course = courseMapper.findCourseByNum(num);
        //判断是否存在该课程号
        if (course == null){
            return R.error("该课程不存在");
        }
        return R.success(course);
    }

    @Override
    public R<PageInfo<Course>> findAllCourse(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Course> courseList =  courseMapper.findAllCourse();
        PageInfo<Course> pageInfo = new PageInfo<>(courseList);
        return R.success(pageInfo);
    }

    @Override
    public R<String> insertCourse(@RequestBody Course course) {
        if (courseMapper.findCourseByNum(course.getCourseNum()) != null){
            return R.error("该课程号已存在");
        }
        User user = userMapper.selectOneUser(course.getUserNum());
        if (user == null){
            return R.error("该用户名不存在");
        }else if (user.getUserType() != 2){
            return R.error("该用户不为教师");
        }
        courseMapper.insertCourse(course);
        return R.success("添加成功");
    }

    @Override
    public R<String> deleteCourse(int num) {
        if (courseMapper.findCourseByNum(num) == null ){
            return R.error("该课程不存在");
        }
        courseMapper.deleteCourse(num);
        return R.success("删除成功");
    }

    @Override
    public R<String> updateCourse(Course course) {
        //课程号是否存在
        int courseNum = course.getCourseNum();
        if (courseMapper.findCourseByNum(courseNum) == null){
            return R.error(" 课程不存在");
        }
        //用户名是否存在
        if (userMapper.selectOneUser(course.getUserNum()) == null){
            return R.error("该用户不存在");
        }
        //type是否为2
        if (userMapper.selectOneUser(course.getUserNum()).getUserType() != 2){
            return R.error("该用户不是教师");
        }
        courseMapper.updateCourse(course);
        return R.success("修改成功");
    }
}
