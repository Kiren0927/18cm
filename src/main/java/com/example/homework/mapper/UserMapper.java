package com.example.homework.mapper;

import com.example.homework.pojo.Course;
import com.example.homework.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    User selectOneUser(int num);

}
