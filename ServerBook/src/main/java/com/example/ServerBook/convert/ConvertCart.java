package com.example.ServerBook.convert;

import org.springframework.stereotype.Component;

import com.example.ServerBook.dto.CartDTO;
import com.example.ServerBook.dto.DonHangDTO;
import com.example.ServerBook.entity.CartEntity;
import com.example.ServerBook.entity.DonHangEntity;
import com.example.ServerBook.entity.TieuThuyetEntity;

@Component
public class ConvertCart {
	public CartEntity toEntity(CartDTO dto) {
		CartEntity entity = new CartEntity();
			entity.setSoLuong(dto.getSoLuong());
		return entity;
	}
	public CartDTO toDTO(CartEntity entity) {
		CartDTO dto = new CartDTO();
		if(entity.getId() != null)
			dto.setId(entity.getId());
			dto.setSoLuong(entity.getSoLuong());
			dto.setMaKH(entity.getKhachHang().getId());
			dto.setMaSach(entity.getTieuThuyet().getId());
			dto.setTenSach(entity.getTieuThuyet().getTenSach());
			dto.setDonGia(entity.getTieuThuyet().getDonGia());
			dto.setGiamGia(entity.getTieuThuyet().getGiamGia());
			dto.setHinhAnh(entity.getTieuThuyet().getHinhAnh());
		
		return dto;
	}
	public CartEntity toEntity(CartDTO dto, CartEntity entity) {
			
			entity.setSoLuong(dto.getSoLuong());
			
		return entity;
	}
}
