<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>请登录</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" >
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
<div class="col-md-5"> </div>
<div class="col-md-2">
    <div style="padding-top: 300px">
        <div class="text-center">
            <label>教务系统登录</label>
        </div>
        <form method="get" action="login">
            <div class="form-group">
                <label for="loginSsn">学号/工号</label>
                <input type="ssn" class="form-control" id="loginSsn" name="ssn" placeholder="Ssn">
            </div>
            <div class="form-group">
                <label for="loginPassword">密码</label>
                <input type="password" class="form-control" id="loginPassword" name="password" placeholder="Password">
            </div>
            <button type="submit" class="btn btn-success">登录</button>
        </form>
    </div>
</div>
<div class="col-md-5"> </div>
</body>
</html>