package com.example.ooad.service;

import com.example.ooad.domain.Professor;

/**
 * Created by asus on 2018/6/30.
 */
public interface ProfessorService {

    void sectionOut(int sectionNo);

    void sectionIn(int sectionNo,String professorSsn);

    void insertProfessorTeaches(int sectionNo,String professorSsn);

    void deleteProfessorTeaches(int sectionNo,String professorSsn);

    Professor selectProfessorBySsn(String ssn);
}
