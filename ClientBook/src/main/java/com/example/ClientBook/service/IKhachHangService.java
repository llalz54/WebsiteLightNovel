package com.example.ClientBook.service;

import java.util.List;

import com.example.ClientBook.model.KhachHangDTO;

public interface IKhachHangService {

	List<KhachHangDTO> getAllKH();

	KhachHangDTO findByMaKH(Long maKH);

	List<KhachHangDTO> search(String keyword);

	public String save(KhachHangDTO khachhang);

	KhachHangDTO login(String email, String password);


}
