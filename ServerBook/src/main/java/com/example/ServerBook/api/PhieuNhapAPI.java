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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ServerBook.dto.DonHangDTO;
import com.example.ServerBook.dto.KhachHangDTO;
import com.example.ServerBook.dto.PhieuNhapDTO;
import com.example.ServerBook.service.IPhieuNhapService;



@RestController
@RequestMapping("/received")
public class PhieuNhapAPI {
	@Autowired
	IPhieuNhapService phieuNhapService;
	@PostMapping("")
	public PhieuNhapDTO addPN(@RequestBody PhieuNhapDTO dto) {
		return phieuNhapService.save(dto);
}

	@PutMapping("/{id}")
	public PhieuNhapDTO updatePN(@RequestBody PhieuNhapDTO dto, @PathVariable("id") Long id) {
		dto.setIDPN(id);
		return phieuNhapService.save(dto);
	}

	@DeleteMapping("/{id}")
	public void deletePN(@PathVariable("id") Long id) {
		phieuNhapService.delete(id);
}
	@GetMapping("")
	public List<PhieuNhapDTO> showAllPN(@RequestParam(name = "page",required = false) Integer pageNumber  ){
		if(pageNumber == null) pageNumber = 1;
		int pageSize =10;
		return phieuNhapService.getAllPN(pageNumber, pageSize);
	}

}
