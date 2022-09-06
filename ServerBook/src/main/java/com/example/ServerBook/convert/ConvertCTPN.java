package com.example.ServerBook.convert;

import org.springframework.stereotype.Component;

import com.example.ServerBook.dto.CTDHDTO;
import com.example.ServerBook.dto.CTPNDTO;
import com.example.ServerBook.entity.CTDHEntity;
import com.example.ServerBook.entity.CTPNEntity;

@Component
public class ConvertCTPN {

	public CTPNEntity toEntity(CTPNDTO dto) {
		CTPNEntity entity = new CTPNEntity();
			entity.setSoLuong(dto.getSoLuong());
			entity.setDonGia(dto.getDonGia());
		return entity;
	}
	public CTPNDTO toDTO(CTPNEntity entity) {
		CTPNDTO dto = new CTPNDTO();
		if(entity.getId() != null)
			dto.setIDCTPN(entity.getId());
			dto.setDonGia(entity.getDonGia());
			dto.setSoLuong(entity.getSoLuong());
			dto.setIDPN(entity.getPhieuNhap().getId());
			dto.setMaSach(entity.getTieuThuyet().getId());
		return dto;
	}
	public CTPNEntity toEntity(CTPNDTO dto, CTPNEntity entity) {
			entity.setDonGia(dto.getDonGia());
			entity.setSoLuong(dto.getSoLuong());
		return entity;
	}
}
