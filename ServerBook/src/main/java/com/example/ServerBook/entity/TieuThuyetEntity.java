package com.example.ServerBook.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TieuThuyet")
public class TieuThuyetEntity {
	@Id
	@Column(name = "MaSach")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "TenSach",nullable = false)
	private String tenSach;

	@Column(name = "SoLuong",nullable = false)
	private int soLuong;

	@Column(name = "GiamGia")
	private int giamGia;

	@Lob
	@Column(name = "MoTa",nullable = false)
	private String moTa;

	@Column(name = "TacGia",nullable = false)
	private String tacGia;

	@Column(name = "DonGia",nullable = false)
	private int donGia;

	@Lob
	@Column(name = "HinhAnh")
	private String hinhAnh;

	@Column(name = "NXB",nullable = false)
	private String nxb;

	@ManyToOne
	@JoinColumn(name = "LoaiTT_ID",nullable = false)
	private LoaiSPEntity loaiTT;

	@OneToMany(mappedBy = "tieuThuyet")
	private List<CTDHEntity> ctdh = new ArrayList<>();

	@OneToMany(mappedBy = "tieuThuyet")
	private List<CartEntity> cartTT = new ArrayList<>();

	public String getNxb() {
		return nxb;
	}

	public void setNxb(String nxb) {
		this.nxb = nxb;
	}

	public List<CartEntity> getCartTT() {
		return cartTT;
	}

	public void setCartTT(List<CartEntity> cartTT) {
		this.cartTT = cartTT;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LoaiSPEntity getLoaiTT() {
		return loaiTT;
	}

	public void setLoaiTT(LoaiSPEntity loaiTT) {
		this.loaiTT = loaiTT;
	}

	public List<CTDHEntity> getCtdh() {
		return ctdh;
	}

	public void setCtdh(List<CTDHEntity> ctdh) {
		this.ctdh = ctdh;
	}

	public int getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(int giamGia) {
		this.giamGia = giamGia;
	}

	public double getGiaSauGiamGia() {
		return  (this.getDonGia() - (this.getDonGia() * this.getGiamGia()/100));
	}

}
