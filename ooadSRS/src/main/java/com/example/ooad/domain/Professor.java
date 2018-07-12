package com.example.ooad.domain;

import java.util.ArrayList;

public class Professor extends Person{
	private String title;//职称
	private String department;//学院
	private ArrayList<Section> teaches;//所教课程
	private String password;
	private int rightId;
	
	public Professor() {
		super();
	}
	public Professor(String ssn, String name) {
		super(ssn, name);
	}
	public Professor(String name,String ssn,String title, String department,String password) {
		super(name,ssn);
		this.title = title;
		this.department = department;
		this.password=password;
		teaches=new ArrayList<Section>();
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public ArrayList<Section> getTeaches() {
		return teaches;
	}
	public void setTeaches(ArrayList<Section> teaches) {
		this.teaches = teaches;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRightId() {
		return rightId;
	}

	@Override
	public String toString() {
		return "Professor{" +
				"title='" + title + '\'' +
				", department='" + department + '\'' +
				", teaches=" + teaches +
				", password='" + password + '\'' +
				", rightId=" + rightId +
				'}';
	}

	public void ChooseSection(Section section){
		teaches.add(section);
	}
}
