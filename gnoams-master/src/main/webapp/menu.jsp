<%--
  Created by IntelliJ IDEA.
  User: 15415
  Date: 2023/7/4
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside class="lyear-layout-sidebar">

    <!-- logo -->
    <div id="logo" class="sidebar-header">
        <a href="index.jsp"><img src="images/logo-sidebar.png" title="LightYear" alt="LightYear" /></a>
    </div>
    <div class="lyear-layout-sidebar-scroll">

        <nav class="sidebar-main">
            <ul class="nav nav-drawer">
                <li class="nav-item active"> <a href="index.jsp"><i class="mdi mdi-home"></i> 办公首页</a> </li>
                <li class="nav-item nav-item-has-subnav">
                    <a href="javascript:void(0)"><i class="mdi mdi-image-filter-vintage"></i> 角色管理</a>
                    <ul class="nav nav-subnav">
                        <li> <a href="role_list.jsp">用户角色</a> </li>
                        <li> <a href="role_add.jsp">添加角色</a> </li>
                    </ul>
                </li>
                <li class="nav-item nav-item-has-subnav">
                    <a href="javascript:void(0)"><i class="mdi mdi-counter"></i> 部门管理</a>
                    <ul class="nav nav-subnav">
                        <li> <a href="dept_list.jsp">部门列表</a> </li>
                        <li> <a href="dept_add.jsp">新增部门</a> </li>
                    </ul>
                </li>
                <li class="nav-item nav-item-has-subnav">
                    <a href="javascript:void(0)"><i class="mdi mdi-shovel"></i> 学科管理</a>
                    <ul class="nav nav-subnav">
                        <li> <a href="subject_list.jsp">学科列表</a> </li>
                        <li> <a href="StudentToAddServlet">学科新增</a> </li>
                    </ul>
                </li>
                <li class="nav-item nav-item-has-subnav">
                    <a href="javascript:void(0)"><i class="mdi mdi-face-profile"></i> 班级管理</a>
                    <ul class="nav nav-subnav">
                        <li> <a href="class_list.jsp">班级列表</a> </li>
                        <li> <a href="ClassToAddServlet">班级新增</a> </li>
                    </ul>
                </li>
                <li class="nav-item nav-item-has-subnav">
                    <a href="javascript:void(0)"><i class="mdi mdi-account-settings"></i> 员工管理</a>
                    <ul class="nav nav-subnav">
                        <li> <a href="employee_list.jsp">员工列表</a> </li>
                        <li> <a href="EmployeeToAddServlet">员工新增</a> </li>
                    </ul>
                </li>
                <li class="nav-item nav-item-has-subnav">
                    <a href="javascript:void(0)"><i class="mdi mdi-trophy-variant"></i> 学员管理</a>
                    <ul class="nav nav-subnav">
                        <li> <a href="student_list.jsp">学员列表</a> </li>
                        <li> <a href="StudentToAddServlet">学员新增</a> </li>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>

</aside>


