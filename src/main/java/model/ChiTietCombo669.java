package model;

public class ChiTietCombo669 {
	private int ma;
	private MonAn669 monAn;
	private Combo669 combo;
	private int soLuong;
	public ChiTietCombo669() {
		// TODO Auto-generated constructor stub
	}
	public ChiTietCombo669(int ma, MonAn669 monAn, Combo669 combo, int soLuong) {
		super();
		this.ma = ma;
		this.monAn = monAn;
		this.combo = combo;
		this.soLuong = soLuong;
	}
	public ChiTietCombo669(Combo669 combo) {
		super();
		this.combo = combo;
	}
	public ChiTietCombo669(MonAn669 monAn) {
		super();
		this.monAn = monAn;
	}
	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
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
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	
//	public static void main(String[] args) {
//		ChiTietCombo669 combo = new ChiTietCombo669(1, new Combo669());
//		ChiTietCombo669 combo1 = new ChiTietCombo669(2, new MonAn669());
//		System.out.println(combo.getCombo());
//		System.out.println(combo1.getMonAn());
//		System.out.println(combo1.getCombo());
//		System.out.println(combo.getMonAn());
//	}
}
