package com.example.ServerBook.service;

import java.util.Collection;
import java.util.List;

import com.example.ServerBook.dto.CartDTO;
import com.example.ServerBook.dto.KhachHangDTO;
import com.example.ServerBook.entity.CartEntity;

public interface ICartService {

	List<CartDTO> getByUser(Long userid);
	CartDTO addtoCart(CartDTO dto);
	void delete(Long id);
	void deleteAll(Long userid);

	int getCount();

	double getAmount();
	
	void updateSoLuong(Long id,int soLuong);

}
