package com.example.homework.mapper;

import com.example.homework.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseMapper {

    Course findCourseByNum(int num);

    List<Course> findAllCourse();

    void insertCourse(Course course);

    void deleteCourse(int num);

    void updateCourse(Course course);

    List<Course> findCourseByUserNum(int userNum);


    List<Course> teacherFindCourseByUserNum(int userNum);
}
