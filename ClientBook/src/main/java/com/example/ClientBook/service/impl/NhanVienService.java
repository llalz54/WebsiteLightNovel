package com.example.ClientBook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.ClientBook.model.KhachHangDTO;
import com.example.ClientBook.model.NhanVienDTO;
import com.example.ClientBook.service.INhanVienService;

@Service
public class NhanVienService implements INhanVienService {
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public NhanVienDTO save(NhanVienDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<NhanVienDTO> getAll() {
		ResponseEntity<List<NhanVienDTO>> responseEntity = 
				restTemplate.exchange("/staff", 
									HttpMethod.GET, 
									null, 
									new ParameterizedTypeReference<List<NhanVienDTO>>() {});
		return responseEntity.getBody();
	}

	@Override
	public List<NhanVienDTO> search(String nv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NhanVienDTO getOneByMaNV(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NhanVienDTO login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
