package com.example.ooad.service;

import com.example.ooad.domain.Course;

import java.util.List;

/**
 * Created by asus on 2018/6/29.
 */
public interface CourseService {

    List<Course> getAllCourse();

    Course selectCourseByNum(String number);

    List<Course> selectPrevCourseByNumber(String number);

    void insertCourse(Course course);

    void insertPrevCourse(String number, String prev_number);

    void deleteCourseByNumber(String number);

    void deletePrevCourseByNumber(String number);

    void deletePrevCourseByPrevNumber(String number);

    void updateCourse(String number,String name,double credits);

    List<Course> selectByStudentSn(String ssn);

}
