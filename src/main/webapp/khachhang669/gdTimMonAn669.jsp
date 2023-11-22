<%@page import="dao.MonAnDAO669"%>
<%@page import="model.KhachHang669"%>
<%@page import="model.ChiTietCombo669"%>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MonAnDAO669 dao;
	dao = new MonAnDAO669();
	String key = request.getParameter("search");
	if(key!=null){
		List<ChiTietCombo669> result = dao.getDSMonAn(key.trim());
		request.setAttribute("ds", result);
		session.setAttribute("ds", result);
	}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tìm kiếm món ăn</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        .card:hover {
            transform: translateY(-5px); 
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        .food-card {
            text-decoration: none;
            color: inherit;
        }

        .food-card .card {
            margin-bottom: 20px;
        }

        .food-card .card-img-top {
            max-height: 200px;
            object-fit: cover;
        }

        .food-card .card-title {
            font-size: 18px;
            text-align: center;
            margin-top: 10px;
        }

        .food-card .card-text {
            font-size: 14px;
            text-align: center;
        }
    </style>
</head>
<body>
	<header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
            <div>
                <a href="gdChinhKH669.jsp" class="navbar-brand">Trang Chủ</a>
            </div>
            <span class="navbar-text">
                <%
                	KhachHang669 user = (KhachHang669) session.getAttribute("user");

                    if (user != null) {
                %>
                    Khách hàng: <%= user.getTen() %>
                <%
                    } else {
                %>
                    Khách hàng
                <%
                    }
                %>
            </span>
        </nav>
    </header>
	<div class="container mt-4">
        <h1 class="text-center">Tìm kiếm món ăn</h1>
        <div class="row">
            <div class="col-md-6 offset-md-3">
            	<form action="" method="get">
            		<div class="input-group mb-3">
	                    <input type="text" class="form-control" name = "search" placeholder="Nhập tên món ăn" value="<% if (request.getParameter("search") != null) { %><%= request.getParameter("search") %><% } %>">
	                    <div class="input-group-append">
	                        <button class="btn btn-primary"  type="submit">Tìm kiếm</button>
	                    </div>
	                </div>
            	</form>
            </div>
        </div>
       <div class="row" id="results">
		    <%
		        List<ChiTietCombo669> ds = (List<ChiTietCombo669>) request.getAttribute("ds");
		        //List<ChiTietCombo669> dsCombo = (List<ChiTietCombo669>) request.getAttribute("dsCombo");
		
		        if (ds != null && !ds.isEmpty()) {
		            for (ChiTietCombo669 food : ds) {
		            	if(food.getMonAn()!=null){
		    %>
			                <div class="col-md-4">
			                    <a href="gdChiTietMonAn669.jsp?idM=<%= food.getMonAn().getMa()%>" class="food-card">
			                        <div class="card">
			                            <img src="<%= food.getMonAn().getHinhAnh() %>" class="card-img-top" alt="<%= food.getMonAn().getTen() %>">
			                            <div class="card-body">
			                                <h5 class="card-title"><%= food.getMonAn().getTen() %></h5>
			                                <p class="card-text">Giá: <%= String.format("%.0f VNĐ/suất", food.getMonAn().getGia()) %></p>
			                            </div>
			                        </div>
			                    </a>
			                </div>
		    <%
		            	}else{
		    %>
			                <div class="col-md-4">
			                    <a href="gdChiTietMonAn669.jsp?idC=<%= food.getCombo().getMa()%>" class="food-card">
			                        <div class="card">
			                            <img src="<%= food.getCombo().getHinhAnh() %>" class="card-img-top" alt="<%= food.getCombo().getTen() %>">
			                            <div class="card-body">
			                                <h5 class="card-title"><%= food.getCombo().getTen() %></h5>
			                                <p class="card-text"><%= String.format("Giá: %.0f VNĐ", food.getCombo().getGia()) %></p>
			                            </div>
			                        </div>
			                    </a>
			                </div>
		    <%
		            	}
		            }
		        }
		        else if(ds != null){
		    %>
		            <p>Không tìm thấy kết quả phù hợp.</p>
		    <%
		        }
		    %>
		</div>


    </div>
    <div class="container mt-4">
        <button id="quayLai" class="btn btn-primary">Quay Lại</button>
    </div>
    <script>
        document.getElementById("quayLai").addEventListener("click", function() {
            window.history.back();
        });
    </script>
</body>
</html>