package com.example.ServerBook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.ServerBook.convert.ConvertNhanVien;
import com.example.ServerBook.dto.KhachHangDTO;
import com.example.ServerBook.dto.NhanVienDTO;
import com.example.ServerBook.entity.KhachHangEntity;
import com.example.ServerBook.entity.NhanVienEntity;
import com.example.ServerBook.entity.RoleEntity;
import com.example.ServerBook.repository.NhanVienRepon;
import com.example.ServerBook.repository.RoleRepon;
import com.example.ServerBook.service.INhanVienService;

@Service
public class NhanVienService implements INhanVienService {
	@Autowired
	private NhanVienRepon nhanVienRepon;
	@Autowired
	private RoleRepon roleRepon;
	@Autowired
	private ConvertNhanVien convertNhanVien;
	private final int PAGE_OFFSET =1;

	@Override
	public NhanVienDTO save(NhanVienDTO dto) {
		NhanVienEntity nv = new NhanVienEntity();
		if(dto.getMaNV() != null) {
			NhanVienEntity oldEntity = nhanVienRepon.findById(dto.getMaNV()).get();
			nv = convertNhanVien.toEntity(dto, oldEntity);
		}
		else {
			nv = convertNhanVien.toEntity(dto);
		}
		RoleEntity role = roleRepon.findById(dto.getRole_id()).get();
		nv.setRole(role);
		nv = nhanVienRepon.save(nv);
		return convertNhanVien.toDTO(nv);
	}

	@Override
	public void delete(Long id) {
		NhanVienEntity entity = nhanVienRepon.findById(id).get();
		nhanVienRepon.delete(entity);
	}

	@Override
	public List<NhanVienDTO> getAll(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber - PAGE_OFFSET, pageSize);
		 Page<NhanVienEntity> entity = nhanVienRepon.findAll(pageable) ;
		 List<NhanVienDTO> listDTO = new ArrayList<>();
		 for(NhanVienEntity itemEntity : entity)
		 {
			 NhanVienDTO dto = convertNhanVien.toDTO(itemEntity);
			 listDTO.add(dto);
		 }
		 
		return listDTO ;
	}

	@Override
	public List<NhanVienDTO> search(String nv) {
		List<NhanVienEntity> list = nhanVienRepon.search(nv);
		List<NhanVienDTO> listDTO = new ArrayList<>();
		for(NhanVienEntity entity:list) {
			NhanVienDTO dto = convertNhanVien.toDTO(entity);
			listDTO.add(dto);
		}
		
		return listDTO;
	}

	@Override
	public NhanVienDTO getOneByMaNV(Long id) {
		NhanVienEntity entity = nhanVienRepon.findById(id).get();
		NhanVienDTO dto = convertNhanVien.toDTO(entity);
		return dto;
	}

	@Override
	public NhanVienDTO login(String username, String password) {
		NhanVienEntity nv = nhanVienRepon.FindByEmailAndPassWord(username,password);
		NhanVienDTO dto = convertNhanVien.toDTO(nv);
		return dto;
	}

}
