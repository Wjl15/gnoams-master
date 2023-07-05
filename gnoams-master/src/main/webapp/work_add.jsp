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
  <meta name="author" content="夜泊">
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
                <span>笔下光年 <span class="caret"></span></span>
              </a>
              <ul class="dropdown-menu dropdown-menu-right">
                <li> <a href="user_info.html"><i class="mdi mdi-account"></i> 个人信息</a> </li>
                <li> <a href="user_pwd.html"><i class="mdi mdi-lock-outline"></i> 修改密码</a> </li>
                <li class="divider"></li>
                <li> <a href="login.html"><i class="mdi mdi-logout-variant"></i> 退出登录</a> </li>
              </ul>
            </li>
          </ul>
        </div>
      </nav>

    </header>
    <!--End 头部信息-->

    <!--页面主要内容-->
    <main class="lyear-layout-content">

      <div class="container-fluid">

        <!-- 内容区 -->
        <div class="col-lg-12">
          <div class="card">
            <div class="card-header text-center">
              请假/加班
            </div>
            <div class="card-body">
              <form class="form-horizontal" action="work_list.html" method="get">
                <div class="form-group">
                  <label class="col-md-3 control-label" for="startTime">起始日期</label>
                  <div class="col-md-7">
                    <input class="form-control" type="date" id="startTime">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-md-3 control-label" for="endTime">结束日期</label>
                  <div class="col-md-7">
                    <input class="form-control" type="date" id="endTime">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-md-3 control-label" for="days">涉及天数</label>
                  <div class="col-md-7">
                    <input class="form-control" type="text" id="days" placeholder="请假天数">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-md-3 control-label" for="typeSelect">类型</label>
                  <div class="col-md-7">
                    <select style="padding: 10px 0;" class="form-control" id="typeSelect" size="1">
                      <option value="0">请选择</option>
                      <option value="1">婚假</option>
                      <option value="2">产检</option>
                      <option value="3">调休</option>
                    </select>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-md-3 control-label" for="apmanager">审批领导</label>
                  <div class="col-md-7">
                    <select style="padding: 10px 0;" class="form-control" id="apmanager" size="1">
                      <option value="0">请选择</option>
                      <option value="1">BOSS1</option>
                      <option value="2">BOSS2</option>
                      <option value="3">BOSS3</option>
                    </select>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-md-3 control-label" for="reason">说明信息</label>
                  <div class="col-md-7">
                    <input class="form-control" type="text" id="reason" placeholder="描述缘由...">
                  </div>
                </div>
                <div class="form-group">
                  <div class="col-md-9 col-md-offset-3">
                    <button class="btn btn-primary" type="submit">添加申请</button>
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