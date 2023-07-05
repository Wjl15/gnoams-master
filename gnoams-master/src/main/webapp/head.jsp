<%--
  Created by IntelliJ IDEA.
  User: 15415
  Date: 2023/7/4
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="lyear-layout-header">

  <nav class="navbar navbar-default">
    <div class="topbar">

      <div class="topbar-left">
        <div class="lyear-aside-toggler">
          <span class="lyear-toggler-bar"></span>
          <span class="lyear-toggler-bar"></span>
          <span class="lyear-toggler-bar"></span>
        </div>
        <span class="navbar-page-title"> 后台首页 </span>
      </div>

      <ul class="topbar-right">
        <li class="dropdown dropdown-profile">
          <a href="javascript:void(0)" data-toggle="dropdown">
            <img class="img-avatar img-avatar-48 m-r-10" src="images/users/avatar.jpg" alt="笔下光年" />
            <span>${employee.empName} <span class="caret"></span></span>
          </a>
          <ul class="dropdown-menu dropdown-menu-right">
            <li> <a href="UserInfoToUpdateServlet?empId=${employee.empId}"><i class="mdi mdi-account"></i> 个人信息</a> </li>
            <li> <a href="UserPwdToUpdateServlet?empId=${employee.empId}"><i class="mdi mdi-lock-outline"></i> 修改密码</a> </li>
            <li class="divider"></li>
            <li> <a href="LoginoutServlet"><i class="mdi mdi-logout-variant"></i> 退出登录</a> </li>
          </ul>
        </li>
      </ul>
    </div>
  </nav>

</header>
