package com.example.ServerBook.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ServerBook.convert.ConvertCTDH;
import com.example.ServerBook.dto.CTDHDTO;
import com.example.ServerBook.entity.CTDHEntity;
import com.example.ServerBook.entity.DonHangEntity;
import com.example.ServerBook.entity.KhachHangEntity;
import com.example.ServerBook.repository.CTDHRepon;
import com.example.ServerBook.repository.DonHangRepon;
import com.example.ServerBook.service.ICTDHService;

import lombok.experimental.PackagePrivate;

@Service
public class CTDHService implements ICTDHService {
	@Autowired
	private CTDHRepon ctdhRepon;
	@Autowired
	private ConvertCTDH convertCTDH;
	@Autowired
	private DonHangRepon donHangRepon;
	@Override
	public CTDHDTO save(CTDHDTO dto) {
		CTDHEntity entity = new CTDHEntity();
		entity = convertCTDH.toEntity(dto);
		
		entity = ctdhRepon.save(entity);
		
		return convertCTDH.toDTO(entity);
	}

	@Override
	public List<CTDHDTO> getByDonHang(Long order_id) {
		DonHangEntity dh = donHangRepon.findById(order_id).get();
		List<CTDHEntity> listctdh = ctdhRepon.findByDonHang(dh);
		return listctdh.stream().map(convertCTDH::toDTO).collect(Collectors.toList());
	}

}
