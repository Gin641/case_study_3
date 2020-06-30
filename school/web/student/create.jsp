<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: No Name
  Date: 6/26/2020
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng ki</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="studentCss/images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="<c:url value="studentCss/vendor/bootstrap/css/bootstrap.min.css"/>"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="studentCss/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="studentCss/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="studentCss/vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="studentCss/vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="studentCss/vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="studentCss/vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="studentCss/vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="studentCss/css/util.css">
    <link rel="stylesheet" type="text/css" href="studentCss/css/main.css">
    <!--===============================================================================================-->
</head>
<body>
<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">
            <form method="post" class="login100-form validate-form" action="student?action=create">
                <h2>
                    <a href="student?action=login">Quay về</a>
                </h2>
					<span class="login100-form-title p-b-33">
						Đăng ký
					</span>
                <c:if test="${requestScope['messages']!=null}">
                    <span style="color: red" class="message">${requestScope["messages"]}</span>
                </c:if>
                <div class="wrap-input100 validate-input" data-validate = "Nhập họ và tên">
                    <input class="input100" type="text" name="name" placeholder="Họ và tên">
                    <span class="focus-input100-1"></span>
                    <span class="focus-input100-2"></span>
                </div>
                <div class="wrap-input100">
                    <input class="input100" type="text" name="idschool" placeholder="Mã Trường">
                    <span class="focus-input100-1"></span>
                    <span class="focus-input100-2"></span>
                </div>
                <div class="wrap-input100 validate-input" data-validate = "Nhập email">
                    <input class="input100" type="text" name="email" placeholder="Email">
                    <span class="focus-input100-1"></span>
                    <span class="focus-input100-2"></span>
                </div>

                <div class="wrap-input100 rs1 validate-input" data-validate="Nhập mật khẩu">
                    <input class="input100" type="password" name="pass" placeholder="Mật khẩu">
                    <span class="focus-input100-1"></span>
                    <span class="focus-input100-2"></span>
                </div>
                <div class="wrap-input100 validate-input" data-validate = "Nhập SĐT">
                    <input class="input100" type="text" name="phone" placeholder="SĐT">
                    <span class="focus-input100-1"></span>
                    <span class="focus-input100-2"></span>
                </div>
                <div class="wrap-input100 validate-input" data-validate = "Nhập ngày sinh">
                    <input class="input100" type="date" name="birthday">
                    <span class="focus-input100-1"></span>
                    <span class="focus-input100-2"></span>
                </div>
                <div class="wrap-input100 validate-input">
                    <input type="text" class="input100" name = "sex" placeholder="giới tính">
                    <span class="focus-input100-1"></span>
                    <span class="focus-input100-2"></span>
                </div>
                <div class="container-login100-form-btn m-t-20">
                    <input type="submit" value="Đăng ký" class="container-login100-form-btn m-t-20">
                </div>
            </form>
        </div>
    </div>
</div>
<!--===============================================================================================-->
<script src="studentCss/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="studentCss/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="studentCss/vendor/bootstrap/js/popper.js"></script>
<script src="studentCss/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="studentCss/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="studentCss/vendor/daterangepicker/moment.min.js"></script>
<script src="studentCss/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="studentCss/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="studentCss/js/main.js"></script>

</body>
</html>
