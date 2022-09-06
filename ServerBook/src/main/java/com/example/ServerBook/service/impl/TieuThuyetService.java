package com.example.ServerBook.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.ServerBook.convert.ConvertTieuThuyet;
import com.example.ServerBook.dto.LoaiSPDTO;
import com.example.ServerBook.dto.TieuThuyetDTO;
import com.example.ServerBook.entity.LoaiSPEntity;
import com.example.ServerBook.entity.TieuThuyetEntity;
import com.example.ServerBook.repository.LoaiSPRepon;
import com.example.ServerBook.repository.TieuThuyetRepon;
import com.example.ServerBook.service.ITieuThuyetService;

@Service
public class TieuThuyetService implements ITieuThuyetService {
	@Autowired
	private TieuThuyetRepon tieuThuyetRepon;
	@Autowired
	private LoaiSPRepon loaiSPRepon;
	@Autowired
	private ConvertTieuThuyet convertTieuThuyet;
	private final int PAGE_OFFSET = 1;

	@Override
	public TieuThuyetDTO save(TieuThuyetDTO dto) {
		TieuThuyetEntity tieuThuyet = new TieuThuyetEntity();
		if (tieuThuyet.getGiamGia() > 100) {
			tieuThuyet.setGiamGia(100);
		} else if (tieuThuyet.getGiamGia() < 0) {
			tieuThuyet.setGiamGia(0);

		}
		if (dto.getMaSach() != null) {
			TieuThuyetEntity oldEntity = tieuThuyetRepon.findById(dto.getMaSach()).get();
			tieuThuyet = convertTieuThuyet.toEntity(dto, oldEntity);
		} else {
			tieuThuyet = convertTieuThuyet.toEntity(dto);
		}
		LoaiSPEntity loaiSP = loaiSPRepon.findById(dto.getLoaiTT_ID()).get();
		tieuThuyet.setLoaiTT(loaiSP);
		if (tieuThuyet.getGiamGia() > 100) {
			tieuThuyet.setGiamGia(100);
			tieuThuyet = tieuThuyetRepon.save(tieuThuyet);
		} else if (tieuThuyet.getGiamGia() < 0) {
			tieuThuyet.setGiamGia(0);
			tieuThuyet = tieuThuyetRepon.save(tieuThuyet);

		}
		tieuThuyet = tieuThuyetRepon.save(tieuThuyet);

		return convertTieuThuyet.toDTO(tieuThuyet);
	}

	@Override
	public void delete(Long id) {
		TieuThuyetEntity entity = tieuThuyetRepon.findById(id).get();
		tieuThuyetRepon.delete(entity);

	}

	@Override
	public Page<TieuThuyetDTO> getByLoaiTT(Long loaiTT_ID, int pageNumber, int pageSize) {
		LoaiSPEntity loaiSPEntity = loaiSPRepon.findById(loaiTT_ID)
				.orElseThrow(() -> new IllegalStateException("Not found Category"));
		Pageable pageable = PageRequest.of(pageNumber - PAGE_OFFSET, pageSize);
		Page<TieuThuyetEntity> tieuThuyet = tieuThuyetRepon.findByLoaiTT(loaiSPEntity, pageable);
		return new PageImpl<TieuThuyetDTO>(
				tieuThuyet.stream().map(convertTieuThuyet::toDTO).collect(Collectors.toList()), pageable, tieuThuyet.getTotalElements());
	}

	@Override
	public List<TieuThuyetDTO> getAll(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber - PAGE_OFFSET, pageSize);
		Page<TieuThuyetEntity> entity = tieuThuyetRepon.findAll(pageable);
		List<TieuThuyetDTO> listDTO = new ArrayList<>();
		for (TieuThuyetEntity itemEntity : entity) {
			TieuThuyetDTO dto = convertTieuThuyet.toDTO(itemEntity);
			listDTO.add(dto);
		}

		return listDTO;
	}

	@Override
	public List<TieuThuyetDTO> search(String keyword) {
		List<TieuThuyetEntity> list = tieuThuyetRepon.search(keyword);
		List<TieuThuyetDTO> listDTO = new ArrayList<>();
		for (TieuThuyetEntity entity : list) {
			TieuThuyetDTO dto = convertTieuThuyet.toDTO(entity);
			listDTO.add(dto);
		}

		return listDTO;
	}
	
	  @Override 
	  public List<TieuThuyetDTO> getByTT(Long loaiTT_ID ) {
	LoaiSPEntity loaiSPEntity = loaiSPRepon.findById(loaiTT_ID).get();
	  List<TieuThuyetDTO> listDTO = new ArrayList<TieuThuyetDTO>();
	  List<TieuThuyetEntity> listenEntities =
	  tieuThuyetRepon.findByLoaiTT(loaiSPEntity); 
	  for(TieuThuyetEntity entity :listenEntities)
	  { 
		  TieuThuyetDTO dto = convertTieuThuyet.toDTO(entity);
		  listDTO.add(dto); 
	  } return listDTO; }
	 

	@Override
	public TieuThuyetDTO getOneByID(Long id) {
		TieuThuyetEntity entity = tieuThuyetRepon.findById(id).get();
		TieuThuyetDTO dto = convertTieuThuyet.toDTO(entity);
		return dto;
	}

	@Override
	public List<Object[]> getTieuThuyetBanChay() {
		List<Object[]> list = tieuThuyetRepon.getTieuThuyetBanChay();

		return list;
	}

	@Override
	public List<Object[]> getThongKeTheoNgay() {
		List<Object[]> list = tieuThuyetRepon.getThongKeTheoNgay();

		return list;
	}

	@Override
	public List<Object[]> getThongKeTheoThang() {
		List<Object[]> list = tieuThuyetRepon.getThongKeTheoThang();

		return list;
	}

	@Override
	public List<Object[]> getThongKeTheoNam() {
		List<Object[]> list = tieuThuyetRepon.getThongKeTheoNam();

		return list;
	}

}
