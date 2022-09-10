package com.example.ServerBook.convert;

import org.springframework.stereotype.Component;

import com.example.ServerBook.dto.PhieuNhapDTO;
import com.example.ServerBook.entity.PhieuNhapEntity;
@Component
public class ConvertPhieuNhap {
	public PhieuNhapEntity toEntity(PhieuNhapDTO dto) {
		PhieuNhapEntity entity = new PhieuNhapEntity();
			entity.setNgayLap(dto.getNgayLap());
			
		return entity;
	}
	public PhieuNhapDTO toDTO(PhieuNhapEntity entity) {
		PhieuNhapDTO dto = new PhieuNhapDTO();
		if(entity.getId() != null)
			dto.setIDPN(entity.getId());
			dto.setNgayLap(entity.getNgayLap());
			dto.setMaNV(entity.getKhachHangEntity().getId());
		return dto;
	}
	public PhieuNhapEntity toEntity(PhieuNhapDTO dto, PhieuNhapEntity entity) {
			entity.setNgayLap(dto.getNgayLap());
			
		return entity;

	}
	}
