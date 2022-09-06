package com.example.ClientBook.service;

import java.util.List;

import com.example.ClientBook.model.CartDTO;

public interface ICartService {
	
	String addtoCart(CartDTO dto);

	List<CartDTO> getCartByUser(Long maKH);

	void update(Long id, int soLuong);
	int getCount();


	double getAmount(List<CartDTO> list);


}
