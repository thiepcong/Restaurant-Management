<%@page import="model.KhachHang669"%>
<%@page import="model.NhanVien669"%>
<%@page import="dao.NguoiDungDAO669"%>
<%@page import="model.NguoiDung669"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<%
	NguoiDungDAO669 nguoiDungDAO;
	nguoiDungDAO = new NguoiDungDAO669();
	String tenNguoiDung = request.getParameter("username");
	String matKhau = request.getParameter("password");
	if(tenNguoiDung!=null &&matKhau!=null){NguoiDung669 nd = new NguoiDung669(tenNguoiDung,matKhau);
	Object rs = nguoiDungDAO.kiemTraDangNhap(nd);
	if(rs != null) {
		session.setAttribute("user", rs);
		if(rs instanceof NhanVien669) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("quanly669/gdChinhQL669.jsp");
	        dispatcher.forward(request, response);
		}else if(rs instanceof KhachHang669){
			RequestDispatcher dispatcher = request.getRequestDispatcher("khachhang669/gdChinhKH669.jsp");
	        dispatcher.forward(request, response);
		}else {
	//		System.out.println(nd+" 1");
		}
	}else {
		request.setAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng");
	}}
%>
<html>
<head>
	<meta charset="UTF-8">
	<title>ĐĂNG NHẬP</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
            <div>
                <a href="#" class="navbar-brand">Nhà Hàng Của THIỆP</a>
            </div>


            <ul class="navbar-nav">
                <li><a href="#" class="nav-link">ĐĂNG NHẬP</a></li>
            </ul>
        </nav>
    </header>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <h2 class="text-center">Đăng nhập</h2>
                <form action="" method="post"> 
                    <div class="form-group">
                        <label for="username">Tên đăng nhập:</label>
                        <input type="text" class="form-control" id="username" name="username" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Mật khẩu:</label>
                        <input type="password" class="form-control" id="password" name="password" required>
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">Đăng nhập</button>
                </form>
                 <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
		            <% if (errorMessage != null) { %>
		                <div class="alert alert-danger">
		                    <%= errorMessage %>
		                </div>
		            <% } 
		         %>
            </div>
        </div>
    </div>
</body>
</html>