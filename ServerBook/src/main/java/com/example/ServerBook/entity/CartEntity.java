package com.example.ServerBook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "GioHang")
public class CartEntity {
	@Id
	@Column(name ="IDGH")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "MaSach",nullable = false)
	private TieuThuyetEntity tieuThuyet;

	@ManyToOne
	@JoinColumn(name ="MaKH",nullable = false)
	private KhachHangEntity khachHang;

	@Column(name ="SoLuong",nullable = false)
	private int soLuong;
	
	



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public TieuThuyetEntity getTieuThuyet() {
		return tieuThuyet;
	}


	public void setTieuThuyet(TieuThuyetEntity tieuThuyet) {
		this.tieuThuyet = tieuThuyet;
	}


	public KhachHangEntity getKhachHang() {
		return khachHang;
	}


	public void setKhachHang(KhachHangEntity khachHang) {
		this.khachHang = khachHang;
	}


	public int getSoLuong() {
		return soLuong;
	}


	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}






	

	

}
