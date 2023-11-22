<%@page import="model.NhanVien669"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Xem báo cáo</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
            <div>
                <a href="#" class="navbar-brand">Trang Chủ</a>
            </div>
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
        </nav>
    </header>

    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <h2 class="text-center">Xem báo cáo</h2>
                <div class="text-center">
                    <a href="gdTKNhaCungCap669.jsp" class="btn btn-primary mb-2">Thống kê nhà cung cấp</a>
                </div>
                <div class="text-center">
                    <a href="#" class="btn btn-primary mb-2" id = "developing1">Thống kê món ăn</a>
                </div>
                <div class="text-center">
                    <a href="#" class="btn btn-primary mb-2" id = "developing2">Thống kê khách hàng</a>
                </div>
            </div>
        </div>
    </div>
    <div class="container mt-4">
        <button id="quayLai" class="btn btn-primary">Quay Lại</button>
    </div>
    <script>
	    document.getElementById('developing1').addEventListener('click', function () {
	    	hienThongBao();
	    }); 
	    document.getElementById('developing2').addEventListener('click', function () {
	    	hienThongBao();
	    });
	    function hienThongBao() {
	        alert("Đang phát triển");
	    }
        document.getElementById("quayLai").addEventListener("click", function() {
            window.history.back();
        });
    </script>
</body>
</html>