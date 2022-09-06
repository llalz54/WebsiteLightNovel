package com.example.ServerBook.service;

import java.util.List;

import com.example.ServerBook.dto.CTPNDTO;

public interface ICTPNService {

	CTPNDTO save(CTPNDTO dto);

	List<CTPNDTO> getByPhieuNhap(Long received_id);

}
