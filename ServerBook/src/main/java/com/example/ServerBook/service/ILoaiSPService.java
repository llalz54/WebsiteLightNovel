package com.example.ServerBook.service;

import java.util.List;

import com.example.ServerBook.dto.LoaiSPDTO;
import com.example.ServerBook.dto.TieuThuyetDTO;

public interface ILoaiSPService {
	public List<LoaiSPDTO> getAll();
	public LoaiSPDTO save(LoaiSPDTO dto);
	public void delete(Long loaiTT_ID);
	public LoaiSPDTO getOneByLoaiTTID(Long loaiTT_ID);
}
