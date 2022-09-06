package com.example.ServerBook.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ServerBook.convert.ConvertKhachHang;
import com.example.ServerBook.dto.KhachHangDTO;
import com.example.ServerBook.entity.KhachHangEntity;
import com.example.ServerBook.repository.KhachHangRepon;
import com.example.ServerBook.service.IKhachHangService;


@Service
public class KhachHangService implements IKhachHangService {
	@Autowired
	private KhachHangRepon khachHangRepon;
	
	@Autowired
	private ConvertKhachHang convertKhachHang;
	private final int PAGE_OFFSET =1;
    
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public KhachHangDTO save(KhachHangDTO dto) {
		KhachHangEntity kh = new KhachHangEntity();
		if(dto.getMaKH() != null ) {
			KhachHangEntity oldEntity = khachHangRepon.findById(dto.getMaKH()).get();
			kh = convertKhachHang.toEntity(dto, oldEntity);
			
		}
		else {
			kh = convertKhachHang.toEntity(dto);
		}
		kh = khachHangRepon.save(kh);
		
		return convertKhachHang.toDTO(kh);
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<KhachHangDTO> getAll(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber - PAGE_OFFSET, pageSize);
		 Page<KhachHangEntity> entity = khachHangRepon.findAll(pageable) ;
		 List<KhachHangDTO> listDTO = new ArrayList<>();
		 for(KhachHangEntity itemEntity : entity)
		 {
			 KhachHangDTO dto = convertKhachHang.toDTO(itemEntity);
			 listDTO.add(dto);
		 }
		 
		return listDTO ;
	
	}

	@Override
	public List<KhachHangDTO> search(String kh) {
		List<KhachHangEntity> list = khachHangRepon.search(kh);
		List<KhachHangDTO> listDTO = new ArrayList<>();
		for(KhachHangEntity entity:list) {
			KhachHangDTO dto = convertKhachHang.toDTO(entity);
			listDTO.add(dto);
		}
		
		return listDTO;
	}

	@Override
	public KhachHangDTO getOneByMaKH(Long id) {
		KhachHangEntity entity = khachHangRepon.findById(id).get();
		KhachHangDTO dto = convertKhachHang.toDTO(entity);
		return dto;
	}

	@Override
	public KhachHangDTO login(String email, String password) {
		KhachHangEntity kh = khachHangRepon.FindByEmailAndPassWord(email,password);
		if(bCryptPasswordEncoder.matches(password, kh.getPass())) {
			kh.setPass("");
		}
		KhachHangDTO dto = convertKhachHang.toDTO(kh);
		return dto;
	}

}
