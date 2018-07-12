<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix= "form" uri= "http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>教务系统</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="../css/font.css">
    <link rel="stylesheet" href="../css/xadmin.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" >
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="../lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="../js/xadmin.js"></script>

</head>
<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a>
          <cite>成绩查询</cite></a>
      </span>
</div>
<div class="x-body">
    <table class="layui-table">
        <thead>
        <tr>
            <th>课程id</th>
            <th>课程名</th>
            <th>周数</th>
            <th>节数</th>
            <th>教室</th>
            <th>容量</th>
            <th>教师</th>
            <th>成绩</th>
        </thead>
        <tbody>
        <c:forEach items="${scoreList}" var="scoreList">
            <tr>
                <td>${scoreList.section.course.number}</td>
                <td>${scoreList.section.course.name}</td>
                <td>${scoreList.section.dayOfWeek}</td>
                <td>${scoreList.section.timeOfDay}</td>
                <td>${scoreList.section.room}</td>
                <td>${scoreList.section.capacity}</td>
                <td>${scoreList.section.professor.name}</td>
                <c:choose>
                    <c:when test="${scoreList.grade==''}"><td>暂无</td></c:when>
                    <c:otherwise><td>${scoreList.grade}</td></c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="page">
        <div>
            <a class="prev" href="">&lt;&lt;</a>
            <a class="num" href="">1</a>
            <a class="next" href="">&gt;&gt;</a>
        </div>
    </div>

</div>

<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>