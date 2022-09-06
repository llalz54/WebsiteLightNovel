package com.example.ServerBook.convert;

import org.springframework.stereotype.Component;

import com.example.ServerBook.dto.NhanVienDTO;
import com.example.ServerBook.dto.TieuThuyetDTO;
import com.example.ServerBook.entity.NhanVienEntity;
import com.example.ServerBook.entity.TieuThuyetEntity;

@Component
public class ConvertNhanVien {
	public NhanVienEntity toEntity(NhanVienDTO dto) {
		NhanVienEntity entity = new NhanVienEntity();
			entity.setName(dto.getTenNV());
			entity.setDiaChi(dto.getDiaChi());
			entity.setSdt(dto.getSdt());
			entity.setEmail(dto.getEmail());
			entity.setPass(dto.getPass());
		return entity;
	}
	public NhanVienDTO toDTO(NhanVienEntity entity) {
		NhanVienDTO dto = new NhanVienDTO();
		if(entity.getId() != null)
			dto.setMaNV(entity.getId());
			dto.setTenNV(entity.getName());
			dto.setDiaChi(entity.getDiaChi());
			dto.setSdt(entity.getSdt());
			dto.setEmail(entity.getEmail());
			dto.setRole_id(entity.getRole().getId());
			dto.setPass(entity.getPass());
		return dto;
	}
	public NhanVienEntity toEntity(NhanVienDTO dto, NhanVienEntity entity) {
			entity.setName(dto.getTenNV());
			entity.setDiaChi(dto.getDiaChi());
			entity.setSdt(dto.getSdt());
			entity.setEmail(dto.getEmail());
			entity.setPass(dto.getPass());
		return entity;
	}

}
