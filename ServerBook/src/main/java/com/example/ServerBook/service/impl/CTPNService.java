package com.example.ServerBook.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ServerBook.convert.ConvertCTPN;
import com.example.ServerBook.dto.CTDHDTO;
import com.example.ServerBook.dto.CTPNDTO;
import com.example.ServerBook.entity.CTDHEntity;
import com.example.ServerBook.entity.CTPNEntity;
import com.example.ServerBook.entity.DonHangEntity;
import com.example.ServerBook.entity.PhieuNhapEntity;
import com.example.ServerBook.repository.CTPNRepon;
import com.example.ServerBook.repository.PhieuNhapRepon;
import com.example.ServerBook.service.ICTPNService;

@Service
public class CTPNService implements ICTPNService {
	@Autowired
	private CTPNRepon ctpnRepon;
	@Autowired 
	private ConvertCTPN convertCTPN;
	@Autowired
	private PhieuNhapRepon phieuNhapRepon;

	@Override
	public CTPNDTO save(CTPNDTO dto) {
		CTPNEntity entity = new CTPNEntity();
		if(dto.getIDCTPN() != null) {
			CTPNEntity oldEntity = ctpnRepon.findById(dto.getIDCTPN()).get();
			entity = convertCTPN.toEntity(dto, oldEntity);
		}
		else {
			entity = convertCTPN.toEntity(dto);
		}
		entity = ctpnRepon.save(entity);
		
		return convertCTPN.toDTO(entity);
	}

	@Override
	public List<CTPNDTO> getByPhieuNhap(Long received_id) {
		PhieuNhapEntity pn = phieuNhapRepon.findById(received_id).get();
		List<CTPNEntity> listctpn = ctpnRepon.findByPhieuNhap(pn);
		return listctpn.stream().map(convertCTPN::toDTO).collect(Collectors.toList());
	}

}
