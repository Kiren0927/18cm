package com.example.homework.service.impl;

import com.example.homework.common.R;
import com.example.homework.mapper.CourseMapper;
import com.example.homework.pojo.Course;
import lombok.extern.slf4j.Slf4j;
import com.example.homework.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.homework.pojo.User;
import com.example.homework.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class userServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public R<User> login(int num,String psw) {
        User user = userMapper.selectOneUser(num);
        if (user == null){
            log.info("用户名不存在");
            return  R.error("用户名不存在");
        }
        //若存在，进行密码比对
        String userPsw = user.getUserPsw();
        if (!psw.equals(userPsw)){
            log.info("密码错误");
            return  R.error("密码错误");
        }
        //登陆成功
        return R.success(user);
    }

    @Override
    public R<List<Course>> selectCourse(int userNum) {
        User user = userMapper.selectOneUser(userNum);
        if (user.getUserType() == 1){
            List<Course> courseList = courseMapper.findCourseByUserNum(user.getUserNum());
            if (courseList.isEmpty()){
                return R.error("未选课");
            }
            return R.success(courseList);
        }
        if (user.getUserType() == 2){
            List<Course> courseList = courseMapper.teacherFindCourseByUserNum(user.getUserNum());
            if (courseList.isEmpty()){
                return R.error("您未授课");
            }
            return R.success(courseList);
        }
        return R.error("error");
    }


}
