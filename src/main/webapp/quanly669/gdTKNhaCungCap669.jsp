<%@page import="java.text.ParseException"%>
<%@page import="dao.TKNhaCungCapDAO669"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.NhanVien669"%>
<%@page import="model.TKNhaCungCap669"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	try {
		TKNhaCungCapDAO669 dao = new TKNhaCungCapDAO669();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String startd = request.getParameter("start");
		String endD = request.getParameter("end");
		if(endD!=null && startd!=null){
			Date start =sdf.parse( startd);
			Date end =sdf.parse( endD);
			List<TKNhaCungCap669> ds = dao.getTKNhaCC(start, end);
			session.setAttribute("dsNCC", ds);
			request.setAttribute("dsNCC", ds);
			request.removeAttribute("errorMessage");
		}
	} catch (Exception ex) {
		if(ex instanceof ParseException) {
			request.setAttribute("errorMessage", "Định dạng ngày không chính xác");
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thống kê nhà cung cấp</title>
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
        <h2 class="text-center">Thống kê nhà cung cấp</h2>
        <form class="form-inline justify-content-center mb-4" >
            <div class="form-group">
                <label for="ngayBatDau" class="mr-2">Ngày bắt đầu:</label>
                <input type="date" class="form-control" id="ngayBatDau" name = "start" value="<%= request.getParameter("start") %>">
            </div>
            <div class="form-group ml-4">
                <label for="ngayKetThuc" class="mr-2">Ngày kết thúc:</label>
                <input type="date" class="form-control" id="ngayKetThuc" name = "end" value="<%= request.getParameter("end") %>">
            </div>
            <button type="submit" class="btn btn-primary ml-4" id="btnThongKe">Thống kê</button>
        </form>
        <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
            <% if (errorMessage != null) { %>
                <div class="alert alert-danger">
                    <%= errorMessage %>
                </div>
            <% } 
         %>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>Mã Nhà Cung Cấp</th>
                    <th>Tên</th>
                    <th>Số lần nhập</th>
                    <th>Tổng tiền</th>
                    <th>Chi tiết</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<TKNhaCungCap669> ds = (List<TKNhaCungCap669>) request.getAttribute("dsNCC");
                    
                    if (ds != null && !ds.isEmpty()) {
                        for (TKNhaCungCap669 nhaCungCap : ds) {
                        	double x =  nhaCungCap.getTongTien();
                        	String tong = String.format("%.0f", x);
                %>
                <tr>
                    <td><%= nhaCungCap.getMa() %></td>
                    <td><%= nhaCungCap.getTen() %></td>
                    <td><%= nhaCungCap.getLanNhap() %></td>
                    <td><%= tong %> VNĐ</td>
                    <td><a href="gdChiTietNhaCC669.jsp?id=<%= nhaCungCap.getMa() %>&start=<%= request.getParameter("start") %>&end=<%= request.getParameter("end") %>" class="btn btn-info">Xem chi tiết</a></td>
                </tr>
                <%
                        }
                    } else if(ds != null){
                %>
                <tr>
                    <td colspan="5">Không có dữ liệu thống kê.</td>
                </tr>
                <%
                    } else{
                %>
                <tr>
                    <td colspan="5">Hãy chọn ngày bắt đầu và ngày kết thúc để thống kê.</td>
                </tr>
                <%
                    } 
                %>
            </tbody>
        </table>
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