package com.example.ServerBook.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "DonHang")
public class DonHangEntity {

	@Id
	@Column(name ="IDDH")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name ="NgayLap",nullable = false)
	@CreatedDate
	private Date ngayLap;
	
	
	
	@Column(name ="TrangThai",nullable = false)
	private int trangthai;
	
	@ManyToOne
	@JoinColumn(name ="MaKH",nullable = false)
	private KhachHangEntity khachHang;
	
	@Column(name ="SDT",length = 11,nullable = false)
	private String sdt;

	@Column(name = "DiaChi",nullable = false)
	private String diaChi;
	
	@Column(name="GhiChu")
	private String ghiChu;
	
	@Column(name="TongGia",nullable = false)
	private double tongGia;
	
	public double getTongGia() {
		return tongGia;
	}

	public void setTongGia(double tongGia) {
		this.tongGia = tongGia;
	}


	@OneToMany(mappedBy = "donHang")
	@JsonManagedReference
	private List<CTDHEntity> ctdh = new ArrayList<>();
	

	public List<CTDHEntity> getCtdh() {
		return ctdh;
	}

	public void setCtdh(List<CTDHEntity> ctdh) {
		this.ctdh = ctdh;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	
	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public KhachHangEntity getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHangEntity khachHang) {
		this.khachHang = khachHang;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		return "DonHangEntity [id=" + id + ", ngayLap=" + ngayLap + ", trangthai=" + trangthai + ", khachHang="
				+ khachHang + ", sdt=" + sdt + ", diaChi=" + diaChi + ", ghiChu=" + ghiChu + ", tongGia=" + tongGia
				+ "]";
	}

	
	
}
