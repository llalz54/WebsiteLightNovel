package com.example.ServerBook.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.ServerBook.convert.ConvertDonHang;
import com.example.ServerBook.dto.DonHangDTO;
import com.example.ServerBook.dto.KhachHangDTO;
import com.example.ServerBook.dto.TieuThuyetDTO;
import com.example.ServerBook.entity.CTDHEntity;
import com.example.ServerBook.entity.CartEntity;
import com.example.ServerBook.entity.DonHangEntity;
import com.example.ServerBook.entity.KhachHangEntity;
import com.example.ServerBook.entity.TieuThuyetEntity;
import com.example.ServerBook.repository.CTDHRepon;
import com.example.ServerBook.repository.CartRepon;
import com.example.ServerBook.repository.DonHangRepon;
import com.example.ServerBook.repository.KhachHangRepon;
import com.example.ServerBook.repository.TieuThuyetRepon;
import com.example.ServerBook.service.IDonHangService;

@Service
public class DonHangService implements IDonHangService {
	@Autowired
	private DonHangRepon donHangRepon;

	@Autowired
	private ConvertDonHang convertDonHang;
	@Autowired
	private KhachHangRepon khachHangRepon;
	@Autowired
	private TieuThuyetRepon tieuThuyetRepon;;
	@Autowired
	private CartRepon cartRepon;
	@Autowired
	private CTDHRepon ctdhRepon;
	private final int PAGE_OFFSET = 1;

	@Override
	public DonHangDTO save(DonHangDTO dto) {
		DonHangEntity entity = new DonHangEntity();

		if (dto.getIDDH() != null) {
			DonHangEntity oldEntity = donHangRepon.findById(dto.getIDDH()).get();
			entity = convertDonHang.toEntity(dto, oldEntity);

		} else {
			entity = convertDonHang.toEntity(dto);
		}

		entity.setKhachHang(khachHangRepon.findById(dto.getMaKH()).get());
		entity = donHangRepon.save(entity);
		System.out.println(entity.toString());

		List<CartEntity> cartEntities = cartRepon.findByKhachHang(entity.getKhachHang());
		List<CTDHEntity> ctdhEntities = new ArrayList<>();

		for (CartEntity cartEntity : cartEntities) {

			CTDHEntity ctdh = new CTDHEntity();
			ctdh.setDonHang(entity);
			ctdh.setTieuThuyet(cartEntity.getTieuThuyet());
			ctdh.setSoLuong(cartEntity.getSoLuong());
			System.out.println(cartEntity.getTieuThuyet().getDonGia());
			ctdh.setDonGia((int) cartEntity.getTieuThuyet().getGiaSauGiamGia());
			ctdhEntities.add(ctdh);

		}
		if(entity.getTrangthai() == 0 || entity.getTrangthai() == 3) {
			for (CTDHEntity ctdhEntity : ctdhEntities) {
				TieuThuyetEntity tieuThuyetEntity = tieuThuyetRepon.findById(ctdhEntity.getTieuThuyet().getId()).get();
				tieuThuyetEntity.setSoLuong((tieuThuyetEntity.getSoLuong() - ctdhEntity.getSoLuong()));
				tieuThuyetRepon.saveAndFlush(tieuThuyetEntity);
			}
		}

		ctdhRepon.saveAllAndFlush(ctdhEntities);

		cartRepon.deleteAll(cartEntities);

		return convertDonHang.toDTO(entity);
	}

	@Override
	public void delete(Long id) {
		DonHangEntity dh = donHangRepon.findById(id).get();
		if (dh != null) {
			dh.setTrangthai(-1);
			donHangRepon.save(dh);
		}

	}

	
	@Override
	public DonHangDTO HuyDon(DonHangDTO dto) {
		DonHangEntity entity = new DonHangEntity();
		if (dto.getIDDH() != null) {
			DonHangEntity oldEntity = donHangRepon.findById(dto.getIDDH()).get();
			entity = convertDonHang.toEntity(dto, oldEntity);
		}
		entity.setTrangthai(2);
		donHangRepon.save(entity);
		List<CTDHEntity> ctdhEntities = ctdhRepon.findByDonHang(entity);
		if(entity.getTrangthai() == 2) {
		for (CTDHEntity ctdhEntity : ctdhEntities) {
			TieuThuyetEntity tieuThuyetEntity = tieuThuyetRepon.findById(ctdhEntity.getTieuThuyet().getId()).get();
			tieuThuyetEntity.setSoLuong((tieuThuyetEntity.getSoLuong() + ctdhEntity.getSoLuong()));
			tieuThuyetRepon.saveAndFlush(tieuThuyetEntity);
		}
		}
		return convertDonHang.toDTO(entity);

	}

	@Override
	public List<DonHangDTO> getByUser(Long userid) {
		KhachHangEntity kh = khachHangRepon.findById(userid).get();
		List<DonHangEntity> listdh = donHangRepon.findByKhachHang(kh);
		return listdh.stream().map(convertDonHang::toDTO).collect(Collectors.toList());
	}

	@Override
	public List<DonHangDTO> getAll(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber - PAGE_OFFSET, pageSize);
		Page<DonHangEntity> entity = donHangRepon.findAll(pageable);
		List<DonHangDTO> listDTO = new ArrayList<>();
		for (DonHangEntity itemEntity : entity) {
			DonHangDTO dto = convertDonHang.toDTO(itemEntity);
			listDTO.add(dto);
		}

		return listDTO;
	}

	@Override
	public DonHangDTO getByID(Long id) {
		DonHangEntity entity = donHangRepon.findById(id).get();
		DonHangDTO dto = convertDonHang.toDTO(entity);
		return dto;
	}

	@Override
	public DonHangDTO search(Long iddh) {
		DonHangEntity dh = donHangRepon.findById(iddh).get();
		DonHangDTO DTO = convertDonHang.toDTO(dh);

		return DTO;
	}

}
