package com.example.ooad.service;

import com.example.ooad.domain.Student;

import java.util.List;

/**
 * Created by asus on 2018/6/30.
 */
public interface StudentService {

    Student getStudentBySsn(String ssn, String password);

    Student getStudentBySsnOnly( String ssn);

    List<Student> selectStudentBySectionNo(int sectionNo);
}
