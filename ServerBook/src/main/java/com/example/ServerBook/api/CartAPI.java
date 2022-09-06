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
import com.example.ServerBook.dto.NhanVienDTO;
import com.example.ServerBook.service.ICartService;
import com.example.ServerBook.service.impl.CartService;

@RestController
@RequestMapping("/cart")
public class CartAPI {

	@Autowired
	private ICartService cartService;
	
	@PostMapping("")
	public CartDTO addCart(@RequestBody CartDTO dto) {
		return cartService.addtoCart(dto);

}
	@PutMapping("/{id}")
	public CartDTO editCart(@RequestBody CartDTO dto, @PathVariable("id") Long id) {
		dto.setId(id);
		return cartService.addtoCart(dto);

}
	@DeleteMapping("/{id}")
	public void deleteItem(@PathVariable("id") Long id) {
		cartService.delete(id);
}
	@DeleteMapping("/user/{userid}")
	public void deleteAll(@PathVariable("userid") Long userid) {
		cartService.deleteAll(userid);
}
	@GetMapping("/user/{userid}")
	public List<CartDTO> showAllCart( @PathVariable("userid") Long userid  ){
		
		return cartService.getByUser(userid);
	}
	
	@GetMapping("getCount")
	public int getCount( @RequestBody CartDTO dto  ){
		
		return cartService.getCount();
	}
	@GetMapping("getAmout")
	public double getAmount( @RequestBody CartDTO dto  ){
		
		return cartService.getAmount();
	}
}
