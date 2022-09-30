package com.example.ClientBook.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ClientBook.model.CartDTO;
import com.example.ClientBook.service.ICartService;


@Service
public class CartService implements ICartService {
	@Autowired
	private RestTemplate restTemplate;
	private Map<Long, CartDTO> map = new HashMap<Long, CartDTO>();
	
	
	@Override
	public String addtoCart(CartDTO dto) {
		

		HttpEntity<CartDTO> entity = new HttpEntity<CartDTO>(dto);
		ResponseEntity<CartDTO> responseEntity;
		if(dto.getId() !=null) {
			responseEntity = restTemplate.exchange("/cart/" + dto.getId(),
										HttpMethod.PUT, entity,
								       CartDTO.class,dto.getId());
		} else {
			responseEntity = restTemplate.postForEntity("/cart", entity, CartDTO.class);
		}
		if(responseEntity.getStatusCode()==HttpStatus.OK) {
			return "redirect:cart";			
		}else {
			return "common/500error";
		}
		
}
	@Override
	public List<CartDTO> getCartByUser(Long maKH){
		ResponseEntity<List<CartDTO>> responseEntity = restTemplate.exchange("/cart/user/"+maKH, 
									HttpMethod.GET, 
									null, 
									new ParameterizedTypeReference<List<CartDTO>>() {});
		return responseEntity.getBody();
	}
	
	
	@Override
	public double getAmount(List<CartDTO> list) {
		double amount = 0;
		for(CartDTO cartitem : list) {
			amount += (cartitem.getDonGia() - (cartitem.getDonGia() * cartitem.getGiamGia()/100)) * cartitem.getSoLuong();
		}
		
		return amount;
	}
	
	@Override
	public int getCount() {
		if(map.isEmpty()) {
			return 0;
		}
		return map.values().size();
	}
	@Override
	public void update(Long id, int soLuong) {
		// TODO Auto-generated method stub
		
	}
	
	}
