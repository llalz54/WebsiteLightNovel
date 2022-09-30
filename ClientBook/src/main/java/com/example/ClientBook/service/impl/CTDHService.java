package com.example.ClientBook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ClientBook.model.CTDHDTO;
import com.example.ClientBook.model.DonHangDTO;
import com.example.ClientBook.service.ICTDHService;

@Service
public class CTDHService implements ICTDHService {
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public String save(CTDHDTO dto) {
		HttpEntity<CTDHDTO> entity = new HttpEntity<CTDHDTO>(dto);
		ResponseEntity<CTDHDTO> responseEntity ;
		responseEntity = restTemplate.postForEntity("/orderDetail", entity, CTDHDTO.class);
		if(responseEntity.getStatusCode()==HttpStatus.OK) {
			return "redirect:cart";			
		}else {
			return "common/500error";
		}
	}

	@Override
	public List<CTDHDTO> getByDonHang(Long IDDH) {
		ResponseEntity<List<CTDHDTO>> responseEntity = restTemplate.exchange("/orderDetail/order/"+IDDH, 
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<List<CTDHDTO>>() {});
return responseEntity.getBody();
	}
}
