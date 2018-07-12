package com.example.ooad.service.serviceimpl;

import com.example.ooad.dao.CourseMapper;
import com.example.ooad.domain.Course;
import com.example.ooad.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by asus on 2018/6/29.
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<Course> getAllCourse() {
        return courseMapper.getAllCourse();
    }

    @Override
    public Course selectCourseByNum(String number) {
        return courseMapper.selectCourseByNum(number);
    }

    @Override
    public List<Course> selectPrevCourseByNumber(String number) {
        return courseMapper.selectPrevCourseByNumber(number);
    }

    @Override
    public void insertCourse(Course course) {
        courseMapper.insertCourse(course);
    }

    @Override
    public void insertPrevCourse(String number, String prev_number) {
        courseMapper.insertPrevCourse(number,prev_number);
    }

    @Override
    public void deleteCourseByNumber(String number) {
        courseMapper.deleteCourseByNumber(number);
    }

    @Override
    public void deletePrevCourseByNumber(String number) {
        courseMapper.deletePrevCourseByNumber(number);
    }

    @Override
    public void deletePrevCourseByPrevNumber(String number) {
        courseMapper.deletePrevCourseByPrevNumber(number);
    }

    @Override
    public void updateCourse(String number, String name, double credits) {
        courseMapper.updateCourse(number,name,credits);
    }

    @Override
    public List<Course> selectByStudentSn(String ssn) {
        return courseMapper.selectByStudentSn(ssn);
    }
}
