package com.example.ClientBook.service;

import java.util.List;

import com.example.ClientBook.model.CTDHDTO;



public interface ICTDHService {


	String save(CTDHDTO dto);

	List<CTDHDTO> getByDonHang(Long IDDH);
}
