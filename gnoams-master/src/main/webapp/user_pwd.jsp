<%--
  Created by IntelliJ IDEA.
  User: 15415
  Date: 2023/7/3
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>光年OA管理系统</title>
    <link rel="icon" href="imgs/favicon.ico" type="image/ico">
    <meta name="keywords" content="ukoko.cn">
    <meta name="description" content="解决中小企业...">
    <meta name="author" content="yinqi">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/materialdesignicons.min.css" rel="stylesheet">
    <link href="css/style.min.css" rel="stylesheet">
</head>

<body>
<div class="lyear-layout-web">
    <div class="lyear-layout-container">
        <!--左侧导航-->
        <jsp:include page="menu.jsp"></jsp:include>
        <!--End 左侧导航-->

        <!--头部信息-->
        <jsp:include page="head.jsp"></jsp:include>
        <!--End 头部信息-->

        <!--页面主要内容-->
        <main class="lyear-layout-content">

            <div class="container-fluid">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">

                                <form method="post" action="UserPwdUpdateServlet" class="site-form">
                                    <h3 style="color: red; text-align: center" >${msg}</h3>
                                    <div class="form-group">
                                        <input hidden="hidden" type="text"  name="empId" id="empId" value="${employee.empId}" />
                                        <input hidden="hidden" type="text"  name="oldrealpwd" id="oldrealpwd" value="${employee.password}" />
                                        <label for="old-password">旧密码</label>
                                        <input type="password" class="form-control" name="oldpwd" id="old-password" placeholder="原密码" value="${employee.password}">
                                    </div>
                                    <div class="form-group">
                                        <label for="new-password">新密码</label>
                                        <input type="password" class="form-control" name="newpwd" id="new-password" placeholder="新密码">
                                    </div>
                                    <div class="form-group">
                                        <label for="confirm-password">确认新密码</label>
                                        <input type="password" class="form-control" name="confirmpwd" id="confirm-password" placeholder="确认密码">
                                    </div>
                                    <button type="submit" class="btn btn-primary">修改密码</button>
                                </form>

                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </main>
        <!--End 页面主要内容-->
    </div>
</div>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="js/main.min.js"></script>
</body>
</html>