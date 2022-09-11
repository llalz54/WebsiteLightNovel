package com.example.ClientBook.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.ClientBook.model.DonHangDTO;
import com.example.ClientBook.model.KhachHangDTO;
import com.example.ClientBook.model.LoaiSPDTO;
import com.example.ClientBook.model.TieuThuyetDTO;
import com.example.ClientBook.service.ICTDHService;
import com.example.ClientBook.service.IDonHangService;
import com.example.ClientBook.service.IKhachHangService;
import com.example.ClientBook.service.INhanVienService;
import com.example.ClientBook.service.ITieuThuyetService;


@Controller
@RequestMapping("/admin/")
public class AdminController {
	@Autowired
	ITieuThuyetService tieuThuyetService;
	@Autowired
	IKhachHangService khachHangService;
	@Autowired
	INhanVienService nhanVienService;
	@Autowired
	IDonHangService donHangService;
	@Autowired
	ICTDHService ctdhService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("home")
	public String index() {
		return "admin/home";
	}
	

	@GetMapping("/admin-product")
	public String product(Model model , @RequestParam(name = "page", required = false) Integer pageNumber,
			HttpServletRequest request) {
		if (pageNumber == null) pageNumber = 1; 
		int pageSize = 8;
		  PagedListHolder pages = new PagedListHolder<>(tieuThuyetService.getAll());
		  pages.setPageSize(pageSize); 
		  
		  List list =(List) tieuThuyetService.getAll(); 
		  if (pages == null) {
			 } 
		  else 
		  { 
			  final int goToPage = pageNumber - 1; 
			  if (goToPage <= pages.getPageCount() && goToPage >= 0) 
			  { 
				  pages.setPage(goToPage); 
			  } 
		  }
		  
		  int current = pages.getPage() + 1; 
		  int begin = Math.max(1, current - list.size()); 
		  int end = Math.min(begin + 5, pages.getPageCount()); 
		  int totalPageCount = pages.getPageCount(); 
		  String baseUrl = "/admin/admin-product?page=";
		  model.addAttribute("beginIndex", begin); 
		  model.addAttribute("endIndex", end);
	      model.addAttribute("currentIndex", current);
		  model.addAttribute("totalPageCount", totalPageCount);
		  model.addAttribute("baseUrl", baseUrl); 
		  model.addAttribute("tieuthuyets", pages);
		return "admin/product";
	}
	@RequestMapping("/admin-product-add")
	public String addproduct(Model model ) {
		model.addAttribute("loaiTTs", tieuThuyetService.getTT());
		model.addAttribute("tieuthuyet", new TieuThuyetDTO());
		return "admin/addproduct";
	}
	
	
	@PostMapping("/admin-product-add")
	public String addProduct1( @ModelAttribute TieuThuyetDTO tieuthuyet,
			@RequestParam("image_link") MultipartFile imageLink) {
		
		tieuThuyetService.save(tieuthuyet, imageLink);
		
		return "redirect:admin-product";
	}
	
	@GetMapping("/admin-product-edit")
	public String editProduct(@RequestParam("maSach") Long maSach, Model model) {
		ResponseEntity<TieuThuyetDTO> responseEntity = restTemplate.getForEntity("/ln/details/"+maSach, TieuThuyetDTO.class);
		model.addAttribute("loaiTTs", tieuThuyetService.getTT());
		model.addAttribute("tieuthuyet", responseEntity.getBody());
		return "admin/addproduct";
	}
	@GetMapping("/admin-product-delete/{maSach}")
	public String deleteProduct(@PathVariable("maSach") Long maSach) {
		restTemplate.delete("/ln/"+maSach, maSach);
		return "redirect:/admin/admin-product";
	}

	@GetMapping("/admin-account")
	public String account(Model model ,@RequestParam(name = "page", required = false) Integer pageNumber,
			HttpServletRequest request) {
		/*
		 * model.addAttribute("khachhangs",khachHangService.getAllKH());
		 * model.addAttribute("nhanviens",nhanVienService.getAll());
		 */
		if (pageNumber == null) pageNumber = 1; 
		int pageSize = 10;
		  PagedListHolder pages = new PagedListHolder<>(khachHangService.getAllKH());
			/* PagedListHolder pages1 = new PagedListHolder<>(nhanVienService.getAll()); */
		  pages.setPageSize(pageSize); 
			/* pages1.setPageSize(pageSize); */
		  
		  List list =(List) khachHangService.getAllKH(); 
			/* List list1 =(List) nhanVienService.getAll(); */
		  if (pages == null) {
			 } 
		  else 
		  { 
			  final int goToPage = pageNumber - 1; 
			  if (goToPage <= pages.getPageCount() && goToPage >= 0) 
			  { 
				  pages.setPage(goToPage); 
			  } 
		  }
			/*
			 * if (pages1 == null) { } else { final int goToPage = pageNumber - 1; if
			 * (goToPage <= pages1.getPageCount() && goToPage >= 0) {
			 * pages1.setPage(goToPage); } }
			 */
		  
		  int current = pages.getPage() + 1; 
		  int begin = Math.max(1, current - list.size()); 
		  int end = Math.min(begin + 5, pages.getPageCount()); 
		  int totalPageCount = pages.getPageCount(); 
			/*
			 * int current1 = pages1.getPage() + 1; int begin1 = Math.max(1, current1 -
			 * list.size()); int end1 = Math.min(begin1 + 5, pages1.getPageCount()); int
			 * totalPageCount1 = pages1.getPageCount();
			 */
		  String baseUrl = "/admin/admin-account?page=";
		  model.addAttribute("beginIndex", begin); 
		  model.addAttribute("endIndex", end);
	      model.addAttribute("currentIndex", current);
		  model.addAttribute("totalPageCount", totalPageCount);
		  model.addAttribute("baseUrl", baseUrl); 
		  model.addAttribute("khachhangs", pages);
			/*
			 * model.addAttribute("beginIndex1", begin1); model.addAttribute("endIndex1",
			 * end1); model.addAttribute("currentIndex1", current1);
			 * model.addAttribute("totalPageCount1", totalPageCount1);
			 * model.addAttribute("nhanviens", pages1);
			 */
		return "admin/account";
	}
	@RequestMapping("/admin-account-add")
	public String addNV(Model model, @RequestParam(required = false) String message,
			@RequestParam(required = false) String message1) {
		
		model.addAttribute("khachhang", new KhachHangDTO());
		if (message != null) {
			model.addAttribute("message", "Tài khoản đã tồn tại");
		}
		if (message1 != null) {
			model.addAttribute("message1", "Tạo thành công");
		}

		return "admin/addaccount";
	}
	@PostMapping("/admin-account-add")
	public String addNV(Model model,@Valid @ModelAttribute("khachhang") KhachHangDTO khachhang ) {
		List<KhachHangDTO> kh = khachHangService.getAllKH();

		for (KhachHangDTO user : kh) {
			if (user.getEmail().equals(khachhang.getEmail())) {

				return "redirect:/admin/admin-account-add?message=invalid";
			}
		}
		khachhang.setRole_id((long)2);
		khachhang.setPass(bCryptPasswordEncoder.encode(khachhang.getPass()));
		khachHangService.save(khachhang);
		return "redirect:/admin/admin-account-add?message1=invalid";
	}
	@GetMapping("/admin-account-edit")
	public String editUser(Model model, HttpSession session, @RequestParam(name = "maNV", required = false) Long maNV,
			@RequestParam(required = false) String message) {
		KhachHangDTO user = (KhachHangDTO) session.getAttribute("user");
		KhachHangDTO dto = khachHangService.findByMaKH(user.getMaKH());
		if (message != null)
			model.addAttribute("message", "Đã đổi thông tin thành công");

		model.addAttribute("khachhang", dto);
		return "admin/editaccount";
	}

	@PostMapping("/admin-account-edit")
	public String editUser(HttpSession session, Model model, @Valid @ModelAttribute("khachhang") KhachHangDTO khachhang,
			BindingResult result) {
		if (result.hasErrors()) {
			return "admin/editaccount";
		}
		KhachHangDTO dto = (KhachHangDTO) session.getAttribute("user");
		khachhang.setMaKH((long) dto.getMaKH());
		khachhang.setEmail(dto.getEmail());
		khachhang.setRole_id(dto.getRole_id());
		khachhang.setPass(bCryptPasswordEncoder.encode(khachhang.getPass()));
		khachHangService.save(khachhang);
		return "redirect:admin-account-edit?message=invalid";
	}
	
	/*
	 * @PostMapping("admin-product-add") public String addProduct1(@ModelAttribute
	 * TieuThuyetDTO tieuthuyet,
	 * 
	 * @RequestParam("image_link") MultipartFile imageLink) {
	 * tieuThuyetService.save(tieuthuyet, imageLink);
	 * 
	 * return "redirect:admin-product"; }
	 */
	
	@GetMapping("/admin-category")
	public String category(Model model , @RequestParam(name = "page", required = false) Integer pageNumber,
			HttpServletRequest request,@RequestParam(required = false) String message) {
		 if(message!=null) 
				model.addAttribute("message", "Loại tiểu thuyết còn tiểu thuyết đang bán.Không thể xoá!");
		if (pageNumber == null) pageNumber = 1; 
		int pageSize = 10;
		  PagedListHolder pages = new PagedListHolder<>(tieuThuyetService.getTT());
		  pages.setPageSize(pageSize); 
		  
		  List list =(List) tieuThuyetService.getTT(); 
		  if (pages == null) {
			 } 
		  else 
		  { 
			  final int goToPage = pageNumber - 1; 
			  if (goToPage <= pages.getPageCount() && goToPage >= 0) 
			  { 
				  pages.setPage(goToPage); 
			  } 
		  }
		  
		  int current = pages.getPage() + 1; 
		  int begin = Math.max(1, current - list.size()); 
		  int end = Math.min(begin + 5, pages.getPageCount()); 
		  int totalPageCount = pages.getPageCount(); 
		  String baseUrl = "/admin/admin-category?page=";
		  model.addAttribute("beginIndex", begin); 
		  model.addAttribute("endIndex", end);
	      model.addAttribute("currentIndex", current);
		  model.addAttribute("totalPageCount", totalPageCount);
		  model.addAttribute("baseUrl", baseUrl); 
		  model.addAttribute("loaiTTs", pages);
		return "admin/category";
	}
	@RequestMapping("/admin-category-add")
	public String addcategory(Model model,@RequestParam(required = false) String message ) {
		model.addAttribute("loaiTT", new LoaiSPDTO());
		if(message!=null)
			model.addAttribute("message", "Loại tiểu thuyết đã tồn tại");
		return "admin/addcategory";
	}
	
	
	@PostMapping("/admin-category-add")
	public String addLoaiSP(@ModelAttribute LoaiSPDTO loaisp
			) {
		
		List<LoaiSPDTO> dto = tieuThuyetService.getTT();
		for (LoaiSPDTO sp: dto) {
			if(sp.getTenLoaiTT().equals(loaisp.getTenLoaiTT())) {
				
				return "redirect:admin-category-add?message=invalid";
			}
		
				
				
		}
			
		tieuThuyetService.save(loaisp);
		
		return "redirect:admin-category";
	}
	
	@GetMapping("/admin-category-edit")
	public String editLoaiSP(@RequestParam("loaiTT_ID") Long loaiTT_ID, Model model) {
		ResponseEntity<LoaiSPDTO> responseEntity = restTemplate.getForEntity("/categoris/details/"+loaiTT_ID, LoaiSPDTO.class);
		
		model.addAttribute("loaiTT", responseEntity.getBody());
		return "admin/addcategory";
	}
	
	  @GetMapping("/admin-category-delete") public String
	  deleteloaiTT(@RequestParam("loaiTT_ID") Long loaiTT_ID,Model model) {
		 
	  if (tieuThuyetService.getByTT(loaiTT_ID) != null )
	  {
		  return "redirect:admin-category?message=invalid";
		  	 
	  }
	  restTemplate.delete("/categoris/"+loaiTT_ID, loaiTT_ID);
	 
	  return "redirect:/admin/admin-category"; }
	 
	
	@GetMapping("/admin-order")
	public String order(Model model , @RequestParam(name = "page", required = false) Integer pageNumber,
			HttpServletRequest request) {
		if (pageNumber == null) pageNumber = 1; 
		int pageSize = 10;
		  PagedListHolder pages = new PagedListHolder<>(donHangService.getAll());
		  pages.setPageSize(pageSize); 
		  
		  List list =(List) donHangService.getAll(); 
		  if (pages == null) {
			 } 
		  else 
		  { 
			  final int goToPage = pageNumber - 1; 
			  if (goToPage <= pages.getPageCount() && goToPage >= 0) 
			  { 
				  pages.setPage(goToPage); 
			  } 
		  }
		  
		  int current = pages.getPage() + 1; 
		  int begin = Math.max(1, current - list.size()); 
		  int end = Math.min(begin + 5, pages.getPageCount()); 
		  int totalPageCount = pages.getPageCount(); 
		  String baseUrl = "/admin/admin-order?page=";
		  model.addAttribute("beginIndex", begin); 
		  model.addAttribute("endIndex", end);
	      model.addAttribute("currentIndex", current);
		  model.addAttribute("totalPageCount", totalPageCount);
		  model.addAttribute("baseUrl", baseUrl); 
		  model.addAttribute("donhangs", pages);
		return "admin/order";
	}
	@RequestMapping("/admin-order/details")
	public String orderdetails(Model model,@RequestParam(name ="IDDH", required = false) Long IDDH) {
		model.addAttribute("orderDetail", ctdhService.getByDonHang(IDDH));
		return "admin/orderdetail";
	}
	
	@RequestMapping("/admin-order/xacnhan")
	public String xacnhan(@RequestParam(name ="IDDH", required = false) Long IDDH, Model model) {
		DonHangDTO donHang = donHangService.getByIDDH(IDDH);
		
			donHang.setTrangthai(1);
			donHangService.save(donHang);
	
		return "redirect:/admin/admin-order";
	}
	@RequestMapping("/admin-order/thanhtoan")
	public String thanhtoan(@RequestParam(name ="IDDH", required = false) Long IDDH, Model model) {
	DonHangDTO donHang = donHangService.getByIDDH(IDDH);
		
			donHang.setTrangthai(-1);
			donHangService.save(donHang);
		
		return "redirect:/admin/admin-order";
	}
	@RequestMapping("/admin-order/huydon")
	public String huydon(@RequestParam(name ="IDDH", required = false) Long IDDH, Model model) {
		DonHangDTO donHang = donHangService.getByIDDH(IDDH);	
			donHang.setTrangthai(2);
			donHangService.HuyDon(donHang);
		return "redirect:/admin/admin-order";

}
	@RequestMapping("/reports")
	public ModelAndView reports(ModelMap model, @RequestParam("reports") Optional<Integer> reports) {
		int report = reports.orElse(0);
		if(report==0) {
			model.addAttribute("report", report);
			return new ModelAndView("forward:/admin/reports/best-selling-product", model);
			
		}
		else if (report == 1) {
			model.addAttribute("report", report);
			return new ModelAndView("forward:/admin/reports/statistical/day", model);
			
		} 
		else if (report == 2) {
			model.addAttribute("report", report);
			return new ModelAndView("forward:/admin/reports/statistical/month", model);
			
		} 
		else if (report == 3) {
			model.addAttribute("report", report);
			return new ModelAndView("forward:/admin/reports/statistical/year", model);
			
		} 
		model.addAttribute("report", report);
		return new ModelAndView("forward:/admin/reports/statistical", model);
	}
	

	

	@RequestMapping("/reports/best-selling-product")
	public ModelAndView bestSellProduct(ModelMap model) {
		List<Object[]> listBestSellingProduct = tieuThuyetService.getTieuThuyetBanChay();
		
		model.addAttribute("listBestSellingProduct", listBestSellingProduct);
		// set active front-end
		model.addAttribute("menuR", "menu");
		return new ModelAndView("/admin/best-selling-product");
	}

	
	
	/*
	 * @RequestMapping("/reports/statistical") public ModelAndView
	 * statistical(ModelMap model, @RequestParam("statisticalId") Optional<Integer>
	 * statisticalId) { int idStatistical = statisticalId.orElse(0);
	 * if(idStatistical==0) {
	 * 
	 * } else if(idStatistical==1) { model.addAttribute("statisticalId",
	 * idStatistical); return new
	 * ModelAndView("forward:/admin/reports/statistical/month", model); } else
	 * if(idStatistical==2) { model.addAttribute("statisticalId", idStatistical);
	 * return new ModelAndView("forward:/admin/reports/statistical/year", model); }
	 * model.addAttribute("statisticalId", idStatistical); // set active front-end
	 * model.addAttribute("menuR", "menu"); return new
	 * ModelAndView("/admin/statistical-day"); }
	 */
	
	@RequestMapping("/reports/statistical/day")
	public ModelAndView statisticalByDay(ModelMap model) {
		List<Object[]> statistical = tieuThuyetService.getThongKeTheoNgay();
		
		model.addAttribute("statistical", statistical);
		// set active front-end
		model.addAttribute("menuR", "menu");
		return new ModelAndView("/admin/statistical-day");
	}
	
	@RequestMapping("/reports/statistical/month")
	public ModelAndView statisticalByMonth(ModelMap model) {
		List<Object[]> statistical = tieuThuyetService.getThongKeTheoThang();
		
		model.addAttribute("statistical", statistical);
		// set active front-end
		model.addAttribute("menuR", "menu");
		return new ModelAndView("/admin/statistical-month");
	}
	
	@RequestMapping("/reports/statistical/year")
	public ModelAndView statisticalByYear(ModelMap model) {
		List<Object[]> statistical = tieuThuyetService.getThongKeTheoNam();
		
		model.addAttribute("statistical", statistical);
		// set active front-end
		model.addAttribute("menuR", "menu");
		return new ModelAndView("/admin/statistical-year");
	}

}
