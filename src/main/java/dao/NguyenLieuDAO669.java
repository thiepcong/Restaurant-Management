package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.ChiTietNhap669;
import model.HoaDonNhap669;
import model.NguyenLieu669;

public class NguyenLieuDAO669 extends DAO669{
	public NguyenLieuDAO669() {
		// TODO Auto-generated constructor stub
	}
	public List<ChiTietNhap669> getNguyenLieuCuaHoaDonNhap(HoaDonNhap669 hdn){
		List<ChiTietNhap669> ds = new ArrayList<ChiTietNhap669>();
		String sql = "SELECT * FROM ChiTietNhap669 WHERE HoaDonNhap669ma = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
	        
	        ps.setInt(1, hdn.getMa());
	        ResultSet rs = ps.executeQuery();
	        System.out.println(ps);
	        while(rs.next()) {
	        	ChiTietNhap669 ctn = new ChiTietNhap669();
//	        	ctn.setGia(rs.getFloat("gia"));
	        	ctn.setGiamGia(rs.getDouble("giamGia"));
	        	ctn.setMa(rs.getInt("ma"));
	        	ctn.setNgayHetHan(rs.getDate("ngayHetHan"));
	        	ctn.setNgayXuat(rs.getDate("ngayXuat"));
	        	ctn.setSoLuong(rs.getInt("soLuong"));
	        	ctn.setNguyenLieu(getNguyenLieuTheoMa(rs.getInt("NguyenLieu669ma")));
	        	ctn.setTong(ctn.getNguyenLieu().getGia()*ctn.getSoLuong()-ctn.getGiamGia());
	        	ds.add(ctn);
	        }
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return ds;
	}
	
	public NguyenLieu669 getNguyenLieuTheoMa(int ma) {
		NguyenLieu669 nl = new NguyenLieu669();
		String sql = "SELECT * FROM NguyenLieu669 Where ma = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ma);
			ResultSet rs = ps.executeQuery();
			System.out.println(ps);
			while(rs.next()) {
				nl.setGia(rs.getFloat("gia"));
				nl.setLoai(rs.getString("loai"));
				nl.setMa(ma);
				nl.setTen(rs.getString("ten"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return nl;
	}
}
