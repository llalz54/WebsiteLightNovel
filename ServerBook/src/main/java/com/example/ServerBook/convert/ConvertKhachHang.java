package com.example.ServerBook.convert;

import org.springframework.stereotype.Component;

import com.example.ServerBook.dto.KhachHangDTO;
import com.example.ServerBook.entity.KhachHangEntity;

@Component
public class ConvertKhachHang {

	public KhachHangEntity toEntity(KhachHangDTO dto) {
		KhachHangEntity entity = new KhachHangEntity();
			entity.setName(dto.getTenKH());;
			entity.setDiaChi(dto.getDiaChi());
			entity.setSdt(dto.getSdt());;
			entity.setEmail(dto.getEmail());
			entity.setPass(dto.getPass());
			
		return entity;
	}
	public KhachHangDTO toDTO(KhachHangEntity entity) {
		KhachHangDTO dto = new KhachHangDTO();
		if(entity.getId() != null)
			dto.setMaKH(entity.getId());
			dto.setTenKH(entity.getName());
			dto.setDiaChi(entity.getDiaChi());
			dto.setSdt(entity.getSdt());
			dto.setEmail(entity.getEmail());
			dto.setPass(entity.getPass());
		return dto;
	}
	public KhachHangEntity toEntity(KhachHangDTO dto, KhachHangEntity entity) {
			entity.setName(dto.getTenKH());;
			entity.setDiaChi(dto.getDiaChi());
			entity.setSdt(dto.getSdt());;
			entity.setEmail(dto.getEmail());
			entity.setPass(dto.getPass());
		return entity;
	}
}
