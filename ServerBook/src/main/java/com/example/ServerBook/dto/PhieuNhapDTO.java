package com.example.ServerBook.dto;

import java.util.Date;

public class PhieuNhapDTO {
	private Long IDPN;
	private Date ngayLap;
	private Long maNV;
	public Long getIDPN() {
		return IDPN;
	}
	public void setIDPN(Long iDPN) {
		IDPN = iDPN;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	public Long getMaNV() {
		return maNV;
	}
	public void setMaNV(Long maNV) {
		this.maNV = maNV;
	}

	
	

}
