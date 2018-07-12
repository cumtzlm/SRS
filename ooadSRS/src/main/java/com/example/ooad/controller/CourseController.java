package com.example.ooad.controller;

import com.example.ooad.action.CourseAction;
import com.example.ooad.domain.Course;
import com.example.ooad.domain.Section;
import com.example.ooad.service.CourseService;
import com.example.ooad.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by asus on 2018/6/28.
 */
@Controller
public class CourseController {
    @Autowired
    CourseService courseService;
    @Autowired
    CourseAction courseAction;
    @Autowired
    SectionService sectionService;

    @RequestMapping(value="teacherCourseManageList")
    public String ProfessorIndex(HttpSession session){
        List<Course> allCourse=courseService.getAllCourse();
        session.setAttribute("allCourse",allCourse);
        return "teacherCourseManageList";
    }
    @RequestMapping(value="teacherCourseManageListPrev")
    public String teacherCourseManageListPrev(String number,HttpSession session){
        List<Course> prevCourse=courseService.selectPrevCourseByNumber(number);
        List<Course> prevCourseHaveNoChoose=courseAction.prevCourseHaveNoChoose(number);
        session.setAttribute("prevCourseHaveNoChoose",prevCourseHaveNoChoose);
        session.setAttribute("courseNumber",number);
        session.setAttribute("prevCourse",prevCourse);
        return "teacherCourseManageListPrev";
    }
    @RequestMapping(value="PrevCourseAdd")
    public String prevCourseAdd(String courseNumber,String prevCourseNumber,HttpSession session){
        courseService.insertPrevCourse(courseNumber,prevCourseNumber);
        String courseNumber1=(String)session.getAttribute("courseNumber");
        return "redirect:/teacherCourseManageListPrev?number="+courseNumber1;
    }

    @RequestMapping(value="CourseAdd")
    public String CourseAdd(String number,String name,double credits,@RequestParam(required = false, value = "prevCourseNumber")List<String> prevCourseNumber){
        courseAction.addCourse(number,name,credits,prevCourseNumber);
        return "redirect:/teacherCourseManageList";
    }
    @RequestMapping(value="CourseDelete")
    public String CourseDelete(String number){
        courseAction.deleteCourseAndPrevCourseByNumber(number);
        return "redirect:/teacherCourseManageList";
    }
    @RequestMapping(value="prevCourseDelete")
    public String prevCourseDelete(String number,HttpSession session){
        String courseNumber=(String)session.getAttribute("courseNumber");
        courseService.deletePrevCourseByPrevNumber(number);
        return "redirect:/teacherCourseManageListPrev?number="+courseNumber;
    }

    @RequestMapping(value="CourseUpdate")
    public String CourseUpdate(@RequestParam(value ="numberUpdate" ,required = false)String numberUpdate,@RequestParam(value ="nameUpdate",required = false )String nameUpdate,@RequestParam(value ="creditsUpdate",required = false )double creditsUpdate){
        courseService.updateCourse(numberUpdate,nameUpdate,creditsUpdate);
        return "redirect:/teacherCourseManageList";
    }


    @RequestMapping(value="teacherCourseManageListSecond")
    public String ProfessorourseManageListSecond(HttpSession session,String courseNumber){
        List<Section> sectionByCourseNumber= sectionService.getAllSectionByCourseNumber(courseNumber);
        session.setAttribute("sectionByCourseNumber",sectionByCourseNumber);
        return "teacherCourseManageListSecond";
    }
}
