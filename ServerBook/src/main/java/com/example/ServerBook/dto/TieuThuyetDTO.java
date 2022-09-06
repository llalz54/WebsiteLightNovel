package com.example.ServerBook.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.ServerBook.entity.LoaiSPEntity;

public class TieuThuyetDTO {
	
	private Long maSach;
	
	private String tenSach;
	
	private int soLuong;

	private String moTa;
	
	private String tacGia;
	
	private int donGia;
	
	private String hinhAnh;

	private Long loaiTT_ID;
	
	private String tenLoaiTT;
	
	private String nxb;
	
	private int giamGia;
	
	

	public int getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(int giamGia) {
		this.giamGia = giamGia;
	}

	public String getNxb() {
		return nxb;
	}

	public void setNxb(String nxb) {
		this.nxb = nxb;
	}

	public Long getMaSach() {
		return maSach;
	}

	public void setMaSach(Long maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public Long getLoaiTT_ID() {
		return loaiTT_ID;
	}

	public void setLoaiTT_ID(Long loaiTT_ID) {
		this.loaiTT_ID = loaiTT_ID;
	}

	public String getTenLoaiTT() {
		return tenLoaiTT;
	}

	public void setTenLoaiTT(String tenLoaiTT) {
		this.tenLoaiTT = tenLoaiTT;
	}

	
	
	
}
