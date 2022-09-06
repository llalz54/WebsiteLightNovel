package com.example.ClientBook.service;

import java.util.List;

import com.example.ClientBook.model.CTPNDTO;

public interface ICTPNService {

	String save(CTPNDTO dto);

	List<CTPNDTO> getByPhieuNhap(Long received_id);

}
