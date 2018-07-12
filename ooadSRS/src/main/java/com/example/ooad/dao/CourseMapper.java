package com.example.ooad.dao;

import com.example.ooad.domain.Course;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * Created by asus on 2018/6/29.
 */
public interface CourseMapper {

    @Select("select * from course")
    List<Course> getAllCourse();

    @Select("select * from course where number=#{number}")
    @Results({
            @Result(id=true,column="number",property="number"),
            @Result(column="name",property="name"),
            @Result(column="credits",property="credits"),
            @Result(column="number",property="prevCourse",
                    many=@Many(select="com.example.ooad.dao.CourseMapper.selectPrevCourseByNumber",
                            fetchType=FetchType.LAZY))
    })
    Course selectCourseByNum(@Param("number") String number);

    @Select("select * from course where number in (select distinct prevCourseNumber from prevcourse where courseNumber =#{number})")
    @Results({
            @Result(id=true,column="number",property="number"),
            @Result(column="name",property="name"),
            @Result(column="credits",property="credits")
    })
    List<Course> selectPrevCourseByNumber(String number);



    @Insert("insert into course (number,name,credits) values(#{number},#{name},#{credits})")
    void insertCourse(Course course);

    @Insert("insert into prevcourse (courseNumber,prevCourseNumber) values(#{number},#{prev_number})")
    void insertPrevCourse(@Param("number") String number, @Param("prev_number") String prev_number);

    @Delete("delete from course where number=#{number}")
    void deleteCourseByNumber(@Param("number") String number);

    @Delete("delete from prevcourse where courseNumber=#{number}")
    void deletePrevCourseByNumber(@Param("number") String number);

    @Delete("delete from prevcourse where prevCourseNumber=#{number}")
    void deletePrevCourseByPrevNumber(String number);

    @Update("update course set name=#{name},credits=#{credits} where number=#{number}")
    void updateCourse(@Param("number")String number,@Param("name")String name,@Param("credits")double credits);

    @Select("select * from course where number in (select courseNumber from planofstudy where studentSsn=#{ssn})")
    @Results({
            @Result(id=true,column="number",property="number"),
            @Result(column="name",property="name"),
            @Result(column="credits",property="credits"),
            @Result(column="number",property="prevCourse",
                    many=@Many(select="com.example.ooad.dao.CourseMapper.selectPrevCourseByNumber",
                            fetchType=FetchType.LAZY))
    })
    List<Course> selectByStudentSn(String ssn);
}
