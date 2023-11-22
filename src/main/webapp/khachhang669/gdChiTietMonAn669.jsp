<%@page import="dao.MonAnDAO669"%>
<%@page import="model.ChiTietCombo669"%>
<%@page import="java.util.List"%>
<%@page import="model.Combo669"%>
<%@page import="model.KhachHang669"%>
<%@page import="model.MonAn669"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MonAnDAO669 monAnDAO;
	monAnDAO = new MonAnDAO669();
	String idC = request.getParameter("idC");
	if(idC != null){
		int id = Integer.parseInt(idC);
		Combo669 combo = monAnDAO.getComboTheoMa(id);
		List<ChiTietCombo669> ds = monAnDAO.getDSChiTietComboCuaCombo(combo);
		request.setAttribute("combo", combo);
		request.setAttribute("dsChiTietCombo", ds);
	}
	String idM = request.getParameter("idM");
	if(idM!=null){
		int ma = Integer.parseInt(idM);
		MonAn669 monAn = new MonAn669();
		List<ChiTietCombo669> ds =(List<ChiTietCombo669>) session.getAttribute("ds");
		for(ChiTietCombo669 i:ds) 
			if(i.getMonAn()!=null && i.getMonAn().getMa() == ma) {
				monAn =  i.getMonAn();
				break;
			}
	    request.setAttribute("monAn", monAn);
	}
	
	
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chi Tiết Món Ăn</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
            <div>
                <a href="khachhang/gdChinhKH669.jsp" class="navbar-brand">Trang Chủ</a>
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
        <h1 class="text-center">Chi Tiết Món Ăn</h1>
        <% 
            MonAn669 monAn =(MonAn669) request.getAttribute("monAn");
            if (monAn != null) {
                String hinhAnh =  monAn.getHinhAnh();
                String ten =  monAn.getTen();
                String loai =  monAn.getLoai();
                double x = monAn.getGia();
                String gia =  String.format( "%.0f", x);
                String moTa = monAn.getMoTa();
        %>
        <div class="row">
            <div class="col-md-6">
                <img src="<%= hinhAnh %>" class="img-fluid" alt="Hình ảnh món ăn">
            </div>
            <div class="col-md-6">
                <h2>Tên: <%= ten %></h2>
                <p><strong>Loại:</strong> <%= loai %></p>
                <p><strong>Giá:</strong> <%= gia %> VNĐ/suất</p>
                <p><strong>Mô Tả:</strong> <%= (moTa != null && !moTa.isEmpty()) ? moTa : "Không có mô tả" %></p>
            </div>
        </div>
        <br></br>
        <div class="container">
		    <button class="btn btn-primary" id="datMonButton">Đặt món</button>
		</div>
        <%
            } 
        %>
        
        <% 
			Combo669 combo =(Combo669) request.getAttribute("combo");
        	List<ChiTietCombo669> ds = (List<ChiTietCombo669>)request.getAttribute("dsChiTietCombo");
			if (combo != null && ds != null) {
			    %>
			    <div class="row">
			        <div class="col-md-6">
			            <img src="<%= combo.getHinhAnh() %>" class="img-fluid" alt="Hình ảnh combo">
			        </div>
			        <div class="col-md-6">
			            <h2>Tên: <%= combo.getTen() %></h2>
			            <p><strong>Giá:</strong> <%= String.format("%.0f VNĐ", combo.getGia()) %>/suất</p>
			            <p><strong>Mô Tả:</strong> <%= combo.getMoTa() %></p>
			        </div>
			    </div>
			    <br></br>
			    <div class="container">
				    <button class="btn btn-primary" id="datMonButton">Đặt combo</button>
				</div>
			    <div class="row">
			        <div class="col-md-12">
			            <h3>Món ăn trong combo:</h3>
			            <table class="table">
			                <thead>
			                    <tr>
			                        <th>Loại</th>
			                        <th>Tên</th>
			                        <th>Giá</th>
			                        <th>Mô Tả</th>
			                        <th>Số Lượng</th>
			                    </tr>
			                </thead>
			                <tbody>
			                    <%
			                    if (ds != null && !ds.isEmpty()) {
			                        for (ChiTietCombo669 chiTiet : ds) {
			                            MonAn669 mon = chiTiet.getMonAn();
			                            %>
			                            <tr>
			                                <td><%= mon.getLoai() %></td>
			                                <td><%= mon.getTen() %></td>
			                                <td><%= String.format("%.0f VNĐ", mon.getGia()) %></td>
			                                <td><%= (mon.getMoTa() != null && !mon.getMoTa().isEmpty()) ? mon.getMoTa() : "Không có mô tả" %></td>
			                                <td><%= chiTiet.getSoLuong() %></td>
			                            </tr>
			                            <%
			                        }
			                    } else {
			                        %>
			                        <tr>
			                            <td colspan="5">Không có món ăn trong combo.</td>
			                        </tr>
			                        <%
			                    }
			                    %>
			                </tbody>
			            </table>
			        </div>
			    </div>
			    <%
			}
			%>

    <script>
	    document.getElementById('datMonButton').addEventListener('click', function () {
	        alert("Đang phát triển");
	    });
	</script> 
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