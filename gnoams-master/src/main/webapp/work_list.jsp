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
        <div class="row">
          <div class="col-lg-12">
            <div class="card">
              <div class="table-responsive">
                <table class="table">
                  <thead>
                  <tr>
                    <th>序号</th>
                    <th>申请人</th>
                    <th>请假类型</th>
                    <th>起始日期</th>
                    <th>终止日期</th>
                    <th>天数</th>
                    <th>审批人</th>
                    <th>结果</th>
                  </tr>
                  </thead>
                  <tbody>
                  <tr>
                    <th>1</th>
                    <td>张三</td>
                    <td>串休</td>
                    <td>2020-1-1</td>
                    <td>2020-1-3</td>
                    <td>3</td>
                    <td>李雷</td>
                    <td>审批中</td>
                  </tr>
                  <tr>
                    <th>2</th>
                    <td>韩梅梅</td>
                    <td>病假</td>
                    <td>2020-1-1</td>
                    <td>2020-1-3</td>
                    <td>3</td>
                    <td>李雷</td>
                    <td>审批中</td>
                  </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>

        </div>
        <!-- 内容区结束 -->
        <div class="row">
          <div class="col-lg-4 text-left">
            <a class="btn btn-info" href="work_add.html">添加申请</a>
          </div>
          <div class="col-lg-4 text-center">
            <nav>
              <ul class="pagination">
                <li>
                  <a href="#!">
                    <span><i class="mdi mdi-chevron-left"></i></span>
                  </a>
                </li>
                <li class="active"><a href="#">1</a></li>
                <li><a href="#!">2</a></li>
                <li><a href="#!">3</a></li>
                <li>
                  <a href="#!">
                    <span><i class="mdi mdi-chevron-right"></i></span>
                  </a>
                </li>
              </ul>
            </nav>
          </div>
          <div class="col-lg-4 text-center">
            <a class="btn btn-info" href="#">导出Excel</a>
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