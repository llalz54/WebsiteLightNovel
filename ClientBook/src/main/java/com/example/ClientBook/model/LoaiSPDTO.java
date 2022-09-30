package com.example.ClientBook.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class LoaiSPDTO {

	private Long loaiTT_ID;
	

	private String tenLoaiTT;

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
