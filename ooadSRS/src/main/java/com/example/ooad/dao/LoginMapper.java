package com.example.ooad.dao;

import com.example.ooad.domain.Student;


/**
 * Created by asus on 2018/6/28.
 */
public interface LoginMapper {
    Student studentSearchBySsn(Student student);
}
