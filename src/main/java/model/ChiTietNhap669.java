package model;

import java.util.Date;

public class ChiTietNhap669 {
	private int ma;
//	private float gia;
	private int soLuong;
	private double giamGia;
	private Date ngayXuat;
	private Date ngayHetHan;
	private double tong;
	private NguyenLieu669 nguyenLieu;
	
	public ChiTietNhap669() {
		// TODO Auto-generated constructor stub
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

//	public float getGia() {
//		return gia;
//	}
//
//	public void setGia(float gia) {
//		this.gia = gia;
//	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}

	public double getTong() {
		return tong;
	}

	public void setTong(double tong) {
		this.tong = tong;
	}
	
	public Date getNgayXuat() {
		return ngayXuat;
	}

	public void setNgayXuat(Date ngayXuat) {
		this.ngayXuat = ngayXuat;
	}

	public Date getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public NguyenLieu669 getNguyenLieu() {
		return nguyenLieu;
	}

	public void setNguyenLieu(NguyenLieu669 nguyenLieu) {
		this.nguyenLieu = nguyenLieu;
	}

	public ChiTietNhap669(int ma,  int soLuong, double giamGia, Date ngayXuat, Date ngayHetHan, double tong,
			NguyenLieu669 nguyenLieu) {
		super();
		this.ma = ma;
//		this.gia = gia;
		this.soLuong = soLuong;
		this.giamGia = giamGia;
		this.ngayXuat = ngayXuat;
		this.ngayHetHan = ngayHetHan;
		this.tong = tong;
		this.nguyenLieu = nguyenLieu;
	}

	
	
}
