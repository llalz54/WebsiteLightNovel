package com.example.ServerBook.convert;

import org.springframework.stereotype.Component;

import com.example.ServerBook.dto.DonHangDTO;
import com.example.ServerBook.dto.KhachHangDTO;
import com.example.ServerBook.entity.DonHangEntity;
import com.example.ServerBook.entity.KhachHangEntity;

@Component
public class ConvertDonHang {
	public DonHangEntity toEntity(DonHangDTO dto) {
		DonHangEntity entity = new DonHangEntity();
			entity.setDiaChi(dto.getDiaChi());
			entity.setSdt(dto.getSdt());
			entity.setNgayLap(dto.getNgayLap());
			entity.setTrangthai(dto.getTrangthai());;
			entity.setGhiChu(dto.getGhiChu());
			entity.setTongGia(dto.getTongGia());

		return entity;
	}
	public DonHangDTO toDTO(DonHangEntity entity) {
		DonHangDTO dto = new DonHangDTO();
		if(entity.getId() != null) {
			dto.setIDDH(entity.getId());			
		}
			dto.setDiaChi(entity.getDiaChi());
			dto.setSdt(entity.getSdt());
			dto.setNgayLap(entity.getNgayLap());
			dto.setTrangthai(entity.getTrangthai());
			dto.setGhiChu(entity.getGhiChu());
			dto.setTongGia(entity.getTongGia());
			System.out.println(entity.getKhachHang().getId());
			dto.setMaKH(entity.getKhachHang().getId());
			dto.setTenKH(entity.getKhachHang().getName());
		return dto;
	}
	public DonHangEntity toEntity(DonHangDTO dto, DonHangEntity entity) {
			entity.setDiaChi(dto.getDiaChi());
			entity.setSdt(dto.getSdt());
			entity.setNgayLap(dto.getNgayLap());
			entity.setTrangthai(dto.getTrangthai());
			entity.setGhiChu(dto.getGhiChu());
			entity.setTongGia(dto.getTongGia());
		return entity;
	}

}
