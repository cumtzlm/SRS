package com.example.ooad.service.serviceimpl;

import com.example.ooad.dao.LoginMapper;
import com.example.ooad.dao.ProfessorMapper;
import com.example.ooad.dao.StudentMapper;
import com.example.ooad.domain.Person;
import com.example.ooad.domain.Professor;
import com.example.ooad.domain.Student;
import com.example.ooad.service.LoginServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by asus on 2018/6/28.
 */
@Service("loginService")
public class LoginServiceImpl implements LoginServcie {
    @Autowired
    ProfessorMapper professorMapper;
    @Autowired
    StudentMapper studentMapper;

    @Override
    public Professor loginProfessService(String ssn, String password){
        return professorMapper.getProfessorBySsn1(ssn,password);
    }

    @Override
    public Student loginStudentService(String ssn, String password) {
        return studentMapper.getStudentBySsn(ssn,password);
    }

    ;
}
