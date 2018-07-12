package com.example.ooad.specification;

import com.example.ooad.domain.Course;
import com.example.ooad.domain.Score;
import com.example.ooad.domain.Section;
import com.example.ooad.domain.Student;
import org.springframework.stereotype.Service;

public class SelectOnceSpecification implements SpecificationTwo<Student,Section> {
	@Override
	public boolean validate(Student student, Section section) {
		for(Section section1:student.getAttends()){
			if(section1.getCourse().getNumber().equals(section.getCourse().getNumber())){
				return true;
			}
		}
		return false;
	}
}
