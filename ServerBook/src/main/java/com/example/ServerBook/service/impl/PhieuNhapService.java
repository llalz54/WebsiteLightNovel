package com.example.ServerBook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.ServerBook.convert.ConvertPhieuNhap;
import com.example.ServerBook.dto.PhieuNhapDTO;
import com.example.ServerBook.entity.PhieuNhapEntity;
import com.example.ServerBook.repository.PhieuNhapRepon;
import com.example.ServerBook.service.IPhieuNhapService;

@Service
public class PhieuNhapService implements IPhieuNhapService {
	@Autowired
	private PhieuNhapRepon phieuNhapRepon;
	@Autowired
	private ConvertPhieuNhap convertPhieuNhap;
	private final int PAGE_OFFSET =1;

	@Override
	public PhieuNhapDTO save(PhieuNhapDTO dto) {
		PhieuNhapEntity pn = new PhieuNhapEntity();
		if(dto.getIDPN() != null) {
			PhieuNhapEntity oldEntity = phieuNhapRepon.findById(dto.getIDPN()).get();
			pn = convertPhieuNhap.toEntity(dto, oldEntity);
		}
		else {
			pn = convertPhieuNhap.toEntity(dto);
		}
		pn = phieuNhapRepon.save(pn);
		return convertPhieuNhap.toDTO(pn);
	}
	

	@Override
	public void delete(Long id) {
		PhieuNhapEntity pnEntity = phieuNhapRepon.findById(id).get();
		phieuNhapRepon.delete(pnEntity);
		
	}

	@Override
	public List<PhieuNhapDTO> getAllPN(Integer pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber - PAGE_OFFSET, pageSize);
		 Page<PhieuNhapEntity> entity = phieuNhapRepon.findAll(pageable) ;
		 List<PhieuNhapDTO> listDTO = new ArrayList<>();
		 for(PhieuNhapEntity itemEntity : entity)
		 {
			 PhieuNhapDTO dto = convertPhieuNhap.toDTO(itemEntity);
			 listDTO.add(dto);
		 }
		 
		return listDTO ;
	}

}
