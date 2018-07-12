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
          <cite>课程管理</cite></a>
      </span>
</div>
<div class="x-body">
    <xblock>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModel"><i class="layui-icon"></i>添加</button>
        <div class="modal fade" id="addModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel1">添加课程</h4>
                    </div>
                    <div class="modal-body">
                        <form  method="get" action="CourseAdd">
                            <div class="row" style="margin-top: 20px">
                                <div class="col-md-2"></div>
                                <div class="col-md-10">
                                    <div class="col-md-7">
                                        <label>课程编号</label>
                                        <input type="text" class="form-control" name="number">
                                    </div>
                                    <div class="col-md-7">
                                        <label>课程名称</label>
                                        <input type="text" class="form-control" name="name">
                                    </div>
                                    <div class="col-md-7">
                                        <label>课程学分</label>
                                        <input type="text" class="form-control" name="credits">
                                    </div>
                                    <div class="col-md-7">
                                        <label>课程先修</label>
                                        <select name="prevCourseNumber" class="form-control" multiple="true">
                                            <c:forEach items="${allCourse}" var="allCourse">
                                                <option value="${allCourse.number}">${allCourse.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button type="submit" class="btn btn-primary">确认修改</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>

            <th>课程id</th>
            <th>课程名</th>
            <th>学分</th>
            <th>先修课程</th>
            <th>教师选课</th>
            <th>操作</th>
        </thead>
        <tbody>
        <c:forEach items="${allCourse}" var="allCourse">
                <tr>
                    <td>${allCourse.number}</td>
                    <td>${allCourse.name}</td>
                    <td>${allCourse.credits}</td>
                    <td>
                        <a title="查看"  onclick="x_admin_show('查看','teacherCourseManageListPrev?number=${allCourse.number}')" href="javascript:;">
                            <i class="layui-icon">查看先修</i>
                        </a>
                    </td>
                    <td>
                        <a title="查看"  onclick="x_admin_show('查看','teacherCourseManageListSecond?courseNumber=${allCourse.number}')" href="javascript:;">
                            <i class="layui-icon">点击查看</i>
                        </a>
                    </td>
                    <td >
                        <a   data-toggle="modal" data-target="#myModal${allCourse.number}">
                            <i class="layui-icon">&#xe642;</i>
                        </a>
                            <div class="modal fade" id="myModal${allCourse.number}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title" id="myModalLabel">编辑课程</h4>
                                        </div>
                                        <div class="modal-body">
                                            <form  method="get" action="CourseUpdate">
                                                <div class="row" style="margin-top: 20px">
                                                    <div class="col-md-2"></div>
                                                    <div class="col-md-10">
                                                        <div class="col-md-7">
                                                            <label>课程编号</label>
                                                            <input type="text" disabled="disabled" class="form-control" value="${allCourse.number}">
                                                            <input type="hidden" class="form-control" name="numberUpdate" value="${allCourse.number}">
                                                        </div>
                                                        <div class="col-md-7">
                                                            <label>课程名称</label>
                                                            <input type="text" class="form-control" name="nameUpdate" value="${allCourse.name}">
                                                        </div>
                                                        <div class="col-md-7">
                                                            <label>课程学分</label>
                                                            <input type="text" class="form-control" name="creditsUpdate" value="${allCourse.credits}">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                                    <button type="submit" class="btn btn-primary">确认修改</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        <a title="删除" href="CourseDelete?number=${allCourse.number}">
                            <i class="layui-icon">&#xe640;</i>
                        </a>
                    </td>
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