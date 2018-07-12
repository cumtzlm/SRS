package com.example.ooad.action;

import com.example.ooad.domain.Section;
import com.example.ooad.domain.Student;
import com.example.ooad.service.ScoreService;
import com.example.ooad.service.SectionService;
import com.example.ooad.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2018/6/28.
 */
@Component
public class StudentAction {

    @Autowired
    SectionService sectionService;
    @Autowired
    ScoreService scoreService;
    @Autowired
    StudentService studentService;

    //根据学生Ssn查询课程是否可选
    public List<Section> selectEnrolledStudents(String studentSsn){
        List<Section> sectionList=sectionService.getAllSection();
        List<Section> sections=new ArrayList<>();
        for(Section section:sectionList){
            if(section.getProfessor()!=null){
                if(section.getEnrolledStudents().size()>0){
                    int num=0;
                    for(Student student:section.getEnrolledStudents()){
                        if(student.getSsn().equals(studentSsn)){
                            section.setCouldBeChooseByStudent("no");
                            sections.add(section);
                            break;
                        }
                        num=num+1;
                        if(num==section.getEnrolledStudents().size()){
                            section.setCouldBeChooseByStudent("yes");
                            sections.add(section);
                        }
                    }
                    }
                else {
                    section.setCouldBeChooseByStudent("yes");
                    sections.add(section);
                }
                }
        }
        return sections;
    }

    //根据规约实现选课切换

    public String studentChooseSectionSwitchTwo(int sectionNo,String studentSsn,String sectionIfOrNot){
        if(sectionIfOrNot.equals("chooseSection")){
            Section section=sectionService.getSectionBySectionNo(sectionNo);
            Student student=studentService.getStudentBySsnOnly(studentSsn);
            String result=section.canChoose(student);
            if(result.equals("选课成功")){
                scoreService.insertScoreStudent(studentSsn,sectionNo);
                result="选课成功！";
            }else{
                return result;
            }
            return result;
        }else {
            scoreService.deleteScoreStudent(studentSsn,sectionNo);
            return "退课成功！";
        }

    }
}
