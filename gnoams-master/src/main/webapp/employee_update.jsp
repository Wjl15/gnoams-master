<%--
  Created by IntelliJ IDEA.
  User: 15415
  Date: 2023/7/3
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>光年OA管理系统</title>
    <link rel="icon" href="imgs/favicon.ico" type="image/ico">
    <meta name="keywords" content="OA,光年OA管理系统">
    <meta name="description" content="光年OA管理系统">
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

                <!-- 内容区 -->
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-header text-center">
                            更新员工
                        </div>
                        <div class="card-body">
                            <form class="form-horizontal" action="EmployeeUpdateServlet" method="post">
                                <input type="hidden" value="${employee.empId}" name="empId" />
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="empName">员工姓名</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="empName" placeholder="员工姓名" name="empName" value="${employee.empName}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="deptName">部门</label>
                                    <div class="col-md-7">
                                        <select style="padding: 10px 0;" class="form-control" id="deptName" size="1" name="deptId">
                                            <c:forEach items="${departments}" var="department">
                                                <option <c:if test="${department.deptId eq employee.deptId}"> selected</c:if> value="${department.deptId}">${department.deptName}</option>
                                            </c:forEach>

<%--                                            <option value="0">请选择</option>--%>
<%--                                            <option value="1">行政部</option>--%>
<%--                                            <option value="2">产品研发</option>--%>
<%--                                            <option value="3">公关部</option>--%>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="roleName">角色</label>
                                    <div class="col-md-7">
                                        <select style="padding: 10px 0;" class="form-control" id="roleName" size="1" name="roleId">
                                            <c:forEach items="${roles}" var="role">
                                            <option <c:if test="${role.roleId eq employee.roleId}"> selected</c:if> value="${role.roleId}">${role.roleName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">性别</label>
                                    <div class="col-md-7">
                                        <label class="radio-inline" for="man">
                                            <input type="radio" <c:if test="${employee.gender == 1}">checked</c:if>  id="man" name="gender" value="1">
                                            男
                                        </label>
                                        <label class="radio-inline" for="woman">
                                            <input <c:if test="${employee.gender == 0}">checked</c:if>  type="radio" id="woman" name="gender" value="0">
                                            女
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="managerName">管理者</label>
                                    <div class="col-md-7">
                                        <select style="padding: 10px 0;" class="form-control" id="managerName" size="1" name="managerId">
                                            <c:forEach items="${managers}" var="manager">
                                                <option <c:if test="${manager.empId eq employee.managerId}"> selected</c:if> value="${manager.empId}">${manager.empName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="phone">手机</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="phone" placeholder="手机号" name="phone" value="${employee.phone}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="password">密码</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="password" id="password" placeholder="密码" name="password" value="${employee.password}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="email">邮箱</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="email" id="email" placeholder="邮箱" name="email" value="${employee.email}">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="hire">入职时间</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="date" id="hire" name="hireTime" value="${employee.hireTime}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-9 col-md-offset-3">
                                        <button class="btn btn-primary" type="submit">更新员工</button>
                                    </div>
                                </div>
                            </form>
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