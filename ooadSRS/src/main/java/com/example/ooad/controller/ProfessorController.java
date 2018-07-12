package com.example.ooad.controller;

import com.example.ooad.action.ProfessorAction;
import com.example.ooad.domain.Professor;
import com.example.ooad.domain.Section;
import com.example.ooad.service.ProfessorService;
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
public class ProfessorController {

    @Autowired
    ProfessorAction professorAction;
    @Autowired
    ProfessorService professorService;
    @Autowired
    SectionService sectionService;

    @RequestMapping(value = "teacher")
    public String professorHtml(HttpSession session){
        String userSsn=(String)session.getAttribute("userSsn");
        List<Section> sectionList= sectionService.getSectionByProfessorSsn(userSsn);
        Professor userRight=professorService.selectProfessorBySsn(userSsn);
        session.setAttribute("userRight",userRight);
        session.setAttribute("sectionList",sectionList);
        return "teacher";
    }

    @RequestMapping(value = "teacherSectionChoose")
    public String teacherSectionChoose(HttpSession session){
        String userSsn=(String)session.getAttribute("userSsn");
        List<Section> sectionList=professorAction.getSectionCouldBeChoose(userSsn);
        session.setAttribute("sectionList",sectionList);
        return "teacherSectionChoose";
    }

    @RequestMapping(value = "professorChooseSection")
    public String professorChooseSection(HttpSession session,String sectionIfOrNot,int sectionNo){
        String userSsn=(String)session.getAttribute("userSsn");
        professorAction.professorChooseSectionSwitch(sectionNo,userSsn,sectionIfOrNot);
        return "redirect:/teacherSectionChoose";
    }

}
