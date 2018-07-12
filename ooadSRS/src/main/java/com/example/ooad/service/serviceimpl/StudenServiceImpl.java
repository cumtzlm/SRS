package com.example.ooad.service.serviceimpl;

import com.example.ooad.dao.StudentMapper;
import com.example.ooad.domain.Student;
import com.example.ooad.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by asus on 2018/6/30.
 */
@Service
public class StudenServiceImpl implements StudentService{

    @Autowired
    StudentMapper studentMapper;
    @Override
    public Student getStudentBySsn(String ssn, String password) {
        return studentMapper.getStudentBySsn(ssn,password);
    }

    @Override
    public Student getStudentBySsnOnly(String ssn) {
        return studentMapper.getStudentBySsnOnly(ssn);
    }

    @Override
    public List<Student> selectStudentBySectionNo(int sectionNo) {
        return studentMapper.selectStudentBySectionNo(sectionNo);
    }
}
