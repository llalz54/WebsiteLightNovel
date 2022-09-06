package com.example.ServerBook.service.impl;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ServerBook.convert.ConvertLoaiSP;
import com.example.ServerBook.dto.LoaiSPDTO;
import com.example.ServerBook.dto.TieuThuyetDTO;
import com.example.ServerBook.entity.LoaiSPEntity;
import com.example.ServerBook.entity.TieuThuyetEntity;
import com.example.ServerBook.repository.LoaiSPRepon;
import com.example.ServerBook.repository.TieuThuyetRepon;
import com.example.ServerBook.service.ILoaiSPService;

@Service
public class LoaiSPService implements ILoaiSPService {
	@Autowired
	private LoaiSPRepon loaiSPRepon;
	@Autowired
	private ConvertLoaiSP convertLoaiSP;
	@Autowired
	private TieuThuyetRepon tieuThuyetRepon;

	@Override
	public List<LoaiSPDTO> getAll() {
		List<LoaiSPDTO> listDTO = new ArrayList<LoaiSPDTO>();
		List<LoaiSPEntity> listenEntities = loaiSPRepon.findAll();
		for(LoaiSPEntity entity : listenEntities)
		{
			LoaiSPDTO dto = convertLoaiSP.toDTO(entity);
			listDTO.add(dto);
		}
		return listDTO;
	}

	@Override
	public LoaiSPDTO save(LoaiSPDTO dto) {
		LoaiSPEntity loaisp = new LoaiSPEntity();
		
		if(dto.getLoaiTT_ID() != null ) {
			LoaiSPEntity oldEntity = loaiSPRepon.findById(dto.getLoaiTT_ID()).get();
			loaisp = convertLoaiSP.toEntity(dto, oldEntity);
			
		}
		else {
			
				loaisp = convertLoaiSP.toEntity(dto);
					
		}
		loaisp = loaiSPRepon.save(loaisp); 
		
		return convertLoaiSP.toDTO(loaisp);
	}

	@Override
	public void delete(Long loaiTT_ID) {
		LoaiSPEntity entity = loaiSPRepon.findById(loaiTT_ID).get();
		if(tieuThuyetRepon.findByLoaiTT(entity) !=null)
			return;
		loaiSPRepon.delete(entity);
		
	}

	@Override
	public LoaiSPDTO getOneByLoaiTTID(Long loaiTT_ID) {
		LoaiSPEntity entity = loaiSPRepon.findById(loaiTT_ID).get();
		LoaiSPDTO dto = convertLoaiSP.toDTO(entity);
		return dto;
	}

}
