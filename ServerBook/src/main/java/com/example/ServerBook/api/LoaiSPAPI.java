package com.example.ServerBook.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ServerBook.dto.LoaiSPDTO;
import com.example.ServerBook.dto.TieuThuyetDTO;
import com.example.ServerBook.service.ILoaiSPService;

@RestController
@RequestMapping("/categoris")
public class LoaiSPAPI {
	@Autowired
	ILoaiSPService loaiSPService;
	
	@GetMapping("")
	public List<LoaiSPDTO> getAll(){
		return loaiSPService.getAll();
	}
	@PostMapping("")
	public LoaiSPDTO addLoaiSP(@RequestBody LoaiSPDTO dto) {
		return loaiSPService.save(dto);

}
	@PutMapping("/{loaiTT_ID}")
	public LoaiSPDTO updateLoaiSP(@RequestBody LoaiSPDTO dto, @PathVariable("loaiTT_ID") Long loaiTT_ID) {
		dto.setLoaiTT_ID(loaiTT_ID);
		return loaiSPService.save(dto);

}
	@DeleteMapping("/{loaiTT_ID}")
	public void deleteLoaiSP(@PathVariable("loaiTT_ID") Long loaiTT_ID) {
		 loaiSPService.delete(loaiTT_ID);
}
	@GetMapping("details/{loaiTT_ID}")
	public LoaiSPDTO show1LoaiSP( @PathVariable("loaiTT_ID") Long loaiTT_ID) {
		return loaiSPService.getOneByLoaiTTID(loaiTT_ID);
		}
}
