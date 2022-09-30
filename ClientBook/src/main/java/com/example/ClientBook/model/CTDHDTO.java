package com.example.ClientBook.model;

public class CTDHDTO {
	private Long IDCTDH;
	private Long IDDH;
	private Long maSach;
	private int soLuong;
	private int donGia;
	private String tenSach;
	private int giamGia;
	
	
	
	

	public int getGiamGia() {
		return giamGia;
	}
	public void setGiamGia(int giamGia) {
		this.giamGia = giamGia;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public Long getIDDH() {
		return IDDH;
	}
	public void setIDDH(Long iDDH) {
		IDDH = iDDH;
	}
	
	public Long getMaSach() {
		return maSach;
	}
	public void setMaSach(Long maSach) {
		this.maSach = maSach;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	public Long getIDCTDH() {
		return IDCTDH;
	}
	public void setIDCTDH(Long iDCTDH) {
		IDCTDH = iDCTDH;
	}
	

}
