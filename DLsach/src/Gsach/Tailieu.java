package Gsach;

public abstract class Tailieu {
	private String MaS,tenS;
	public String getMaS() {
		return MaS;
	}
	public void setMaS(String maS) {
		MaS = maS;
	}
	public String getTenS() {
		return tenS;
	}
	public void setTenS(String tenS) {
		this.tenS = tenS;
	}

	/**
	 * @param maS
	 * @param tenS
	 */
	public Tailieu(String maS, String tenS) {
		super();
		MaS = maS;
		this.tenS = tenS;
	}
	public Tailieu() {
		super();
	}
	public double  ThanhTien() {
		return ThanhTien();
	}
}
