package com.example.ServerBook.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ServerBook.convert.ConvertCart;
import com.example.ServerBook.convert.ConvertKhachHang;
import com.example.ServerBook.dto.CartDTO;
import com.example.ServerBook.dto.KhachHangDTO;
import com.example.ServerBook.entity.CartEntity;
import com.example.ServerBook.entity.KhachHangEntity;
import com.example.ServerBook.entity.TieuThuyetEntity;
import com.example.ServerBook.repository.CartRepon;
import com.example.ServerBook.repository.KhachHangRepon;
import com.example.ServerBook.repository.TieuThuyetRepon;
import com.example.ServerBook.service.ICartService;

@Service
public class CartService implements ICartService {

	@Autowired
	private CartRepon cartRepon;
	@Autowired 
	private KhachHangRepon khachHangRepon;
	@Autowired
	private ConvertCart convertCart;
	@Autowired
	private ConvertKhachHang convertKhachHang;
	@Autowired
	private TieuThuyetRepon tieuThuyetRepon;
	
	private Map<Long, CartEntity> map = new HashMap<Long, CartEntity>();
	
	
	@Override
	public List<CartDTO> getByUser(Long userid) {
		KhachHangEntity KH = khachHangRepon.findById(userid).get();
		List<CartEntity> cartEntities = cartRepon.findByKhachHang(KH);
//		List<CartDTO> cartDTOs = new ArrayList<>();
//		for (CartEntity cartEntity : cartEntities) {
//			cartDTOs.add(convertCart.toDTO(cartEntity));
//		}
		return cartEntities.stream().map(convertCart::toDTO).collect(Collectors.toList());
	}

	@Override
	public CartDTO addtoCart(CartDTO dto) {
		
		CartEntity cart = new CartEntity();
		if(dto.getId() != null)  {
			
			CartEntity olCartEntity = cartRepon.findById(dto.getId()).get();
			if(dto.getSoLuong() > olCartEntity.getTieuThuyet().getSoLuong()) {
				return dto;
			}
			olCartEntity.setSoLuong(dto.getSoLuong());
			cart = convertCart.toEntity(dto, olCartEntity);
		}
		else {
			
			cart = convertCart.toEntity(dto);
			KhachHangEntity kh = khachHangRepon.findById(dto.getMaKH()).get();
			TieuThuyetEntity tt = tieuThuyetRepon.findById(dto.getMaSach()).get();
			cart.setKhachHang(kh);
			cart.setTieuThuyet(tt);
		}
	
		cart = cartRepon.save(cart);
		return convertCart.toDTO(cart);
	}

	

	@Override
	public void delete(Long id) {
		CartEntity cartEntity = cartRepon.findById(id).get();
		cartRepon.delete(cartEntity);
	}
	
	@Override
	public void deleteAll(Long userid) {
		KhachHangEntity KH = khachHangRepon.findById(userid).get();
		cartRepon.deleteAllByKhachHang(KH);
	}
	
	public void updateSoLuong( Long id, int soLuong ) {
		CartEntity cart = cartRepon.findById(id).get();
		CartDTO dto = new CartDTO();
		if(dto.getId() == id) {
			dto.setSoLuong(soLuong);
			cart =convertCart.toEntity(dto);
		}
		cart = cartRepon.save(cart);
		convertCart.toDTO(cart);
	
	}
	
	
	
	@Override
	public int getCount() {
		if(map.isEmpty()) {
			return 0;
		}
		return map.values().size();
	}

	

	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
