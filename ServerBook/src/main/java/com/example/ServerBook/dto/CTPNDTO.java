package com.example.ServerBook.dto;

public class CTPNDTO {
	private Long IDCTPN;
	private Long IDPN;
	private Long maSach;
	private int soLuong;
	private int donGia;
	public Long getIDCTPN() {
		return IDCTPN;
	}
	public void setIDCTPN(Long iDCTPN) {
		IDCTPN = iDCTPN;
	}
	public Long getIDPN() {
		return IDPN;
	}
	public void setIDPN(Long iDPN) {
		IDPN = iDPN;
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

}
