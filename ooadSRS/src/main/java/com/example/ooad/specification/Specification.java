package com.example.ooad.specification;


import com.example.ooad.domain.Section;
import com.example.ooad.domain.Student;

public interface Specification<T> {
	String validate(Student student, Section section);
}
