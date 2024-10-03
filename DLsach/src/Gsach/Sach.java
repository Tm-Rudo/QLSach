package Gsach;

public class Sach extends Tailieu{
	private int NamXB;
	private double GiaB;
	/**
	 * @param maS
	 * @param tenS
	 */
	public Sach(String maS, String tenS) {
		super(maS, tenS);
	}
	/**
	 * @param maS
	 * @param tenS
	 * @param namXB
	 * @param giaB
	 */
	public Sach(String maS, String tenS, int namXB, double giaB) {
		super(maS, tenS);
		NamXB = namXB;
		GiaB = giaB;
	}
	public Sach() {
		// TODO Auto-generated constructor stub
	}
	public int getNamXB() {
		return NamXB;
	}
	public void setNamXB(int namXB) {
		NamXB = namXB;
	}
	public double getGiaB() {
		return GiaB;
	}
	public void setGiaB(double giaB) {
		GiaB = giaB;
	}
	public double ThanhTien() {
		if(NamXB<2015)
			return GiaB*85/100;
		else
			return GiaB*95/100;
	}
	
}
