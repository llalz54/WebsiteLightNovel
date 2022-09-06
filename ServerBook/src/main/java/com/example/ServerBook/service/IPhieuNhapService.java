package com.example.ServerBook.service;

import java.util.List;

import com.example.ServerBook.dto.PhieuNhapDTO;

public interface IPhieuNhapService {

	PhieuNhapDTO save(PhieuNhapDTO dto);

	void delete(Long id);

	List<PhieuNhapDTO> getAllPN(Integer pageNumber, int pageSize);

}
