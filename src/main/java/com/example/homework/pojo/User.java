package com.example.homework.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class User {
    private int userNum;
    private String userSex;
    private String userName;
    private String userPsw;
    private long userPhone;
    private int userType;
}
