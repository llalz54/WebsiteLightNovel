package com.example.ServerBook.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.ServerBook.entity.TieuThuyetEntity;

public class CTDHDTO {
	private Long IDCTDH;
	private Long IDDH;
	private Long maSach;
	private int soLuong;
	private int donGia;
	private String tenSach;
	
	
	

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
