package com.example.ooad.controller;

import com.example.ooad.action.StudentAction;
import com.example.ooad.domain.Course;
import com.example.ooad.domain.Score;
import com.example.ooad.domain.Section;
import com.example.ooad.service.CourseService;
import com.example.ooad.service.ScoreService;
import com.example.ooad.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by asus on 2018/6/30.
 */
@Controller
public class StudentController {
    @Autowired
    SectionService sectionService;
    @Autowired
    StudentAction studentAction;
    @Autowired
    ScoreService scoreService;
    @Autowired
    CourseService courseService;

    @RequestMapping(value = "student")
    public String studentHtml(){
        return "student";
    }

    @RequestMapping(value = "studentSectionChoose")
    public String studentSectionChooseHtml(HttpSession session,Model model){
        String userSsn=(String)session.getAttribute("userSsn");
        List<Section> sectionList=studentAction.selectEnrolledStudents(userSsn);
        session.setAttribute("sectionList",sectionList);
        String message=(String)session.getAttribute("meg");
        model.addAttribute("message",message);
        session.setAttribute("meg","");
        return "studentSectionChoose";
    }
    @RequestMapping(value = "studentChooseSection")
    public String studentChooseSection(int sectionNo,String sectionIfOrNot,HttpSession session){
        String userSsn=(String)session.getAttribute("userSsn");
        String meg=studentAction.studentChooseSectionSwitchTwo(sectionNo,userSsn,sectionIfOrNot);
        session.setAttribute("meg",meg);
        return "redirect:/studentSectionChoose";
    }

    @RequestMapping(value = "studentSectionScoreQuery")
    public String studentSectionScoreQuery(HttpSession session){
        String userSsn=(String)session.getAttribute("userSsn");
        List<Score> scoreList=scoreService.getScoreSectionByStudentSsn(userSsn);
        session.setAttribute("scoreList",scoreList);
        return "studentSectionScoreQuery";
    }

    @RequestMapping(value = "studentPlanOfStudyQuery")
    public String studentPlanOfStudyQuery(HttpSession session){
        String userSsn=(String)session.getAttribute("userSsn");
        List<Course> course =courseService.selectByStudentSn(userSsn);
        session.setAttribute("course",course);
        return "studentPlanOfStudyQuery";
    }
}
