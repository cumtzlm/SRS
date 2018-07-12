package com.example.ooad.specification;

import com.example.ooad.domain.Course;
import com.example.ooad.domain.Section;
import com.example.ooad.domain.Student;
import org.springframework.stereotype.Service;

/**
 * Created by asus on 2018/7/9.
 */
public class StudyPlanSpecification implements SpecificationTwo<Student,Section>{

    @Override
    public boolean validate(Student student, Section section) {
                for(Course s:student.getPlanOfStudy()){
                    if(s.getNumber().equals(section.getCourse().getNumber())){
                        return false;
                    }
                }
        return true;
    }
}
