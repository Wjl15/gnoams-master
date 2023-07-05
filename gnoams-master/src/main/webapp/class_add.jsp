<%--
  Created by IntelliJ IDEA.
  User: 15415
  Date: 2023/7/3
  Time: 11:17
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
        <jsp:include page="head.jsp"></jsp:include>
        <!--End 头部信息-->

        <!--页面主要内容-->
        <main class="lyear-layout-content">

            <div class="container-fluid">

                <!-- 内容区 -->
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-header text-center">
                            新增班级
                        </div>
                        <div class="card-body">
                            <form class="form-horizontal" action="ClassAddServlet" method="post">
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-hf-day">班级名称</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="example-hf-day" placeholder="班级名称" name="className">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-manager">班级学科</label>
                                    <div class="col-md-7">
                                        <select style="padding: 10px 0;" class="form-control" id="example-manager" size="1" name="subjectId">
                                            <c:forEach items="${subjects}" var="subject">
                                                <option value="${subject.subjectId}">${subject.subjectName}</option>
                                            </c:forEach>
<%--                                            <option value="0">请选择</option>--%>
<%--                                            <option value="1">JavaEE全栈+大数据</option>--%>
<%--                                            <option value="2">Python全栈+大数据</option>--%>
<%--                                            <option value="3">H5</option>--%>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-hf-hire">开班日期</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="date" id="example-hf-hire" name="createTime">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-hf-qq">班级周期</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="example-hf-qq" placeholder="班级周期" name="classLife">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-hf-qq">班级人数</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="example-hf-qq" placeholder="班级人数" name="classCount">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-hf-qq">班级地址</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="example-hf-qq" placeholder="班级地址" name="classAddress">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-9 col-md-offset-3">
                                        <button class="btn btn-primary" type="submit">新增班级</button>
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