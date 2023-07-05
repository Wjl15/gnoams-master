<%--
  Created by IntelliJ IDEA.
  User: 15415
  Date: 2023/7/3
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>光年OA管理系统</title>
    <link rel="icon" href="imgs/favicon.ico" type="image/ico">
    <meta name="keywords" content="ukoko.cn">
    <meta name="description" content="解决中小企业...">
    <meta name="author" content="夜泊">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/materialdesignicons.min.css" rel="stylesheet">
    <link href="css/style.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.22.0/dist/bootstrap-table.min.css">
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
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="table-responsive">
                                <table class="table" id="table">
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- 内容区结束 -->
                <div class="row">
                    <div class="col-lg-4 text-left">
                        <a class="btn btn-info" href="StudentToAddServlet">添加学生</a>
                    </div>
                    <div class="col-lg-4 text-center">
                        <nav>
                            <ul class="pagination">

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
<script src="https://unpkg.com/bootstrap-table@1.22.0/dist/bootstrap-table.min.js"></script>
<script>
    var table = $("#table");
    table.bootstrapTable({
        url: "StudentPageJsonServlet",
        pagination: true,
        sidePagination: "server",
        queryParamsType: "",
        responseHandler: function (data) {
            console.log(data);
            return {
                "total": data.count,
                "rows": data.page
            }
        },
        paginationPreText: "上一页",
        paginationNextText: "下一页",
        columns: [
            {
                title: "学号",
                field: "studentId"
            }, {
                title: "学员名称",
                field: "studentName"
            }, {
                title: "所在班级",
                field: "class1.className"
            }, {
                title: "性别",
                formatter: function (value, row, index, field) {
                    let s = "";
                    if (row.gender == 1) {
                        s = "男";
                    } else if (row.gender == 0) {
                        s = "女";
                    }
                    return s;
                }
            }, {
                title: "手机号",
                field: "phone"
            }, {
                title: "身份证",
                field: "idCard"
            }, {
                title: "毕业院校",
                field: "graduateSchool"
            }, {
                title: "学历",
                field: "education.educationName"
            }, {
                title: "入学日期",
                field: "admissionTime"
            }, {
                title: "学费",
                field: "tuition"
            }, {
                title: "招生老师",
                field: "employee.empName"
            }, {
                title: "操作",
                formatter: function (value, row, index, field) {
                    let s = '<a onclick="if (confirm(\'是否删除?\')){return true;}else{return false;}" style="margin-right: 10px"  class="btn btn-sm btn-danger" href="StudentDeleteServlet?studentId=' + row.studentId + '">删除</a>';
                    s += '<a class="btn btn-sm  btn-purple" href="StudentToUpdateServlet?studentId=' + row.studentId + '">更新</a>';
                    return s;
                }
            }
        ]
    });
</script>
</body>
</html>
