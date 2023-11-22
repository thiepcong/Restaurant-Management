package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.ChiTietNhap669;
import model.HoaDonNhap669;
import model.NhaCungCap669;

public class HoaDonNhapDAO669 extends DAO669{
	public HoaDonNhapDAO669() {
		// TODO Auto-generated constructor stub
	}
	
	public List<HoaDonNhap669> getHoaDonNhapCuaNCC(NhaCungCap669 nhaCungCap, Date bd, Date kt){
		List<HoaDonNhap669> ds = new ArrayList<HoaDonNhap669>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql = "SELECT * FROM HoaDonNhap669 WHERE NhaCungCap669ma = ? AND ngay >= ? AND ngay <= ?";
		NguyenLieuDAO669 nld = new NguyenLieuDAO669();
		NguoiDungDAO669 nd = new NguoiDungDAO669();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
	        ps.setInt(1, nhaCungCap.getMa());
	        ps.setString(2, sdf.format(bd));
	        ps.setString(3, sdf.format(kt));
	        ResultSet rs = ps.executeQuery();
	        System.out.println(ps);
	        while(rs.next()) {
	        	HoaDonNhap669 hdn = new HoaDonNhap669();
	        	hdn.setNhaCungCap(nhaCungCap);
	        	hdn.setNgay(rs.getDate("ngay"));
	        	hdn.setMa(Integer.parseInt(rs.getString("ma")));
	        	hdn.setMaHoaDon(rs.getString("maHoaDon"));
	        	hdn.setNhanVien(nd.getNhanVienTheoMa(rs.getInt("NhanVien669ma")));
	        	double tong = 0;
	        	List<ChiTietNhap669> dsc = nld.getNguyenLieuCuaHoaDonNhap(hdn);
	        	hdn.setDanhSachNgyenLieu(dsc);
	        	for(ChiTietNhap669 i : dsc) {
	        		tong += i.getTong();
	        	}
	        	hdn.setTong(tong);
	        	ds.add(hdn);
	        }
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return ds;
	}
}
