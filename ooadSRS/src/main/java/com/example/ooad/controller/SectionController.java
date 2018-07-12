package com.example.ooad.controller;

import com.example.ooad.domain.Course;
import com.example.ooad.domain.Section;
import com.example.ooad.service.CourseService;
import com.example.ooad.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by asus on 2018/6/30.
 */
@Controller
public class SectionController {

    @Autowired
    SectionService sectionService;
    @Autowired
    CourseService courseService;

    @RequestMapping(value="teacherSectionArrange")
    public String teacherSectionArrangeHtml(HttpSession session){
        List<Course> courses=courseService.getAllCourse();
        List<Section> section=sectionService.getAllSection();
        session.setAttribute("courses",courses);
        session.setAttribute("section",section);
        return "teacherSectionArrange";
    }
    @RequestMapping(value="SectionAdd")
    public String SectionAdd(String dayOfWeek,String timeOfDay,String room,int capacity,String courseNumber){
        sectionService.insertSection(dayOfWeek,timeOfDay,room,capacity,courseNumber);
        return "redirect:/teacherSectionArrange";
    }

    @RequestMapping(value = "SectionDelete")
    public String SectionDelete(int sectionNo){
        sectionService.deleteSectionBySectionNo(sectionNo);
        return "redirect:/teacherSectionArrange";
    }
}
