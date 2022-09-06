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

import com.example.ServerBook.dto.CartDTO;
import com.example.ServerBook.dto.DonHangDTO;
import com.example.ServerBook.dto.KhachHangDTO;
import com.example.ServerBook.dto.TieuThuyetDTO;
import com.example.ServerBook.service.IDonHangService;

@RestController
@RequestMapping("/order")
public class DonHangAPI {
	@Autowired
	IDonHangService donHangService;
	
	@PostMapping("")
	public DonHangDTO addOrder(@RequestBody DonHangDTO dto) {
		return donHangService.save(dto);
}

	@PutMapping("/{id}")
	public DonHangDTO updateDH(@RequestBody DonHangDTO dto, @PathVariable("id") Long id) {
		dto.setIDDH(id);
		return donHangService.save(dto);

}
	@DeleteMapping("/{id}")
	public void deleteItem(@PathVariable("id") Long id) {
		donHangService.delete(id);
}
	@GetMapping("/user/{userid}")
	public List<DonHangDTO> showAllCart( @PathVariable("userid") Long userid  ){
		
		return donHangService.getByUser(userid);
	}
	@GetMapping("")
	public List<DonHangDTO> showAllOrder(@RequestParam(name = "page",required = false) Integer pageNumber  ){
		if(pageNumber == null) pageNumber = 1;
		int pageSize =100;
		return donHangService.getAll(pageNumber, pageSize);
	}
	@GetMapping("/{id}")
	public DonHangDTO show1Order( @PathVariable("id") Long id  ){
		
		return donHangService.getByID(id);
	}
	@GetMapping("search")
	public DonHangDTO search(@RequestParam(name = "iddh",required = false) Long iddh ){
		return donHangService.search(iddh);
	}
	
	@PutMapping("/HuyDon/{id}")
	public DonHangDTO HuyDon(@PathVariable("id") Long id,@RequestBody DonHangDTO dto) {
		return donHangService.HuyDon(dto);
	}
	
}
