package com.example.ServerBook.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ServerBook.dto.TieuThuyetDTO;
import com.example.ServerBook.service.ITieuThuyetService;

import java.util.List;

@RestController
@RequestMapping("/ln")
public class TieuThuyetAPI {
	@Autowired 
	ITieuThuyetService iTieuThuyetService;
	
	@PostMapping("")
	public TieuThuyetDTO addLN(@RequestBody TieuThuyetDTO dto) {
		return iTieuThuyetService.save(dto);

}
	@PutMapping("/{id}")
	public TieuThuyetDTO updateLN(@RequestBody TieuThuyetDTO dto, @PathVariable("id") Long id) {
		dto.setMaSach(id);
		return iTieuThuyetService.save(dto);

}
	@DeleteMapping("/{id}")
	public void deleteLN(@PathVariable("id") Long id) {
		 iTieuThuyetService.delete(id);
}
	@GetMapping("/{loaiTT_ID}")
	public Page<TieuThuyetDTO> showLN(@PathVariable("loaiTT_ID") Long loaiTT_ID, 
			@RequestParam(name = "page",required = false) Integer pageNumber  ){
		if(pageNumber == null) pageNumber = 1;
		int pageSize =2;
		return iTieuThuyetService.getByLoaiTT(loaiTT_ID, pageNumber, pageSize);
	}
	@GetMapping("loaiTT/{loaiTT_ID}")
	public List<TieuThuyetDTO> showSP( @PathVariable("loaiTT_ID") Long loaiTT_ID ){
		
		return iTieuThuyetService.getByTT(loaiTT_ID);
	}
	
	
	@GetMapping("")
	public List<TieuThuyetDTO> showAllLN(@RequestParam(name = "page",required = false) Integer pageNumber  ){
		if(pageNumber == null) pageNumber = 1;
		int pageSize =100;
		return iTieuThuyetService.getAll(pageNumber, pageSize);
	}
	@GetMapping("search")
	public List<TieuThuyetDTO> search(@RequestParam(name = "keyword",required = false) String keyword ){
		return iTieuThuyetService.search(keyword);
	}
	@GetMapping("details/{id}")
	public TieuThuyetDTO show1LN( @PathVariable("id") Long id) {
		return iTieuThuyetService.getOneByID(id);
		}
	@GetMapping("selling")
	public List<Object[]> sellingproducts( ){
		
		return iTieuThuyetService.getTieuThuyetBanChay();
	}
	@GetMapping("byDay")
	public List<Object[]> StatisticsByDay( ){
		
		return iTieuThuyetService.getThongKeTheoNgay();
	}
	@GetMapping("byMonth")
	public List<Object[]> StatisticsByMonth( ){
		
		return iTieuThuyetService.getThongKeTheoThang();
	}
	@GetMapping("byYear")
	public List<Object[]> StatisticsByYear( ){
		
		return iTieuThuyetService.getThongKeTheoNam();
	}
}
