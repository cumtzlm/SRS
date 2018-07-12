package com.example.ooad.service;

import com.example.ooad.domain.Section;

import java.util.List;

/**
 * Created by asus on 2018/6/30.
 */
public interface SectionService {
    List<Section> getAllSection();

    List<Section> getAllSectionByCourseNumber(String courseNumber);

    List<Section> selectEnrolledStudentsListBySectionNo(String ssn);

    Section getSectionBySectionNo(int sectionNo);

    void insertSection(String dayOfWeek,String timeOfDay,String room,int capacity,String courseNumber);

    void updateSectionBySectionNo(int sectionNo,String dayOfWeek,String timeOfDay,String room,int capacity,String courseNumber);

    void deleteSectionBySectionNo(int sectionNo);

    List<Section> getSectionByProfessorSsn(String professorSsn);
}
