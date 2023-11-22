package model;

import java.util.Date;
import java.util.List;

public class HoaDonNhap669 {
	private int ma;
	private String maHoaDon;
	private Date ngay;
	private double tong;
	private NhanVien669 nhanVien;
	private NhaCungCap669 nhaCungCap;
	private List<ChiTietNhap669> danhSachNgyenLieu;
	
	public HoaDonNhap669() {
		// TODO Auto-generated constructor stub
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	public double getTong() {
		return tong;
	}

	public void setTong(double tong) {
		this.tong = tong;
	}

	public NhanVien669 getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien669 nhanVien) {
		this.nhanVien = nhanVien;
	}

	public NhaCungCap669 getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap669 nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	

	public List<ChiTietNhap669> getDanhSachNgyenLieu() {
		return danhSachNgyenLieu;
	}

	public void setDanhSachNgyenLieu(List<ChiTietNhap669> danhSachNgyenLieu) {
		this.danhSachNgyenLieu = danhSachNgyenLieu;
	}

	public HoaDonNhap669(int ma, String maHoaDon, Date ngay, double tong, NhanVien669 nhanVien, NhaCungCap669 nhaCungCap,
			List<ChiTietNhap669> danhSachNgyenLieu) {
		super();
		this.ma = ma;
		this.maHoaDon = maHoaDon;
		this.ngay = ngay;
		this.tong = tong;
		this.nhanVien = nhanVien;
		this.nhaCungCap = nhaCungCap;
		this.danhSachNgyenLieu = danhSachNgyenLieu;
	}

	public HoaDonNhap669(int ma) {
		super();
		this.ma = ma;
	}
	
}
