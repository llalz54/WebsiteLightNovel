package com.example.ClientBook.service;

import java.util.List;

import com.example.ClientBook.model.PhieuNhapDTO;

public interface IPhieuNhapService {

	String save(PhieuNhapDTO dto);

	void delete(Long id);

	List<PhieuNhapDTO> getAllPN(Integer pageNumber, int pageSize);

}
