package com.example.ooad.controller;

import com.example.ooad.dao.StudentMapper;
import com.example.ooad.domain.Score;
import com.example.ooad.domain.Student;
import com.example.ooad.service.ScoreService;
import com.example.ooad.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by asus on 2018/6/30.
 */
@Controller
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @RequestMapping(value="teacherSectionScore/{sectionNo}")
    public String teacherSectionScoreHtml(@PathVariable("sectionNo")int sectionNo, HttpSession session){
        List<Score> scoreList=scoreService.getStudentScoreBySectionNo(sectionNo);
        session.setAttribute("thisSectionNo",sectionNo);
        session.setAttribute("scoreList",scoreList);
        return "teacherSectionScore";
    }
    @RequestMapping(value="giveScore")
    public String giveScore(@RequestParam(value ="scoreId" ,required = false)int scoreId, double grade,HttpSession session){
//        session.getAttribute("thisSectionNo");
        scoreService.updateScoreStudent(scoreId,grade);
        return "redirect:/teacherSectionScore/"+session.getAttribute("thisSectionNo");
    }



}
