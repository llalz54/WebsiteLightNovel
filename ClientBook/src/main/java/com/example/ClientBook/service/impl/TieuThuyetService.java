package com.example.ClientBook.service.impl;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.example.ClientBook.model.LoaiSPDTO;
import com.example.ClientBook.model.TieuThuyetDTO;
import com.example.ClientBook.service.ITieuThuyetService;


@Service
public class TieuThuyetService implements ITieuThuyetService{
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<TieuThuyetDTO> getAll(){
		ResponseEntity<List<TieuThuyetDTO>> responseEntity = 
				restTemplate.exchange("/ln", 
									HttpMethod.GET, 
									null, 
									new ParameterizedTypeReference<List<TieuThuyetDTO>>() {});
		return responseEntity.getBody();
	}
//	@Override
//	public List<TieuThuyetDTO> findByLoaiTT(Long loaiTT_ID, Long page) {
//		if(page == null)
//			page=1;
//		ResponseEntity<Map<String, Object>> responseEntity = restTemplate.exchange("/ln/"+loaiTT_ID+"?page="+page, HttpMethod.GET, null, new ParameterizedTypeReference<Map<String,Object>>() {});
//		return (List<TieuThuyetDTO>) responseEntity.getBody().get("content");//truyền vô chỗ content đó bằng mấy cái như totalpage các kiểu ấy
//	}
	@Override
	public Map<String, Object> findByLoaiTT(Long loaiTT_ID, Integer page) {
		ResponseEntity<Map<String, Object>> responseEntity = restTemplate.exchange("/ln/"+loaiTT_ID+"?page="+page, HttpMethod.GET, null, new ParameterizedTypeReference<Map<String,Object>>() {});
		return responseEntity.getBody();//truyền vô chỗ content đó bằng mấy cái như totalpage các kiểu ấy
	}
	
	@Override
	public List<TieuThuyetDTO> search(String keyword){
		ResponseEntity<List<TieuThuyetDTO>> responseEntity = 
				restTemplate.exchange("/ln/search?keyword="+keyword, 
									HttpMethod.GET, 
									null, 
									new ParameterizedTypeReference<List<TieuThuyetDTO>>() {});
		return responseEntity.getBody();
	}
	@Override
	public List<LoaiSPDTO> getTT(){
		ResponseEntity<List<LoaiSPDTO>> responseEntity = 
				restTemplate.exchange("/categoris", 
									HttpMethod.GET, 
									null, 
									new ParameterizedTypeReference<List<LoaiSPDTO>>() {});
		return responseEntity.getBody();
	}

	@Override
	public String save(TieuThuyetDTO tieuthuyet, MultipartFile imageLink) {
		try {
			tieuthuyet.setHinhAnh(Base64.getEncoder().encodeToString(imageLink.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
			return "redirect:admin-product-add";
		}
		
		HttpEntity<TieuThuyetDTO> entity = new HttpEntity<TieuThuyetDTO>(tieuthuyet);
		ResponseEntity<TieuThuyetDTO> responseEntity;
		if(tieuthuyet.getMaSach() !=null) {
			responseEntity = restTemplate.exchange("/ln/" + tieuthuyet.getMaSach(),
										HttpMethod.PUT, entity,
								       TieuThuyetDTO.class,tieuthuyet.getMaSach());
		} else {
			responseEntity = restTemplate.postForEntity("/ln", entity, TieuThuyetDTO.class);
		}
		if(responseEntity.getStatusCode()==HttpStatus.OK) {
			return "redirect:admin-product";			
		}else {
			return "common/500error";
		}
		
	}
	@Override
	public TieuThuyetDTO getByIDSP(Long maSach){
		ResponseEntity<TieuThuyetDTO> responseEntity = 
				restTemplate.exchange("/ln/details/"+maSach, 
									HttpMethod.GET, 
									null, 
									new ParameterizedTypeReference<TieuThuyetDTO>() {});
		return responseEntity.getBody();
	}
	@Override
	public String save(LoaiSPDTO dto) {
		HttpEntity<LoaiSPDTO> entity = new HttpEntity<LoaiSPDTO>(dto);
		ResponseEntity<LoaiSPDTO> responseEntity;
		if(dto.getLoaiTT_ID() !=null) {
			responseEntity = restTemplate.exchange("/categoris/" + dto.getLoaiTT_ID(),
										HttpMethod.PUT, entity,
								       LoaiSPDTO.class,dto.getLoaiTT_ID());
		} else {
			responseEntity = restTemplate.postForEntity("/categoris", entity, LoaiSPDTO.class);
		}
		if(responseEntity.getStatusCode()==HttpStatus.OK) {
			return "redirect:admin-category";			
		}else {
			return "common/500error";
		}
	}
	
	@Override
	public LoaiSPDTO getOneByLoaiTTID(Long loaiTT_ID) {
		ResponseEntity<LoaiSPDTO> responseEntity = 
				restTemplate.exchange("/categoris/details/"+loaiTT_ID, 
									HttpMethod.GET, 
									null, 
									new ParameterizedTypeReference<LoaiSPDTO>() {});
		return responseEntity.getBody();
	}
	@Override
	public List<Object[]> getTieuThuyetBanChay() {
		ResponseEntity<List<Object[]>> responseEntity = 
				restTemplate.exchange("/ln/selling", 
									HttpMethod.GET, 
									null, 
									new ParameterizedTypeReference<List<Object[]>>() {});
		return responseEntity.getBody();
	}
	@Override
	public List<Object[]> getThongKeTheoNgay() {
		ResponseEntity<List<Object[]>> responseEntity = 
				restTemplate.exchange("/ln/byDay", 
									HttpMethod.GET, 
									null, 
									new ParameterizedTypeReference<List<Object[]>>() {});
		return responseEntity.getBody();
	}
	@Override
	public List<Object[]> getThongKeTheoThang() {
		ResponseEntity<List<Object[]>> responseEntity = 
				restTemplate.exchange("/ln/byMonth", 
									HttpMethod.GET, 
									null, 
									new ParameterizedTypeReference<List<Object[]>>() {});
		return responseEntity.getBody();
	}
	@Override
	public List<Object[]> getThongKeTheoNam() {
		ResponseEntity<List<Object[]>> responseEntity = 
				restTemplate.exchange("/ln/byYear", 
									HttpMethod.GET, 
									null, 
									new ParameterizedTypeReference<List<Object[]>>() {});
		return responseEntity.getBody();
	}
	@Override
	public List<TieuThuyetDTO> getByTT(Long loaiTT_ID) {
		ResponseEntity<List<TieuThuyetDTO>> responseEntity = 
				restTemplate.exchange("/ln/loaiTT/"+loaiTT_ID, 
									HttpMethod.GET, 
									null, 
									new ParameterizedTypeReference<List<TieuThuyetDTO>>() {});
		return responseEntity.getBody();
	}

	
	
	
}
