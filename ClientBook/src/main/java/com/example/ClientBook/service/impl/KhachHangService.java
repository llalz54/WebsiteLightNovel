package com.example.ClientBook.service.impl;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.example.ClientBook.model.DonHangDTO;
import com.example.ClientBook.model.KhachHangDTO;
import com.example.ClientBook.model.TieuThuyetDTO;
import com.example.ClientBook.service.IKhachHangService;

@Service
public class KhachHangService implements IKhachHangService{
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<KhachHangDTO> getAllKH(){
		ResponseEntity<List<KhachHangDTO>> responseEntity = 
				restTemplate.exchange("/customer", 
									HttpMethod.GET, 
									null, 
									new ParameterizedTypeReference<List<KhachHangDTO>>() {});
		return responseEntity.getBody();
	}
	@Override
	public KhachHangDTO findByMaKH(Long maKH) {
		ResponseEntity <KhachHangDTO> responseEntity = restTemplate.exchange("/customer/details/"+maKH, HttpMethod.GET, null, new ParameterizedTypeReference<KhachHangDTO>() {});;
		return responseEntity.getBody();
	}
	@Override
	public KhachHangDTO login(String email, String password) {
	
		ResponseEntity<KhachHangDTO> responseEntity = restTemplate.exchange("/customer/login?email="+email +"@password="+password, HttpMethod.GET, null, new ParameterizedTypeReference<KhachHangDTO>() {});
		return responseEntity.getBody();
	}
	@Override
	public List<KhachHangDTO> search(String keyword){
		ResponseEntity<List<KhachHangDTO>> responseEntity = 
				restTemplate.exchange("/customer/search?keyword="+keyword, 
									HttpMethod.GET, 
									null, 
									new ParameterizedTypeReference<List<KhachHangDTO>>() {});
		return responseEntity.getBody();
	}
	@Override
	public String save(KhachHangDTO khachhang) {
		HttpEntity<KhachHangDTO> entity = new HttpEntity<KhachHangDTO>(khachhang);
		ResponseEntity<KhachHangDTO> responseEntity ;
		if(khachhang.getMaKH() !=null) {
			responseEntity = restTemplate.exchange("/customer/" + khachhang.getMaKH(),
										HttpMethod.PUT, entity,
								       KhachHangDTO.class,khachhang.getMaKH());
		} else {
			responseEntity = restTemplate.postForEntity("/customer", entity, KhachHangDTO.class);
		}
			
		if(responseEntity.getStatusCode()==HttpStatus.OK) {
			return "redirect:register";			
		}else {
			return "common/500error";
		}
		
	}

}
