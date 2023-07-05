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
              更新学科
            </div>
            <div class="card-body">
              <form class="form-horizontal" action="DeptUpdateServlet" method="post">
                <input type="hidden" value="${department.deptId}" name="deptId" />
                <div class="form-group">
                  <label class="col-md-3 control-label" for="example-hf-day">部门名称</label>
                  <div class="col-md-7">
                    <input class="form-control" type="text" id="example-hf-day" placeholder="部门名称" name="deptName" value="${department.deptName}">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-md-3 control-label" for="example-hf-hire">成立日期</label>
                  <div class="col-md-7">
                    <input class="form-control" type="date" id="example-hf-hire" name="createTime" value="${department.createTime}">
                  </div>
                </div>
<%--                <div class="form-group">--%>
<%--                  <label class="col-md-3 control-label" for="example-hf-qq">学科周期</label>--%>
<%--                  <div class="col-md-7">--%>
<%--                    <input class="form-control" type="text" id="example-hf-qq" placeholder="学科周期" name="subjectLife" value="${department.deptLife}">--%>
<%--                  </div>--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>
<%--                  <label class="col-md-3 control-label" for="example-manager">学科类型</label>--%>
<%--                  <div class="col-md-7">--%>
<%--                    <select style="padding: 10px 0;" class="form-control" id="example-manager" size="1" name="subjectTypeId">--%>
<%--                      <c:forEach items="${subjectTypes}" var="subjectType">--%>
<%--                      <option <c:if test="${subject.subjectTypeId eq subjectType.subjectTypeId}">selected</c:if> value="${subjectType.subjectTypeId}">${subjectType.subjectTypeName}</option>--%>
<%--                      </c:forEach>--%>
<%--                    </select>--%>
<%--                  </div>--%>
<%--                </div>--%>
                <div class="form-group">
                  <div class="col-md-9 col-md-offset-3">
                    <button class="btn btn-primary" type="submit">更新部门</button>
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

