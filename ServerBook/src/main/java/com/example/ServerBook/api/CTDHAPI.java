package com.example.ServerBook.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ServerBook.dto.CTDHDTO;
import com.example.ServerBook.dto.DonHangDTO;
import com.example.ServerBook.service.ICTDHService;

@RestController
@RequestMapping("/orderDetail")
public class CTDHAPI {
	@Autowired
	ICTDHService ctdhService;
	
	@PostMapping("")
	public CTDHDTO addOrder_Deatail(@RequestBody CTDHDTO dto) {
		return ctdhService.save(dto);
}

	@GetMapping("/order/{order_id}")
	public List<CTDHDTO> showCTDH( @PathVariable("order_id") Long order_id  ){
		
		return ctdhService.getByDonHang(order_id);
	}
}
