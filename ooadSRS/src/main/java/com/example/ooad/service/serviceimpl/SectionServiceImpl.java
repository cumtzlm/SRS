package com.example.ooad.service.serviceimpl;

import com.example.ooad.dao.SectionMapper;
import com.example.ooad.domain.Section;
import com.example.ooad.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by asus on 2018/6/30.
 */
@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    SectionMapper sectionMapper;

    @Override
    public List<Section> getAllSection() {
        return sectionMapper.getAllSection();
    }

    @Override
    public List<Section> getAllSectionByCourseNumber(String courseNumber) {
        return sectionMapper.getAllSectionByCourseNumber(courseNumber);
    }

    @Override
    public List<Section> selectEnrolledStudentsListBySectionNo(String ssn) {
        return sectionMapper.selectEnrolledStudentsListBySectionNo(ssn);
    }

    @Override
    public Section getSectionBySectionNo(int sectionNo) {
        return sectionMapper.getSectionBySectionNo(sectionNo);
    }

    @Override
    public void insertSection(String dayOfWeek, String timeOfDay, String room, int capacity, String courseNumber) {
        sectionMapper.insertSection(dayOfWeek,timeOfDay,room,capacity,courseNumber);
    }

    @Override
    public void updateSectionBySectionNo(int sectionNo, String dayOfWeek, String timeOfDay, String room, int capacity, String courseNumber) {
        sectionMapper.updateSectionBySectionNo(sectionNo,dayOfWeek,timeOfDay,room,capacity,courseNumber);
    }

    @Override
    public void deleteSectionBySectionNo(int sectionNo) {
        sectionMapper.deleteSectionBySectionNo(sectionNo);
    }

    @Override
    public List<Section> getSectionByProfessorSsn(String professorSsn) {
        return sectionMapper.getSectionByProfessorSsn(professorSsn);
    }
}
