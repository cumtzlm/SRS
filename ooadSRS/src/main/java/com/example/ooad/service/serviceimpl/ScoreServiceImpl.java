package com.example.ooad.service.serviceimpl;

import com.example.ooad.dao.ScoreMapper;
import com.example.ooad.domain.Score;
import com.example.ooad.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by asus on 2018/7/1.
 */
@Service
public class ScoreServiceImpl implements ScoreService{
    @Autowired
    ScoreMapper scoreMapper;
    @Override
    public List<Score> getScoreSectionByStudentSsn(String studnetSsn) {
        return scoreMapper.getScoreSectionByStudentSsn(studnetSsn);
    }

    @Override
    public List<Score> getStudentScoreBySectionNo(int sectionNo) {
        return scoreMapper.getStudentScoreBySectionNo(sectionNo);
    }

    @Override
    public void insertScoreStudent(String studentSsn, int sectionNo) {
        scoreMapper.insertScoreStudent(studentSsn,sectionNo);
    }

    @Override
    public void deleteScoreStudent(String studentSsn, int sectionNo) {
        scoreMapper.deleteScoreStudent(studentSsn,sectionNo);
    }

    @Override
    public void updateScoreStudent(int scoreId,double grade) {
        scoreMapper.updateScoreStudent(scoreId,grade);
    }
}
