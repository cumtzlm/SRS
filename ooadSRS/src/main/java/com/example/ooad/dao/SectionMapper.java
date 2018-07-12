package com.example.ooad.dao;

import com.example.ooad.domain.Section;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * Created by asus on 2018/6/29.
 */
public interface SectionMapper {

    @Select("select * from section")
    @Results({
            @Result(id=true,column="sectionNo",property="sectionNo"),
            @Result(column="courseNumber",property="course",
                    one=@One(select="com.example.ooad.dao.CourseMapper.selectCourseByNum",
                            fetchType= FetchType.EAGER)),
            @Result(column="professorSsn",property="professor",
                    one=@One(select="com.example.ooad.dao.ProfessorMapper.selectProfessorBySsn",
                            fetchType=FetchType.EAGER)),
            @Result(column="sectionNo",property="enrolledStudents",
                    many=@Many(select="com.example.ooad.dao.StudentMapper.selectStudentBySectionNo",
                            fetchType=FetchType.LAZY))
    })
    List<Section> getAllSection();

    @Select("select * from section where courseNumber=#{courseNumber}")
    @Results({
            @Result(id=true,column="sectionNo",property="sectionNo"),
            @Result(column="courseNumber",property="course",
                    one=@One(select="com.example.ooad.dao.CourseMapper.selectCourseByNum",
                            fetchType= FetchType.EAGER)),
            @Result(column="professorSsn",property="professor",
                    one=@One(select="com.example.ooad.dao.ProfessorMapper.selectProfessorBySsn",
                            fetchType=FetchType.EAGER)),
    })
    List<Section> getAllSectionByCourseNumber(@Param("courseNumber")String courseNumber);

//查询选课学生
    @Select("select * from section where sectionNo in (select sectionNo from  score where studentSsn=#{ssn})")
    @Results({
            @Result(id=true,column="sectionNo",property="sectionNo"),
            @Result(column="courseNumber",property="course",
                    one=@One(select="com.example.ooad.dao.CourseMapper.selectCourseByNum",
                            fetchType=FetchType.EAGER)),
            @Result(column="professorSsn",property="professor",
                    one=@One(select="com.example.ooad.dao.ProfessorMapper.selectProfessorBySsn",
                            fetchType=FetchType.EAGER)),
            @Result(column="sectionNo",property="enrolledStudents",
                    many=@Many(select="com.example.ooad.dao.StudentMapper.selectStudentBySectionNo",
                            fetchType=FetchType.LAZY))
    })
    List<Section> selectEnrolledStudentsListBySectionNo(@Param("ssn") String ssn);

    @Insert("insert into section(dayOfWeek,timeOfDay,room,capacity,courseNumber) values(#{dayOfWeek},#{timeOfDay},#{room},#{capacity},#{courseNumber})")
    void insertSection(@Param("dayOfWeek") String dayOfWeek,@Param("timeOfDay")String timeOfDay,@Param("room")String room,@Param("capacity")int capacity,@Param("courseNumber")String courseNumber);

    @Update("update section set dayOfWeek=#{dayOfWeek},timeOfDay=#{timeOfDay},room=#{room},capacity=#{capacity},courseNumber#{courseNumber} where sectionNo=#{sectionNo}")
    void updateSectionBySectionNo(@Param("sectionNo") int sectionNo,@Param("dayOfWeek") String dayOfWeek,@Param("timeOfDay")String timeOfDay,@Param("room")String room,@Param("capacity")int capacity,@Param("courseNumber")String courseNumber);

    @Delete("delete from section where sectionNo=#{sectionNo}")
    void deleteSectionBySectionNo(@Param("sectionNo")int sectionNo);

    @Select("select * from section where professorSsn=#{professorSsn}")
    @Results({
            @Result(id=true,column="sectionNo",property="sectionNo"),
            @Result(column="courseNumber",property="course",
                    one=@One(select="com.example.ooad.dao.CourseMapper.selectCourseByNum",
                            fetchType= FetchType.EAGER)),
            @Result(column="professorSsn",property="professor",
                    one=@One(select="com.example.ooad.dao.ProfessorMapper.selectProfessorBySsn",
                            fetchType=FetchType.EAGER)),
    })
    List<Section> getSectionByProfessorSsn(@Param("professorSsn")String professorSsn);

    @Select("select * from section where sectionNo=#{sectionNo}")
    @Results({
            @Result(id=true,column="sectionNo",property="sectionNo"),
            @Result(column="courseNumber",property="course",
                    one=@One(select="com.example.ooad.dao.CourseMapper.selectCourseByNum",
                            fetchType= FetchType.EAGER)),
            @Result(column="professorSsn",property="professor",
                    one=@One(select="com.example.ooad.dao.ProfessorMapper.selectProfessorBySsn",
                            fetchType=FetchType.EAGER)),
            @Result(column="sectionNo",property="enrolledStudents",
                    many=@Many(select="com.example.ooad.dao.StudentMapper.selectStudentBySectionNo",
                            fetchType=FetchType.LAZY))
    })
    Section getSectionBySectionNo(@Param("sectionNo")int sectionNo);
}
