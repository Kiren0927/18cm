package com.example.homework.mapper;

import com.example.homework.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    User selectOneUser(int num);

}
