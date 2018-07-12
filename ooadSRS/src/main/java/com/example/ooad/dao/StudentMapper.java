package com.example.ooad.dao;

import com.example.ooad.domain.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * Created by asus on 2018/6/30.
 */
public interface StudentMapper {
    @Select("select * from student where ssn=#{ssn} and password=#{password}")
    Student getStudentBySsn(@Param("ssn") String ssn,@Param("password") String password);

    @Select("select * from student where ssn in (select studentSsn from score where sectionNo=#{sectionNo})")
    @Results({
            @Result(id=true,column="ssn" ,property="ssn"),
            @Result(column="name" ,property="name"),
            @Result(column="degree" ,property="degree"),
            @Result(column="major" ,property="major"),
            @Result(column="password" ,property="password")
    })
    List<Student> selectStudentBySectionNo(@Param("sectionNo") int sectionNo);

    @Select("select * from student where ssn=#{ssn}")
    @Results({
            @Result(id=true,column="ssn" ,property="ssn"),
            @Result(column="ssn" , property="scoreEntity",
                    many=@Many(select="com.example.ooad.dao.ScoreMapper.getScoreSectionByStudentSsn2",
                            fetchType= FetchType.LAZY)),
            @Result(column="ssn" , property="attends",
                    many=@Many(select="com.example.ooad.dao.SectionMapper.selectEnrolledStudentsListBySectionNo",
                            fetchType=FetchType.LAZY)),
            @Result(column="ssn" , property="planOfStudy",
                    many=@Many(select="com.example.ooad.dao.CourseMapper.selectByStudentSn",
                            fetchType= FetchType.LAZY))
    })
    Student getStudentBySsnOnly(@Param("ssn") String ssn);
}
