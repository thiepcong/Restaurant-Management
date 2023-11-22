<%@page import="model.NhaCungCap669"%>
<%@page import="dao.HoaDonNhapDAO669"%>
<%@page import="java.util.Date"%>
<%@page import="model.TKNhaCungCap669"%>
<%@page import="model.NhanVien669"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.HoaDonNhap669"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	if(request.getParameter("id")!=null && request.getParameter("start")!=null&&request.getParameter("end")!=null){
		HoaDonNhapDAO669 hoaDonNhap = new HoaDonNhapDAO669();
		
		String startd = request.getParameter("start");
		Date start =sdf.parse( startd);
		Date end =sdf.parse( request.getParameter("end"));
		int id = Integer.parseInt(request.getParameter("id"));
		List<HoaDonNhap669> dsHDN = hoaDonNhap.getHoaDonNhapCuaNCC(new NhaCungCap669(id),start, end);
		TKNhaCungCap669 tkncc = new TKNhaCungCap669();
		List<TKNhaCungCap669> dsTKNCC =(List<TKNhaCungCap669>) session.getAttribute("dsNCC");
		for(TKNhaCungCap669 i:dsTKNCC) {
			if(i.getMa()==id){
				tkncc =  i;
				break;
			}
		}
		session.setAttribute("NCC", tkncc);
		session.setAttribute("dsHDN", dsHDN);
	}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi tiết nhà cung cấp</title>
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
        <h2 class="text-center">Danh sách hoá đơn nhập</h2>
        <h3 class="text-start">
        	<%
        			TKNhaCungCap669 ncc = (TKNhaCungCap669) session.getAttribute("NCC");

                    if (ncc != null) {
            %>
        		Nhà cung cấp: <%= ncc.getTen() %>
        	<%
                    }
            %>
        </h3>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>Mã Hoá Đơn nhập</th>
                    <th>Ngày Nhập</th>
                    <th>Số Nguyên Liệu</th>
                    <th>Tổng tiền</th>
                    <th>Chi tiết</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<HoaDonNhap669> ds = (List<HoaDonNhap669>) session.getAttribute("dsHDN");
                    if (ds != null && !ds.isEmpty()) {
                        for (HoaDonNhap669 hdn : ds) {
                        	double x =  hdn.getTong();
                        	String tong = String.format("%.0f", x);
                        	String ngay = sdf.format(hdn.getNgay());
                        	
                %>
                <tr>
                    <td><%= hdn.getMaHoaDon() %></td>
                    <td><%= ngay %></td>
                    <td><%= hdn.getDanhSachNgyenLieu().size() %></td>
                    <td><%= tong %> VNĐ</td>
                    <td><a href="gdChiTietHDN669.jsp?id=<%= hdn.getMa() %>" class="btn btn-info">Xem chi tiết</a></td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="5">Không có dữ liệu thống kê.</td>
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