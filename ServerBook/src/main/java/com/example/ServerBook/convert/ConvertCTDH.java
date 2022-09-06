package com.example.ServerBook.convert;

import org.springframework.stereotype.Component;

import com.example.ServerBook.dto.CTDHDTO;
import com.example.ServerBook.dto.DonHangDTO;
import com.example.ServerBook.entity.CTDHEntity;
import com.example.ServerBook.entity.DonHangEntity;

@Component
public class ConvertCTDH {
	public CTDHEntity toEntity(CTDHDTO dto) {
		CTDHEntity entity = new CTDHEntity();
			entity.setDonGia(dto.getDonGia());
			entity.setSoLuong(dto.getSoLuong());
		return entity;
	}
	public CTDHDTO toDTO(CTDHEntity entity) {
		CTDHDTO dto = new CTDHDTO();
		if(entity.getId() != null)
			dto.setIDCTDH(entity.getId());
			dto.setDonGia(entity.getDonGia());
			dto.setSoLuong(entity.getSoLuong());
			dto.setTenSach(entity.getTieuThuyet().getTenSach());
			dto.setIDDH(entity.getDonHang().getId());
			dto.setMaSach(entity.getTieuThuyet().getId());
		return dto;
	}
	public CTDHEntity toEntity(CTDHDTO dto, CTDHEntity entity) {
			
			entity.setDonGia(dto.getDonGia());
			entity.setSoLuong(dto.getSoLuong());
		return entity;
	}

}
