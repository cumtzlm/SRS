package com.example.ooad.dao;

import com.example.ooad.domain.Score;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * Created by asus on 2018/7/1.
 */
public interface ScoreMapper {
    @Select("select * from score where studentSsn=#{studentSsn}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="grade",property="grade"),
            @Result(column="studentSsn",property="student",
                    one=@One(select="com.example.ooad.dao.StudentMapper.getStudentBySsnOnly",
                            fetchType= FetchType.EAGER)),
            @Result(column="sectionNo",property="section",
                    one=@One(select="com.example.ooad.dao.SectionMapper.getSectionBySectionNo",
                            fetchType=FetchType.EAGER))
    })
    List<Score> getScoreSectionByStudentSsn(@Param("studentSsn")String studentSsn);

//为了避免getScoreSectionByStudentSsn方法死循环与StudentMapper.getStudentBySsnOnly
    @Select("select * from score where studentSsn=#{studentSsn}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="grade",property="grade"),
            @Result(column="sectionNo",property="section",
                    one=@One(select="com.example.ooad.dao.SectionMapper.getSectionBySectionNo",
                            fetchType=FetchType.EAGER))
    })
    List<Score> getScoreSectionByStudentSsn2(@Param("studentSsn")String studentSsn);

    @Select("select * from score where sectionNo=#{sectionNo}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="grade",property="grade"),
            @Result(column="studentSsn",property="student",
                    one=@One(select="com.example.ooad.dao.StudentMapper.getStudentBySsnOnly",
                            fetchType= FetchType.EAGER))
    })
    List<Score> getStudentScoreBySectionNo(@Param("sectionNo")int sectionNo);

    @Insert("insert into score(studentSsn,sectionNo) values(#{studentSsn},#{sectionNo})")
    void insertScoreStudent(@Param("studentSsn")String studnetSsn,@Param("sectionNo")int sectionNo);

    @Delete("delete from score where studentSsn=#{studentSsn} and sectionNo=#{sectionNo}")
    void deleteScoreStudent(@Param("studentSsn")String studnetSsn,@Param("sectionNo")int sectionNo);

    @Update("update score set grade=#{grade} where id=#{scoreId}")
    void updateScoreStudent(@Param("scoreId")int scoreId,@Param("grade")double grade);

}
