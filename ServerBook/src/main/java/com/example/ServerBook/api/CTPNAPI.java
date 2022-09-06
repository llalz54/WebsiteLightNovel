package com.example.ServerBook.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ServerBook.dto.CTDHDTO;
import com.example.ServerBook.dto.CTPNDTO;
import com.example.ServerBook.dto.PhieuNhapDTO;
import com.example.ServerBook.service.ICTDHService;
import com.example.ServerBook.service.ICTPNService;

@RestController
@RequestMapping("/received_details")
public class CTPNAPI {
	@Autowired
	ICTPNService ctpnService;
	
	@PostMapping("")
	public CTPNDTO addReceived_Deatail(@RequestBody CTPNDTO dto) {
		return ctpnService.save(dto);
}

	@PutMapping("/{id}")
	public CTPNDTO updatePN(@RequestBody CTPNDTO dto, @PathVariable("id") Long id) {
		dto.setIDCTPN(id);
		return ctpnService.save(dto);
	}
	@GetMapping("/{received_id}")
	public List<CTPNDTO> showCTPN( @PathVariable("received_id") Long received_id  ){
		
		return ctpnService.getByPhieuNhap(received_id);
	}

}
