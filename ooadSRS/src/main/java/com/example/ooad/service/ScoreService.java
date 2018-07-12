package com.example.ooad.service;

import com.example.ooad.domain.Score;

import java.util.List;

/**
 * Created by asus on 2018/7/1.
 */
public interface ScoreService {
    List<Score> getScoreSectionByStudentSsn(String studnetSsn);

    List<Score> getStudentScoreBySectionNo(int sectionNo);

    void insertScoreStudent(String studnetSsn,int sectionNo);

    void deleteScoreStudent(String studnetSsn,int sectionNo);

    void updateScoreStudent(int scoreId,double grade);
}
