package model;

import java.util.Date;
import java.util.List;

public class HoaDonThanhToan669 {
	private int ma;
	private Date ngayThanhToan;
	private int soLuong;
	private String loaiThanhToan;
	private String ghiChu;
	private NhanVien669 nhanVien;
	private List<ChiTietMonAnCombo669> dsDatMon;
	private KhachHang669 khachHang;
	public HoaDonThanhToan669() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public HoaDonThanhToan669(int ma, Date ngayThanhToan, int soLuong, String loaiThanhToan, String ghiChu,
			NhanVien669 nhanVien, List<ChiTietMonAnCombo669> dsDatMon, KhachHang669 khachHang) {
		super();
		this.ma = ma;
		this.ngayThanhToan = ngayThanhToan;
		this.soLuong = soLuong;
		this.loaiThanhToan = loaiThanhToan;
		this.ghiChu = ghiChu;
		this.nhanVien = nhanVien;
		this.dsDatMon = dsDatMon;
		this.khachHang = khachHang;
	}



	public KhachHang669 getKhachHang() {
		return khachHang;
	}



	public void setKhachHang(KhachHang669 khachHang) {
		this.khachHang = khachHang;
	}



	public void setDsDatMon(List<ChiTietMonAnCombo669> dsDatMon) {
		this.dsDatMon = dsDatMon;
	}

	public List<ChiTietMonAnCombo669> getDsDatMon() {
		return dsDatMon;
	}

	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	public Date getNgayThanhToan() {
		return ngayThanhToan;
	}
	public void setNgayThanhToan(Date ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getLoaiThanhToan() {
		return loaiThanhToan;
	}
	public void setLoaiThanhToan(String loaiThanhToan) {
		this.loaiThanhToan = loaiThanhToan;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public NhanVien669 getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien669 nhanVien) {
		this.nhanVien = nhanVien;
	}
	
}
