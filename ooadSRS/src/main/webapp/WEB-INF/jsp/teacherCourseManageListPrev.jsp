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
          <a href="">课程查询</a>
        <a>
          <cite>先修课程</cite></a>
      </span>
</div>
<div class="x-body">
    <xblock>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg"><i class="layui-icon"></i>添加</button>
        <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <form  method="get" action="PrevCourseAdd">
                        <div class="row" style="margin-top: 20px">
                            <div class="col-md-2"></div>
                            <div class="col-md-10">
                                <div class="col-md-7">
                                    <label>课程先修</label>
                                    <select name="prevCourseNumber" multiple="true">
                                        <c:forEach items="${prevCourseHaveNoChoose}" var="prevCourseHaveNoChoose">
                                            <option value="${prevCourseHaveNoChoose.number}">${prevCourseHaveNoChoose.name}</option>
                                        </c:forEach>
                                    </select>
                                    <input name="courseNumber" value="${courseNumber}" hidden="hidden">
                                </div>
                                <div class="col-md-7">
                                    <input class="btn btn-success" type="submit" value="添加">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>

            <th>课程id</th>
            <th>课程名</th>
            <th>课程学分</th>
            <th>操作</th>
        </thead>
        <tbody>
        <c:forEach items="${prevCourse}" var="prevCourse">
                <tr>
                    <td>${prevCourse.number}</td>
                    <td>${prevCourse.name}</td>
                    <td>${prevCourse.credits}</td>
                    <td class="td-manage">
                        <a title="删除" onclick="member_del(this,'要删除的id')" href="prevCourseDelete?number=${prevCourse.number}">
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
<script>
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });

    /*用户-删除*/
    function member_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            //发异步删除数据
            $(obj).parents("tr").remove();
            layer.msg('已删除!',{icon:1,time:1000});

        });
    }



    function delAll (argument) {

        var data = tableCheck.getData();

        layer.confirm('确认要删除吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
    }
</script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>