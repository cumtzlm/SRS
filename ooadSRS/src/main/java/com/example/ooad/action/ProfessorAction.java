package com.example.ooad.action;

import com.example.ooad.domain.Section;
import com.example.ooad.service.ProfessorService;
import com.example.ooad.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2018/6/30.
 */
@Component
public class ProfessorAction extends Section {

    @Autowired
    SectionService sectionService;
    @Autowired
    ProfessorService professorService;

    //教师查询可操作课程（包括未被教师选择的课程与被自己选择的课程）
    public List<Section> getSectionCouldBeChoose(String userSsn){
        List<Section> sectionList=sectionService.getAllSection();
        List<Section> sectionCouldBeChoose=new ArrayList<>();
        for(Section section:sectionList){
            if(section.getProfessor()!=null){
                if(section.getProfessor().getSsn().equals(userSsn)){
                    sectionCouldBeChoose.add(section);
                }
            }else {
                sectionCouldBeChoose.add(section);
            }
        }
        return sectionCouldBeChoose;
    }

    public void professorChooseSectionSwitch(int sectionNo,String professorSsn,String sectionIfOrNot){
        if(sectionIfOrNot.equals("chooseSection")){
            professorService.sectionIn(sectionNo,professorSsn);
            professorService.insertProfessorTeaches(sectionNo,professorSsn);
        }else {
            professorService.sectionOut(sectionNo);
            professorService.deleteProfessorTeaches(sectionNo,professorSsn);
        }

    }
}
