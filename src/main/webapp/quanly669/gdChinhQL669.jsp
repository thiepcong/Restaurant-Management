<%@page import="model.NhanVien669"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang Chủ</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
            <div>
                <a href="#" class="navbar-brand">Trang Chủ</a>
            </div>
            <div>
	            <span class="navbar-text">
	                <%
	                    NhanVien669 user = (NhanVien669) session.getAttribute("user");
	
	                    if (user != null) {
	                %>
	                    Quản lý: <%= user.getTen() %>
	                <%
	                    } else {
	                %>
	                    Quản lý
	                <%
	                    }
	                %>
	            </span>
	        </div>
        </nav>
    </header>

    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <h2 class="text-center">Chào mừng đến với Trang Chủ Cho Quản Lý</h2>
                <div class="text-center">
                    <a href="quanly669/gdXemBaoCao669.jsp" class="btn btn-primary">Xem báo cáo</a>
                </div>
            </div>
        </div>
    </div>

</body>
</html>