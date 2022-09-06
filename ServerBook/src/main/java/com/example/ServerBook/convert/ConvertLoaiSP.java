package com.example.ServerBook.convert;

import org.springframework.stereotype.Component;

import com.example.ServerBook.dto.LoaiSPDTO;
import com.example.ServerBook.dto.TieuThuyetDTO;
import com.example.ServerBook.entity.LoaiSPEntity;
import com.example.ServerBook.entity.TieuThuyetEntity;

@Component
public class ConvertLoaiSP {

	public LoaiSPEntity toEntity(LoaiSPDTO dto) {
		LoaiSPEntity entity = new LoaiSPEntity();
			entity.setTenLoaiTT(dto.getTenLoaiTT());
		return entity;
	}
	public LoaiSPDTO toDTO(LoaiSPEntity entity) {
		LoaiSPDTO dto = new LoaiSPDTO();
		if(entity.getLoaiTT_ID() != null)
			dto.setLoaiTT_ID(entity.getLoaiTT_ID());;
			dto.setTenLoaiTT(entity.getTenLoaiTT());;
			
		return dto;
	}
	public LoaiSPEntity toEntity(LoaiSPDTO dto, LoaiSPEntity entity) {
			entity.setTenLoaiTT(dto.getTenLoaiTT());
			
		return entity;
	}

}
