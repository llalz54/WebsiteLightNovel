package com.example.ServerBook.convert;

import org.springframework.stereotype.Component;

import com.example.ServerBook.dto.TieuThuyetDTO;
import com.example.ServerBook.entity.TieuThuyetEntity;

@Component
public class ConvertTieuThuyet {
	
	public TieuThuyetEntity toEntity(TieuThuyetDTO dto) {
		TieuThuyetEntity entity = new TieuThuyetEntity();
			entity.setTenSach(dto.getTenSach());
			entity.setTacGia(dto.getTacGia());
			entity.setSoLuong(dto.getSoLuong());
			entity.setMoTa(dto.getMoTa());
			entity.setDonGia(dto.getDonGia());
			entity.setNxb(dto.getNxb());
			entity.setGiamGia(dto.getGiamGia());
			entity.setHinhAnh(dto.getHinhAnh());
		return entity;
	}
	public TieuThuyetDTO toDTO(TieuThuyetEntity entity) {
		TieuThuyetDTO dto = new TieuThuyetDTO();
		if(entity.getId() != null)
			dto.setMaSach(entity.getId());
			dto.setTenSach(entity.getTenSach());
			dto.setTacGia(entity.getTacGia());
			dto.setSoLuong(entity.getSoLuong());
			dto.setMoTa(entity.getMoTa());
			dto.setDonGia(entity.getDonGia());
			dto.setNxb(entity.getNxb());
			dto.setHinhAnh(entity.getHinhAnh());
			dto.setGiamGia(entity.getGiamGia());
			dto.setLoaiTT_ID(entity.getLoaiTT().getLoaiTT_ID());
			dto.setTenLoaiTT(entity.getLoaiTT().getTenLoaiTT());
		return dto;
	}
	public TieuThuyetEntity toEntity(TieuThuyetDTO dto, TieuThuyetEntity entity) {
			entity.setTenSach(dto.getTenSach());
			entity.setTacGia(dto.getTacGia());
			entity.setSoLuong(dto.getSoLuong());
			entity.setMoTa(dto.getMoTa());
			entity.setDonGia(dto.getDonGia());
			entity.setNxb(dto.getNxb());
			entity.setGiamGia(dto.getGiamGia());
			entity.setHinhAnh(dto.getHinhAnh());
		return entity;
	}

}
