package com.example.ooad.domain;

import java.util.ArrayList;

public class Student extends Person{
	private String degree;
	private String major;
	private ArrayList<Score> scoreEntity;
	private ArrayList<Section> attends;//本学期选修课程
	private ArrayList<Course> planOfStudy;//学生培养计划
	private String password;
	public Student() {
		super();
	}
	public Student(String ssn, String name,String password,String degree,String major) {
		super(ssn, name);
		this.degree=degree;
		this.major=major;
		this.password = password;
		attends = new ArrayList<Section>();
		planOfStudy=new ArrayList<Course>();
		scoreEntity = new ArrayList<Score>();
	}	
	public Student(String ssn, String name, String degree, String major, ArrayList<Score> scoreEntity, ArrayList<Section> attends, String password, ArrayList<Course> planOfStudy) {
		super(ssn, name);
		this.degree = degree;
		this.major = major;
		this.password = password;
		attends = new ArrayList<Section>();
		planOfStudy=new ArrayList<Course>();
		scoreEntity = new ArrayList<Score>();
	}
	
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public ArrayList<Score> getScoreEntity() {
		return scoreEntity;
	}
	public void setScoreEntity(ArrayList<Score> scoreEntity) {
		this.scoreEntity =scoreEntity;
	}
	public ArrayList<Section> getAttends() {
		return attends;
	}
	public void setAttends(ArrayList<Section> attends) {
		this.attends = attends;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<Course> getPlanOfStudy() {
		return planOfStudy;
	}
	public void setPlanOfStudy(ArrayList<Course> planOfStudy) {
		this.planOfStudy = planOfStudy;
	}

	@Override
	public String toString() {
		return "Student{" +
				"degree='" + degree + '\'' +
				", major='" + major + '\'' +
				", scoreEntity=" + scoreEntity +
				", attends=" + attends +
				", planOfStudy=" + planOfStudy +
				", password='" + password + '\'' +
				'}';
	}

	public void AddSection(Section section){
		attends.add(section);
	}

	public void DropSection(Section section){
		for(Section section1:attends){
			if(section1.getSectionNo()==section.getSectionNo()){
				attends.remove(section1);
				break;
			}
		}
	}

}
