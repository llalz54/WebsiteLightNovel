package com.example.ServerBook.service;

import java.util.List;

import com.example.ServerBook.dto.DonHangDTO;
import com.example.ServerBook.dto.TieuThuyetDTO;


public interface IDonHangService {
	public DonHangDTO save(DonHangDTO dto);

	public void delete(Long id);

	public List<DonHangDTO> getByUser(Long userid);
	List<DonHangDTO> getAll(int pageNumber, int pageSize);

	public DonHangDTO getByID(Long id);

	DonHangDTO search(Long iddh);

	DonHangDTO HuyDon(DonHangDTO dto);
	
}
