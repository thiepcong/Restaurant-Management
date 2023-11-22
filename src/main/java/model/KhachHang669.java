package model;

public class KhachHang669 extends NguoiDung669{
	private String maKhachHang;
	private String ten;
	private String soDienThoai;
	private String email;
	private String diaChi;
	private String ghiChu;
	public KhachHang669() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public KhachHang669(String maKhachHang, String ten, String soDienThoai, String email, String diaChi,
			String ghiChu) {
		super();
		this.maKhachHang = maKhachHang;
		this.ten = ten;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.diaChi = diaChi;
		this.ghiChu = ghiChu;
	}



	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
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
		return this.ten+" "+this.soDienThoai+" "+this.getTenNguoiDung();
	}
	
//	public static void main(String[] args) {
//		KhachHang669 a =new KhachHang669();
//	}
}
