package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.ChiTietCombo669;
import model.Combo669;
import model.MonAn669;

public class MonAnDAO669 extends DAO669{
	public MonAnDAO669() {
		// TODO Auto-generated constructor stub
	}
	
	public List<ChiTietCombo669> getDSMonAn(String tuKhoa) {
		List<ChiTietCombo669> ds = new ArrayList<ChiTietCombo669>();
		String sql1 = "SELECT * FROM MonAn669 WHERE ten LIKE ?";
		String sql2 = "SELECT * FROM Combo669 WHERE ten LIKE ?";
		try{
	        PreparedStatement ps1 = con.prepareStatement(sql1);
	        PreparedStatement ps2 = con.prepareStatement(sql2);
	        ps1.setString(1,"%"+ tuKhoa+"%");
	        ps2.setString(1, "%"+tuKhoa+"%");
	        ResultSet rs1 = ps1.executeQuery();
	        ResultSet rs2 = ps2.executeQuery();
	        System.out.println(ps1);
	        System.out.println(ps2);
	        while(rs1.next()){
	        	ds.add(new ChiTietCombo669(getMonAnTheoMa(rs1.getInt("ma"))));
	        }
	        while(rs2.next()){
	        	ds.add(new ChiTietCombo669(getComboTheoMa(rs2.getInt("ma"))));
	        }
	    }catch(Exception e){
	        e.printStackTrace();
	    }   
		
		
		
		return ds;
	}
	
	public MonAn669 getMonAnTheoMa(int ma) {
		MonAn669 mon = new MonAn669();
		String sql = "SELECT * FROM MonAn669 WHERE ma = ?";
		try{
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, ma);
	        ResultSet rs = ps.executeQuery();
	        System.out.println(ps);
	        if(rs.next()){
	        	mon.setMa(ma);
	        	mon.setGia(rs.getDouble("gia"));
	        	mon.setHinhAnh(rs.getString("hinhAnh"));
	        	mon.setLoai(rs.getString("loai"));
	        	mon.setTen(rs.getString("ten"));
	        	mon.setMoTa(rs.getString("moTa"));
	        	return mon;
	        }
	    }catch(Exception e){
	    	  e.printStackTrace();
	    }return null;
	}
	
	public Combo669 getComboTheoMa(int ma) {
		Combo669 combo = new Combo669();
		String sql = "SELECT * FROM Combo669 WHERE ma = ?";
		try{
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, ma);
	        ResultSet rs = ps.executeQuery();
	        System.out.println(ps);
	        if(rs.next()){
	        	combo.setMa(ma);
	        	combo.setHinhAnh(rs.getString("hinhAnh"));
	        	combo.setTen(rs.getString("ten"));
	        	combo.setMoTa(rs.getString("moTa"));
	        	List<ChiTietCombo669> ds = getDSChiTietComboCuaCombo(combo);
	        	float gia1 = 0;
	        	for(ChiTietCombo669 i:ds) {
	        		gia1 += i.getMonAn().getGia()*i.getSoLuong();
	        	}
	        	combo.setGia(gia1);
	        	return combo;
	        }
	    }catch(Exception e){
	    	  e.printStackTrace();
	    }return null;
	}
	
	public List<ChiTietCombo669> getDSChiTietComboCuaCombo(Combo669 combo){
		List<ChiTietCombo669> ds = new ArrayList<ChiTietCombo669>();
		String sql = "SELECT * FROM ChiTietCombo669 WHERE Combo669ma = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, combo.getMa());
	        ResultSet rs = ps.executeQuery();
	        System.out.println(ps);
	        while(rs.next()) {
	        	ds.add(new ChiTietCombo669(rs.getInt("ma"),
	        			getMonAnTheoMa(rs.getInt("MonAn669ma")),combo,rs.getInt("soLuong")));
	        }
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
}
