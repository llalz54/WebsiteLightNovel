package com.example.ServerBook.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "PhieuNhap")
public class PhieuNhapEntity {
	@Id
	@Column(name ="IDPN")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name ="MaNV",nullable = false)
	private NhanVienEntity nhanVien;
	
	@Column(name ="NgayLap",nullable = false)
	@CreatedDate
	private Date ngayLap;
	
	@OneToMany(mappedBy = "phieuNhap")
	@JsonManagedReference
	private List<CTPNEntity> ctpn = new ArrayList<>();


	public Date getNgayLap() {
		return ngayLap;
	}


	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}




	public NhanVienEntity getNhanVien() {
		return nhanVien;
	}


	public void setNhanVien(NhanVienEntity nhanVien) {
		this.nhanVien = nhanVien;
	}


	public List<CTPNEntity> getCtpn() {
		return ctpn;
	}


	public void setCtpn(List<CTPNEntity> ctpn) {
		this.ctpn = ctpn;
	}
	
	
}
