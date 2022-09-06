package com.example.ServerBook.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.ServerBook.dto.TieuThuyetDTO;


import java.util.List;


public interface ITieuThuyetService {
	public TieuThuyetDTO save(TieuThuyetDTO dto);
	/* public TieuThuyetDTO update(TieuThuyetDTO dto); */
	public void delete(Long id);
	Page<TieuThuyetDTO> getByLoaiTT(Long loaiTT_ID, int pageNumber, int pageSize);
	
	List<TieuThuyetDTO> getAll(int pageNumber, int pageSize);
	List<TieuThuyetDTO> search(String keyword);
	public TieuThuyetDTO getOneByID(Long id);
	List<Object[]> getTieuThuyetBanChay();
	List<Object[]> getThongKeTheoNgay();
	List<Object[]> getThongKeTheoThang();
	List<Object[]> getThongKeTheoNam();
	List<TieuThuyetDTO> getByTT(Long loaiTT_ID);
	
	

}
