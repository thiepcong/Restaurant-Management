package model;

public class NhaCungCap669 {
	private int ma;
	private String ten;
	private String diaChi;
	private String email;
	private String dienThoai;
	private String moTa;
	public NhaCungCap669(int ma, String ten, String diaChi, String email, String dienThoai, String moTa) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.diaChi = diaChi;
		this.email = email;
		this.dienThoai = dienThoai;
		this.moTa = moTa;
	}
	
	public NhaCungCap669(int ma) {
		super();
		this.ma = ma;
	}
	public NhaCungCap669() {
		super();
	}
	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
	
}
