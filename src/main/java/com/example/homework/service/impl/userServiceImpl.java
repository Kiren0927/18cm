package com.example.homework.service.impl;

import com.example.homework.common.R;
import lombok.extern.slf4j.Slf4j;
import com.example.homework.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.homework.pojo.User;
import com.example.homework.service.UserService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class userServiceImpl implements UserService {
    @Autowired
    public UserMapper userMapper;

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
}
