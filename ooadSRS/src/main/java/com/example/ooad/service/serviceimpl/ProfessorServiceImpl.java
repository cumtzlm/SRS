package com.example.ooad.service.serviceimpl;

import com.example.ooad.dao.ProfessorMapper;
import com.example.ooad.domain.Professor;
import com.example.ooad.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by asus on 2018/6/30.
 */
@Service
public class ProfessorServiceImpl implements ProfessorService {
    @Autowired
    ProfessorMapper professorMapper;
    @Override
    public void sectionOut(int sectionNo) {
        professorMapper.sectionOutSwtich(sectionNo);
    }

    @Override
    public void sectionIn(int sectionNo, String professorSsn) {
        professorMapper.sectionIn(sectionNo,professorSsn);
    }

    @Override
    public void insertProfessorTeaches(int sectionNo, String professorSsn) {
        professorMapper.insertProfessorTeaches(sectionNo,professorSsn);
    }

    @Override
    public void deleteProfessorTeaches(int sectionNo,String professorSsn) {
        professorMapper.deleteProfessorTeaches(sectionNo,professorSsn);
    }

    @Override
    public Professor selectProfessorBySsn(String ssn) {
        return professorMapper.selectProfessorBySsn(ssn);
    }
}
