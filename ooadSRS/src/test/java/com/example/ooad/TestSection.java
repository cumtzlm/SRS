package com.example.ooad;

import com.example.ooad.domain.Course;
import com.example.ooad.domain.Professor;
import com.example.ooad.domain.Section;
import com.example.ooad.domain.Student;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by asus on 2018/7/9.
 */
public class TestSection {
    @Test
    public void testChooseSection(){
        Professor professor1=new Professor("小红","123654","教授","管理学院","123654");
        Professor professor2=new Professor("小明","123789","教授","管理学院","123654");
        Course course1=new Course("001","高数",5,null);
        Course course2=new Course("002","线代",5,null);
        ArrayList<Course> courses=new ArrayList<>();
        ArrayList<Course> planOfStudy=new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        Course course3=new Course("003","概率论",5,courses);
        planOfStudy.addAll(courses);
        planOfStudy.add(course3);

        Section section1=new Section(2,"周二","1.2节","B301",120,course1,professor1);
        Section section2=new Section(2,"周二","1.2节","B301",120,course2,professor1);
        Section section21=new Section(1,"周一","1.2节","B201",120,course3,professor2);
        ArrayList<Section> attends=new ArrayList<>();
        attends.add(section1);
        attends.add(section2);
        attends.add(section21);//测试OneSection
        Student student=new Student("1","小明","123456","2015级","电子商务");
        student.setPlanOfStudy(planOfStudy);//测试planOfStudy
        student.setAttends(attends);

        Section sectionTest=new Section(1,"周一","1.2节","B201",120,course3,professor1);
        System.out.println(sectionTest.canChoose(student));
    }
}
