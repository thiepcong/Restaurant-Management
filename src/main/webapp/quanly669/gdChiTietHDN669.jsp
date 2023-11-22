<%@page import="model.HoaDonNhap669"%>
<%@page import="model.TKNhaCungCap669"%>
<%@page import="model.NhanVien669"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.ChiTietNhap669"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getParameter("id")!=null){
		int id = Integer.parseInt(request.getParameter("id"));
		HoaDonNhap669 hdns = new HoaDonNhap669();
		List<HoaDonNhap669> dsTKNCC =(List<HoaDonNhap669>) session.getAttribute("dsHDN");
		for(HoaDonNhap669 i:dsTKNCC) {
			if(i.getMa()==id){
				hdns = i;
				break;
			}
		}
		request.setAttribute("HDN", hdns);
	}
	
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi tiết hoá đơn nhập</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
            <div>
                <a href="#" class="navbar-brand">Trang Chủ</a>
            </div>
            <span class="navbar-text">
                <% SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
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
    <div class="container mt-8" >
        <h2 class="text-center">Chi tiết hoá đơn nhập</h2>
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
        <h5 class="text-start">
        	<%
        		HoaDonNhap669 hdn = (HoaDonNhap669) request.getAttribute("HDN");

                    if (hdn != null) {
            %>
            	Nhân viên nhập liệu: <%= hdn.getNhanVien().getTen() %><br>
        		Mã hoá đơn: <%= hdn.getMaHoaDon() %><br>
        		Ngày nhập: <%= sdf.format(hdn.getNgay()) %><br>
        		Tổng tiền: <%= String.format("%.0f VNĐ",hdn.getTong()) %><br>
        	<%
                    }
            %>
        </h5>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>Mã Nguyên Liệu</th>
                    <th>Tên</th>
                    <th>Giá</th>
                    <th>Số Lượng</th>
                    <th>Ngày Sản Xuất</th>
                    <th>Ngày Hết Hạn</th>
                    <th>Giảm Giá</th>
                    <th>Thành Tiền</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<ChiTietNhap669> ds = hdn.getDanhSachNgyenLieu();
                    if (ds != null && !ds.isEmpty()) {
                        for (ChiTietNhap669 ctn : ds) {
                        	String tong = String.format("%.0f", ctn.getTong());
                        	String giamGia = String.format("%.0f", ctn.getGiamGia());
                        	String ngayX = sdf.format(ctn.getNgayXuat());
                        	String ngayHH = sdf.format(ctn.getNgayHetHan());
                        	String gia = String.format("%.0f", ctn.getNguyenLieu().getGia());
                        	
                %>
                <tr>
                    <td><%= ctn.getNguyenLieu().getMa() %></td>
                    <td><%= ctn.getNguyenLieu().getTen() %></td>
                    <td><%= gia %></td>
                    <td><%= ctn.getSoLuong() %></td>
                    <td><%= ngayX %></td>
                    <td><%= ngayHH %></td>
                    <td><%= giamGia %></td>
                    <td><%= tong %> VNĐ</td>
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
        <button class="btn btn-primary" id="printInvoice">In hoá đơn</button>
    </div>
    <div class="container mt-4">
        <button id="quayLai" class="btn btn-primary">Quay Lại</button>
    </div>
    <script>
        document.getElementById("quayLai").addEventListener("click", function() {
            window.history.back();
        });
    </script>
    <script>
        document.getElementById('printInvoice').addEventListener('click', function () {
            var newTab = window.open('', '_blank');
            var tabContent = '<html><head>' +
                '<link rel="stylesheet" href="your-bootstrap-css-file.css">' +
                '</head><body>' +
                '<div class="container">' +
                '<h2>Hoá Đơn</h2>' +
                '<div id="hoaDonData">' +
                '</div>' +
                '</div>' +
                '</body></html>';
            
            newTab.document.open();
            newTab.document.write(tabContent);
            newTab.document.close();
        });

    </script>
</body>
</html>