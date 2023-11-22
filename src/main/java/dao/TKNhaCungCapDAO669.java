package dao;

import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.HoaDonNhap669;
import model.TKNhaCungCap669;

public class TKNhaCungCapDAO669 extends DAO669{
	public TKNhaCungCapDAO669() {
		// TODO Auto-generated constructor stub
	}
	
	public List<TKNhaCungCap669> getTKNhaCC(Date bd, Date kt){
		List<TKNhaCungCap669> ds = new ArrayList<TKNhaCungCap669>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql = "SELECT DISTINCT ncc.ma AS ma, ncc.ten AS ten, ncc.diaChi as diaChi, ncc.email AS email, ncc.dienThoai AS dienThoai, ncc.moTa AS moTa "
				+ "FROM HoaDonNhap669 hdn "
				+ "INNER JOIN NhaCungCap669 ncc ON ncc.ma = hdn.NhaCungCap669ma "
				+ "WHERE  hdn.ngay >= ? AND hdn.ngay <= ?";
		HoaDonNhapDAO669 hdnd = new HoaDonNhapDAO669();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
	        
	        ps.setString(1, sdf.format(bd));
	        ps.setString(2, sdf.format(kt));
	        ResultSet rs = ps.executeQuery();
	        System.out.println(ps);
	        while(rs.next()) {
	        	TKNhaCungCap669 ncc = new TKNhaCungCap669();
	        	ncc.setDiaChi(rs.getString("diaChi"));
	        	ncc.setDienThoai(rs.getString("dienThoai"));
	        	ncc.setEmail(rs.getString("email"));
	        	ncc.setMa(rs.getInt("ma"));
	        	ncc.setMoTa(rs.getString("moTa"));
	        	ncc.setTen(rs.getString("ten"));
	        	List<HoaDonNhap669> dsHoaDonNhap = hdnd.getHoaDonNhapCuaNCC(ncc, bd, kt);
	        	ncc.setLanNhap(dsHoaDonNhap.size());
	        	double tong = 0;
	        	for(HoaDonNhap669 i:dsHoaDonNhap) {
	        		tong+=i.getTong();
	        	}
	        	ncc.setTongTien(tong);
	        	ds.add(ncc);
	        }
	        ds.sort((o1, o2) -> o1.getLanNhap()>o2.getLanNhap()?-1:o1.getLanNhap()<o2.getLanNhap()?1:0);
    	}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return ds;
	}
}
