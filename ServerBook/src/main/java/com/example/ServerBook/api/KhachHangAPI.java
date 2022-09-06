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

import com.example.ServerBook.dto.KhachHangDTO;
import com.example.ServerBook.dto.TieuThuyetDTO;
import com.example.ServerBook.service.IKhachHangService;

@RestController
@RequestMapping("/customer")
public class KhachHangAPI {
	@Autowired
	IKhachHangService khachHangService;
	@PostMapping("")
	public KhachHangDTO addUser(@RequestBody KhachHangDTO dto) {
		return khachHangService.save(dto);
}
	@PutMapping("/{id}")
	public KhachHangDTO updateUser(@RequestBody KhachHangDTO dto, @PathVariable("id") Long id) {
		dto.setMaKH(id);
		return khachHangService.save(dto);

}
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		khachHangService.delete(id);
}
	@GetMapping("")
	public List<KhachHangDTO> showAllKH(@RequestParam(name = "page",required = false) Integer pageNumber  ){
		if(pageNumber == null) pageNumber = 1;
		int pageSize =10;
		return khachHangService.getAll(pageNumber, pageSize);
	}
	@GetMapping("search")
	public List<KhachHangDTO> search(@RequestParam(name = "kh",required = false) String kh ){
		return khachHangService.search(kh);
	}
	@GetMapping("login")
	public KhachHangDTO login(@RequestParam(name = "email",required = false) String email,
									@RequestParam(name = "password",required = false) String password){
		return khachHangService.login(email,password);
	}
	@GetMapping("details/{id}")
	public KhachHangDTO show1KH( @PathVariable("id") Long id) {
		return khachHangService.getOneByMaKH(id);
		}
}
