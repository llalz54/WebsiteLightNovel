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

import com.example.ClientBook.model.CartDTO;
import com.example.ClientBook.model.DonHangDTO;
import com.example.ClientBook.model.LoaiSPDTO;
import com.example.ClientBook.model.TieuThuyetDTO;
import com.example.ClientBook.service.IDonHangService;

@Service
public class DonHangService implements IDonHangService {
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public String save(DonHangDTO dto) {
		HttpEntity<DonHangDTO> entity = new HttpEntity<DonHangDTO>(dto);
		ResponseEntity<DonHangDTO> responseEntity ;
		if(dto.getIDDH() !=null) {
			responseEntity = restTemplate.exchange("/order/" + dto.getIDDH(),
										HttpMethod.PUT, entity,
								       DonHangDTO.class,dto.getIDDH());
		} else {
			responseEntity = restTemplate.postForEntity("/order", entity, DonHangDTO.class);
		}
			
		if(responseEntity.getStatusCode()==HttpStatus.OK) {
			return "redirect:cart";			
		}else {
			return "common/500error";
		}
		
		
	}
	@Override
	public String HuyDon(DonHangDTO dto) {
		HttpEntity<DonHangDTO> entity = new HttpEntity<DonHangDTO>(dto);
		ResponseEntity<DonHangDTO> responseEntity ;
		if(dto.getIDDH() !=null) {
			responseEntity = restTemplate.exchange("/order/HuyDon/" + dto.getIDDH(),
										HttpMethod.PUT, entity,
								       DonHangDTO.class,dto.getIDDH());
		} else {
			responseEntity = restTemplate.postForEntity("/order", entity, DonHangDTO.class);
		}
			
		if(responseEntity.getStatusCode()==HttpStatus.OK) {
			return "redirect:cart";			
		}else {
			return "common/500error";
		}
		
		
	}
	

	@Override
	public void delete(Long IDDH) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DonHangDTO> getByUser(Long maKH) {
		ResponseEntity<List<DonHangDTO>> responseEntity = restTemplate.exchange("/order/user/"+maKH, 
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<List<DonHangDTO>>() {});
return responseEntity.getBody();
	}

	@Override
	public List<DonHangDTO> getAll(){
		ResponseEntity<List<DonHangDTO>> responseEntity = 
				restTemplate.exchange("/order", 
									HttpMethod.GET, 
									null, 
									new ParameterizedTypeReference<List<DonHangDTO>>() {});
		return responseEntity.getBody();
	}
	@Override
	public DonHangDTO search(Long IDDH){
		ResponseEntity <DonHangDTO> responseEntity = 
				restTemplate.exchange("/order/search?iddh="+IDDH, 
									HttpMethod.GET, 
									null, 
									new ParameterizedTypeReference<DonHangDTO>() {});
		return responseEntity.getBody();
	}
	@Override
	public DonHangDTO getByIDDH(Long iddh){
		ResponseEntity<DonHangDTO> responseEntity = 
				restTemplate.exchange("/order/"+iddh, 
									HttpMethod.GET, 
									null, 
									new ParameterizedTypeReference<DonHangDTO>() {});
		return responseEntity.getBody();
	}
}
