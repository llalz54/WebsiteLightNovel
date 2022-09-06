package com.example.ServerBook.service;

import java.util.List;

import com.example.ServerBook.dto.KhachHangDTO;
import com.example.ServerBook.dto.TieuThuyetDTO;

public interface IKhachHangService {
	public KhachHangDTO save(KhachHangDTO dto);
	public void delete(Long id);
	List<KhachHangDTO> getAll(int pageNumber, int pageSize);
	List<KhachHangDTO> search(String kh);
	public KhachHangDTO getOneByMaKH(Long id);
	public KhachHangDTO login(String email, String password);

}
