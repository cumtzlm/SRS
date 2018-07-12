package com.example.ooad.domain;

public class Score {
	private int id;
	private double grade;
	private Student student;
	private Section section;
	
	public Score() {
		super();
	}
	
	public Score(double grade, Student student, Section section) {
		super();
		this.grade = grade;
		this.student = student;
		this.section = section;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}

	@Override
	public String toString() {
		return "Score{" +
				"id=" + id +
				", grade=" + grade +
				", student=" + student +
				", section=" + section +
				'}';
	}
}
