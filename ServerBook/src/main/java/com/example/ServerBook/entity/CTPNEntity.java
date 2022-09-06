package com.example.ServerBook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "CTPN")
public class CTPNEntity {
	@Id
	@Column(name = "IDCTPN")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "IDPN",nullable = false)
	private  PhieuNhapEntity phieuNhap;
	
	@ManyToOne
	@JoinColumn(name = "MaSach",nullable = false)
	private TieuThuyetEntity tieuThuyet;

	
	@Column(name = "SoLuong",nullable = false)
	private int soLuong;

	
	@Column(name = "DonGia",nullable = false)
	private int donGia;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public PhieuNhapEntity getPhieuNhap() {
		return phieuNhap;
	}


	public void setPhieuNhap(PhieuNhapEntity phieuNhap) {
		this.phieuNhap = phieuNhap;
	}


	public TieuThuyetEntity getTieuThuyet() {
		return tieuThuyet;
	}


	public void setTieuThuyet(TieuThuyetEntity tieuThuyet) {
		this.tieuThuyet = tieuThuyet;
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
