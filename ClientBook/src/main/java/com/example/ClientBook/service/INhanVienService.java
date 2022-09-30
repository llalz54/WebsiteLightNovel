package com.example.ClientBook.service;

import java.util.List;

import com.example.ClientBook.model.NhanVienDTO;

public interface INhanVienService {
	public NhanVienDTO save(NhanVienDTO dto);

	public void delete(Long id);
	List<NhanVienDTO> getAll();
	List<NhanVienDTO> search(String nv);
	public NhanVienDTO getOneByMaNV(Long id);

	NhanVienDTO login(String username, String password);

}
