package com.example.ooad.dao;

import com.example.ooad.domain.Professor;
import org.apache.ibatis.annotations.*;

/**
 * Created by asus on 2018/6/28.
 */
public interface ProfessorMapper {

    @Select(" SELECT * from professor WHERE ssn=#{ssn} and password=#{password}")
    Professor getProfessorBySsn1(@Param("ssn")String ssn,@Param("password")String password);

    @Select("select * from professor where ssn=#{ssn}")
    @Results({
            @Result(id=true,column="ssn",property="ssn"),
            @Result(column="name",property="name"),
            @Result(column="title",property="title"),
            @Result(column="department",property="department")
    })
    Professor selectProfessorBySsn(@Param("ssn") String ssn);

//    选课切换代码

    @Update("update section set professorSsn='' where sectionNo=#{sectionNo}")
    void sectionOutSwtich(@Param("sectionNo")int sectionNo);

    @Update("update section set professorSsn=#{professorSsn} where sectionNo=#{sectionNo}")
    void sectionIn(@Param("sectionNo")int sectionNo,@Param("professorSsn")String professorSsn);

    @Insert("insert professor_section(professorSsn,sectionNo) values(#{professorSsn},#{sectionNo})")
    void insertProfessorTeaches(@Param("sectionNo")int sectionNo,@Param("professorSsn")String professorSsn);

    @Delete("delete from professor_section where professorSsn=#{professorSsn} and sectionNo=#{sectionNo}")
    void deleteProfessorTeaches(@Param("sectionNo")int sectionNo,@Param("professorSsn")String professorSsn);
}
