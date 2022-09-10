/*
 * package com.example.ServerBook.api;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.example.ServerBook.dto.KhachHangDTO; import
 * com.example.ServerBook.dto.NhanVienDTO; import
 * com.example.ServerBook.dto.TieuThuyetDTO; import
 * com.example.ServerBook.service.INhanVienService;
 * 
 * @RestController
 * 
 * @RequestMapping("/staff") public class NhanVienAPI {
 * 
 * @Autowired INhanVienService nhanVienService;
 * 
 * @PostMapping("") public NhanVienDTO addStaff(@RequestBody NhanVienDTO dto) {
 * return nhanVienService.save(dto);
 * 
 * }
 * 
 * @PutMapping("/{id}") public NhanVienDTO updateStaff(@RequestBody NhanVienDTO
 * dto, @PathVariable("id") Long id) { dto.setMaNV(id); return
 * nhanVienService.save(dto);
 * 
 * }
 * 
 * @DeleteMapping("/{id}") public void deleteStaff(@PathVariable("id") Long id)
 * { nhanVienService.delete(id); }
 * 
 * @GetMapping("") public List<NhanVienDTO> showAllNV(@RequestParam(name =
 * "page",required = false) Integer pageNumber ){ if(pageNumber == null)
 * pageNumber = 1; int pageSize =10; return nhanVienService.getAll(pageNumber,
 * pageSize); }
 * 
 * @GetMapping("search") public List<NhanVienDTO> search(@RequestParam(name =
 * "nv",required = false) String nv ){ return nhanVienService.search(nv); }
 * 
 * @GetMapping("login") public NhanVienDTO login(@RequestParam(name =
 * "username",required = false) String username,
 * 
 * @RequestParam(name = "password",required = false) String password){ return
 * nhanVienService.login(username,password); }
 * 
 * @GetMapping("details/{id}") public NhanVienDTO show1NV( @PathVariable("id")
 * Long id) { return nhanVienService.getOneByMaNV(id); } }
 */