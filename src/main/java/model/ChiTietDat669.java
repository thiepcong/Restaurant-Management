package model;

import java.util.Date;

public class ChiTietDat669 {
	private int ma;
	private Date ngaySuDung;
	private float gia;
	private String ghiChu;
	private Ban669 ban;
	public ChiTietDat669() {
		// TODO Auto-generated constructor stub
	}
	public ChiTietDat669(int ma, Date ngaySuDung, float gia, String ghiChu, Ban669 ban) {
		super();
		this.ma = ma;
		this.ngaySuDung = ngaySuDung;
		this.gia = gia;
		this.ghiChu = ghiChu;
		this.ban = ban;
	}
	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	public Date getNgaySuDung() {
		return ngaySuDung;
	}
	public void setNgaySuDung(Date ngaySuDung) {
		this.ngaySuDung = ngaySuDung;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public Ban669 getBan() {
		return ban;
	}
	public void setBan(Ban669 ban) {
		this.ban = ban;
	}
	
}
