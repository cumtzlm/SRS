package com.example.ooad.specification;


import com.example.ooad.domain.Section;
import com.example.ooad.domain.Student;

public interface SpecificationTwo<T,N> {
	boolean validate(Student student, Section section);
}
