package com.example.ClientBook.service;

import java.util.List;

import com.example.ClientBook.model.DonHangDTO;
import com.example.ClientBook.model.TieuThuyetDTO;



public interface IDonHangService {
	public String save(DonHangDTO dto);

	public void delete(Long IDDH);

	public List<DonHangDTO> getByUser(Long maKH);
	List<DonHangDTO> getAll();

	DonHangDTO getByIDDH(Long iddh);

	DonHangDTO search(Long IDDH);

	public String HuyDon(DonHangDTO dto);
}