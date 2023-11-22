package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.KhachHang669;
import model.NguoiDung669;
import model.NhanVien669;

public class NguoiDungDAO669 extends DAO669 {
	public NguoiDungDAO669() {
		super();
	}
	
	public Object kiemTraDangNhap(NguoiDung669 nd) {
			
//        boolean result = false;
        String sql1 = "SELECT * FROM KhachHang669 WHERE tenNguoiDung = ? AND matKhau = ?";
        String sql2 = "SELECT * FROM NhanVien669 WHERE tenNguoiDung = ? AND matKhau = ?";
        try {
            PreparedStatement ps1 = con.prepareStatement(sql1);
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps1.setString(1, nd.getTenNguoiDung());
            ps1.setString(2, nd.getMatKhau());
            ps2.setString(1, nd.getTenNguoiDung());
            ps2.setString(2, nd.getMatKhau());
            ResultSet rs1 = ps1.executeQuery();
            ResultSet rs2 = ps2.executeQuery();
            System.out.println(ps1);
            System.out.println(ps2);
            if(rs1.next()) {
            	KhachHang669 khachHang = new KhachHang669();
                khachHang.setMaKhachHang(rs1.getString("makhachHang"));
                khachHang.setSoDienThoai(rs1.getString("sodienthoai"));
                khachHang.setDiaChi(rs1.getString("diachi"));
                khachHang.setGhiChu(rs1.getString("ghiChu"));
                khachHang.setEmail(rs1.getString("email"));
                khachHang.setTen(rs1.getString("ten"));
                khachHang.setMa(Integer.parseInt(rs1.getString("ma")));
                khachHang.setMatKhau(nd.getMatKhau());
                khachHang.setTenNguoiDung(nd.getTenNguoiDung());
//                nd = khachHang;
//                System.out.print(nd);
//                result = true;
                return khachHang;
            }else if(rs2.next()) {
            	NhanVien669 nhanVien = new NhanVien669();
                nhanVien.setDiaChi(rs2.getString("diachi"));
                nhanVien.setGhiChu(rs2.getString("ghiChu"));
                nhanVien.setMaNhanVien(rs2.getString("maNhanVien"));
                nhanVien.setTen(rs2.getString("ten"));
                nhanVien.setMa(Integer.parseInt(rs2.getString("ma")));
                nhanVien.setMatKhau(nd.getMatKhau());
                nhanVien.setTenNguoiDung(nd.getTenNguoiDung());
//                nd = nhanVien;
//                System.out.print(nd);
//                result = true;
                return nhanVien;
            }else return null;
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	NhanVien669 getNhanVienTheoMa(int ma) {
		NhanVien669 nv = new NhanVien669();
		String sql = "SELECT * FROM NhanVien669 WHERE ma = ? ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ma);
			ResultSet rs = ps.executeQuery();
	        System.out.println(ps);
	        if(rs.next()) {
	        	nv.setDiaChi(rs.getString("diaChi"));
	        	nv.setMa(ma);
	        	nv.setMaNhanVien(rs.getString("maNhanVien"));
	        	nv.setTen(rs.getString("ten"));
	        	nv.setViTri(rs.getString("viTri"));
	        	nv.setTenNguoiDung(rs.getString("tenNguoiDung"));
	        	nv.setMatKhau(rs.getString("MatKhau"));
	        	nv.setGhiChu(rs.getString("ghiChu"));
	        }
		}catch(Exception e) {
			e.printStackTrace();
		}
		return nv;
	}
}
