package com.example.ClientBook.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.example.ClientBook.model.LoaiSPDTO;
import com.example.ClientBook.model.TieuThuyetDTO;

public interface ITieuThuyetService {

	List<TieuThuyetDTO> getAll();

//	List<TieuThuyetDTO> findByLoaiTT(Long loaiTT_ID, Long page);
	
	Map<String, Object> findByLoaiTT(Long loaiTT_ID, Integer page);
	

	List<TieuThuyetDTO> search(String keyword);
	List<TieuThuyetDTO> getByTT(Long loaiTT_ID);
	List<LoaiSPDTO> getTT();
	public String save(LoaiSPDTO dto);

	public LoaiSPDTO getOneByLoaiTTID(Long loaiTT_ID);

	String save(TieuThuyetDTO tieuthuyet, MultipartFile imageLink);

	TieuThuyetDTO getByIDSP(Long maSach);
	List<Object[]> getTieuThuyetBanChay();
	List<Object[]> getThongKeTheoNgay();
	List<Object[]> getThongKeTheoThang();
	List<Object[]> getThongKeTheoNam();





	



}
