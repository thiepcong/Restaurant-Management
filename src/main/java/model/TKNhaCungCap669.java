package model;

public class TKNhaCungCap669 extends NhaCungCap669{
	private int lanNhap;
	private double tongTien;
	
	public TKNhaCungCap669() {
		// TODO Auto-generated constructor stub
	}

	public TKNhaCungCap669(int ma, String ten, String diaChi, String email, String dienThoai, String moTa, int lanNhap,
			double tongTien) {
		super(ma, ten, diaChi, email, dienThoai, moTa);
		this.lanNhap = lanNhap;
		this.tongTien = tongTien;
	}

	public int getLanNhap() {
		return lanNhap;
	}

	public void setLanNhap(int lanNhap) {
		this.lanNhap = lanNhap;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	
	
}
