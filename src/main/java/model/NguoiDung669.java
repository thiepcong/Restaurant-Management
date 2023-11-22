package model;

public class NguoiDung669 {
	private int ma;
	private String tenNguoiDung;
	private String matKhau;
	private String ghiChu;
	
	public NguoiDung669() {
		// TODO Auto-generated constructor stub
	}
	
	

	public NguoiDung669(int ma, String tenNguoiDung, String matKhau, String ghiChu) {
		super();
		this.ma = ma;
		this.tenNguoiDung = tenNguoiDung;
		this.matKhau = matKhau;
		this.ghiChu = ghiChu;
	}
	
	public NguoiDung669( String tenNguoiDung, String matKhau) {
		super();
		this.tenNguoiDung = tenNguoiDung;
		this.matKhau = matKhau;
	}



	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public String getTenNguoiDung() {
		return tenNguoiDung;
	}

	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
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
		return this.tenNguoiDung+" "+this.matKhau;
	}
}
