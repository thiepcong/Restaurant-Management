package model;

public class ChiTietMonAnCombo669 {
	private int ma;
	private int soLuong;
	private float giamGia;
	private float tong;
	private MonAn669 monAn;
	private Combo669 combo;
	public ChiTietMonAnCombo669() {
		// TODO Auto-generated constructor stub
	}
	
	public ChiTietMonAnCombo669(int ma, int soLuong, float giamGia, 
			float tong, MonAn669 monAn, Combo669 combo) {
		super();
		this.ma = ma;
		this.soLuong = soLuong;
		this.giamGia = giamGia;
		this.tong = tong;
		this.monAn = monAn;
		this.combo = combo;
	}
	
	public ChiTietMonAnCombo669(int ma, int soLuong, float giamGia, 
			float tong, MonAn669 monAn) {
		super();
		this.ma = ma;
		this.soLuong = soLuong;
		this.giamGia = giamGia;
		this.tong = tong;
		this.monAn = monAn;
	}
	
	public ChiTietMonAnCombo669(int ma, int soLuong, float giamGia, 
			float tong, Combo669 combo) {
		super();
		this.ma = ma;
		this.soLuong = soLuong;
		this.giamGia = giamGia;
		this.tong = tong;
		this.combo = combo;
	}

	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public float getGiamGia() {
		return giamGia;
	}
	public void setGiamGia(float giamGia) {
		this.giamGia = giamGia;
	}
	public float getTong() {
		return tong;
	}
	public void setTong(float tong) {
		this.tong = tong;
	}
	public MonAn669 getMonAn() {
		return monAn;
	}

	public void setMonAn(MonAn669 monAn) {
		this.monAn = monAn;
	}

	public Combo669 getCombo() {
		return combo;
	}

	public void setCombo(Combo669 combo) {
		this.combo = combo;
	}
	
}
