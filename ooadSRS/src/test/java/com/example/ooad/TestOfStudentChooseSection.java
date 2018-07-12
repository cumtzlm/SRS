package com.example.ooad;

import com.example.ooad.domain.Course;
import com.example.ooad.domain.Professor;
import com.example.ooad.domain.Section;
import com.example.ooad.domain.Student;
import com.example.ooad.specification.Specification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2018/7/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestOfStudentChooseSection {
    @Autowired
    @Qualifier("selectionSectionSpecification")
    private Specification<Section> selectionSectionSpecification;
    @Test
    public void testChooseSection(){
//        Professor professor=new Professor("小红","123654","教授","管理学院","123654");
//        Course course1=new Course("001","线代",5,null);
//        Student student=new Student("1","小明","123456","2015级","电子商务");
//        Section section=new Section(1,"周一","1.2节","B201",120,course1,professor);
//        System.out.println(selectionSectionSpecification.validate(student,section));

    }
}
