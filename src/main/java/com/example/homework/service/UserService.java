package com.example.homework.service;

import com.example.homework.common.R;
import com.example.homework.pojo.Course;
import org.springframework.stereotype.Service;
import com.example.homework.pojo.User;

import java.util.List;

@Service
public interface UserService {

    R<User> login(int num,String psw);

    R<List<Course>> selectCourse(int userNum);


}
