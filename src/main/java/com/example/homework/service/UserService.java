package com.example.homework.service;

import com.example.homework.common.R;
import org.springframework.stereotype.Service;
import com.example.homework.pojo.User;

@Service
public interface UserService {

    R<User> login(int num,String psw);
}
