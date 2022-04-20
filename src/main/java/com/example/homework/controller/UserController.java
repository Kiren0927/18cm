package com.example.homework.controller;

import com.example.homework.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.homework.pojo.User;
import com.example.homework.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //登录

    /**
     * 登录
     * @param user 用户名与密码
     * @param req 用于存Session
     * @return
     */
    @PostMapping("/login")
    public R<User> login(@RequestBody User user, HttpServletRequest req){
        System.out.println(user);
        R<User> r = userService.login(user.getUserNum(),user.getUserPsw());
        if(r.getData() != null){
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
        }
        return r;
    }

    /**
     * 登出
     * @param req 用于存删Session里的Attribute
     * @return
     */
    @PostMapping("/loginOut")
    public R<String> loginOut(HttpServletRequest req){
        HttpSession session = req.getSession();
        if (session.getAttribute("user") != null){
            session.removeAttribute("user");
            return R.success("退出成功");
        }
        session.removeAttribute("user");
        return R.error("未登录");
    }
}
