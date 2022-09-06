package com.example.ServerBook.entity;

import java.util.ArrayList;
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


@Entity
@Table(name = "LoaiTT")
public class LoaiSPEntity {
	@Id
	@Column(name ="LoaiTT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loaiTT_ID;
	
	@Column(name ="TenLoaiTT",nullable = false)
	private String tenLoaiTT;
	
	@OneToMany(mappedBy = "loaiTT")
	private List<TieuThuyetEntity> TT = new ArrayList<>();

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

	public List<TieuThuyetEntity> getTT() {
		return TT;
	}

	public void setTT(List<TieuThuyetEntity> tT) {
		TT = tT;
	}

	
	
	
}
