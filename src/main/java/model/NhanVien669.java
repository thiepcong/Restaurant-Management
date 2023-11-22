package model;

public class NhanVien669 extends NguoiDung669{
	private String maNhanVien;
	private String ten;
	private String diaChi;
	private String viTri;
	private String ghiChu;
	
	public NhanVien669() {
		// TODO Auto-generated constructor stub
	}
	
	public NhanVien669(String maNhanVien, String ten, String diaChi, String viTri, String ghiChu) {
		super();
		this.maNhanVien = maNhanVien;
		this.ten = ten;
		this.diaChi = diaChi;
		this.viTri = viTri;
		this.ghiChu = ghiChu;
	}
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getViTri() {
		return viTri;
	}
	public void setViTri(String viTri) {
		this.viTri = viTri;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.ten+" "+this.diaChi+" "+this.viTri;
	}
}
