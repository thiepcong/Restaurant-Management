package model;

import java.util.Date;
import java.util.List;

public class ThongtinDatBan669 {
	private int ma;
	private Date ngayDat;
	private String ghiChu;
	private boolean trangThai ;
	private List<ChiTietDat669> dsDat;
	private KhachHang669 khachHang;
	public ThongtinDatBan669() {
		// TODO Auto-generated constructor stub
	}
	public ThongtinDatBan669(int ma, Date ngayDat, String ghiChu, boolean trangThai, List<ChiTietDat669> dsDat,
			KhachHang669 khachHang) {
		super();
		this.ma = ma;
		this.ngayDat = ngayDat;
		this.ghiChu = ghiChu;
		this.trangThai = trangThai;
		this.dsDat = dsDat;
		this.khachHang = khachHang;
	}
	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	public Date getNgayDat() {
		return ngayDat;
	}
	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	public List<ChiTietDat669> getDsDat() {
		return dsDat;
	}
	public void setDsDat(List<ChiTietDat669> dsDat) {
		this.dsDat = dsDat;
	}
	public KhachHang669 getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang669 khachHang) {
		this.khachHang = khachHang;
	}
	
}
