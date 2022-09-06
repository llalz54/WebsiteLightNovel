package com.example.ServerBook.service;

import java.util.List;

import com.example.ServerBook.dto.KhachHangDTO;
import com.example.ServerBook.dto.NhanVienDTO;

public interface INhanVienService {
	public NhanVienDTO save(NhanVienDTO dto);

	public void delete(Long id);
	List<NhanVienDTO> getAll(int pageNumber, int pageSize);
	List<NhanVienDTO> search(String nv);
	public NhanVienDTO getOneByMaNV(Long id);

	NhanVienDTO login(String username, String password);

}
