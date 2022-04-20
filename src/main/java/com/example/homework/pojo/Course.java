package com.example.homework.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Course {
    private int courseNum;
    private String courseName;
    private String courseBeginTime;
    private String courseEndTime;
    private int userNum ;
}
