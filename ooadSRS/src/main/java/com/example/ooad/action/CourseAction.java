package com.example.ooad.action;

import com.example.ooad.domain.Course;
import com.example.ooad.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2018/6/29.
 */
@Component
public class CourseAction {

    @Autowired
    CourseService courseService;

    public void addCourse(String number,String name,double credits,List<String> prevCourseNumber){
        if(prevCourseNumber!=null){
            Course course=new Course();
            course.setName(name);
            course.setNumber(number);
            course.setCredits(credits);
            courseService.insertCourse(course);
            for(String prevCourseNumber1:prevCourseNumber){
                courseService.insertPrevCourse(number,prevCourseNumber1);
            }
        }else {
            Course course=new Course();
            course.setName(name);
            course.setNumber(number);
            course.setCredits(credits);
            courseService.insertCourse(course);
        }

    }

    public void deleteCourseAndPrevCourseByNumber(String number){
        courseService.deleteCourseByNumber(number);
        List<Course> courses=courseService.selectPrevCourseByNumber(number);
        for(Course course:courses){
            courseService.deletePrevCourseByPrevNumber(course.getNumber());
        }
    }
    public List<Course> prevCourseHaveNoChoose(String number){
        List<Course> courses= courseService.selectPrevCourseByNumber(number);
        List<Course> courseList=courseService.getAllCourse();
        List<Course>courseListRest=new ArrayList<>();
        outer:
        for(Course course:courseList){
            for(Course course1:courses){
                if(course.getNumber().equals(course1.getNumber())) {
                    continue outer;
                }
            }
            courseListRest.add(course);
        }
        return courseListRest;
    }
}
