package com.example.ServerBook.service;

import java.util.List;

import com.example.ServerBook.dto.CTDHDTO;

public interface ICTDHService {

	CTDHDTO save(CTDHDTO dto);

	List<CTDHDTO> getByDonHang(Long order_id);

}
