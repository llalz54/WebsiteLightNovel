package com.example.ClientBook.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.http.ResponseEntity;

import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.ClientBook.model.CTDHDTO;
import com.example.ClientBook.model.CartDTO;
import com.example.ClientBook.model.DonHangDTO;
import com.example.ClientBook.model.KhachHangDTO;
import com.example.ClientBook.model.MailInfo;
import com.example.ClientBook.model.TieuThuyetDTO;
import com.example.ClientBook.service.ICTDHService;
import com.example.ClientBook.service.ICartService;
import com.example.ClientBook.service.IDonHangService;
import com.example.ClientBook.service.IKhachHangService;
import com.example.ClientBook.service.ITieuThuyetService;

import com.example.ClientBook.service.impl.MailService;

@Controller
public class HomeController {
	public static String body;
	public static String email;

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Autowired
	ITieuThuyetService tieuThuyetService;
	@Autowired
	IKhachHangService khachHangService;
	@Autowired
	ICartService cartService;
	@Autowired
	IDonHangService donHangService;
	@Autowired
	ICTDHService ctdhService;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private MailService mailService;
	@Autowired
	HttpSession session;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping("/home")
	public String index(Model model, @RequestParam(name = "page", required = false) Integer pageNumber,
			HttpServletRequest request) {
		model.addAttribute("loaiTTs", tieuThuyetService.getTT());

		if (pageNumber == null)
			pageNumber = 1;
		int pageSize = 4;
		PagedListHolder pages = new PagedListHolder<>(tieuThuyetService.getAll());
		pages.setPageSize(pageSize);

		List list = (List) tieuThuyetService.getAll();
		if (pages == null) {
		} else {
			final int goToPage = pageNumber - 1;
			if (goToPage <= pages.getPageCount() && goToPage >= 0) {
				pages.setPage(goToPage);
			}
		}

		int current = pages.getPage() + 1;
		int begin = Math.max(1, current - list.size());
		int end = Math.min(begin + 5, pages.getPageCount());
		int totalPageCount = pages.getPageCount();
		String baseUrl = "/home?page=";
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("baseUrl", baseUrl);
		model.addAttribute("tieuthuyets", pages);

		return "user/index";
	}

	@RequestMapping("/changepass-edit")
	public String changePass(Model model, HttpSession session, @RequestParam(name = "maKH", required = false) Long maKH,
			@RequestParam(required = false) String message, @RequestParam(required = false) String message1,
			@RequestParam(required = false) String message2) {
		model.addAttribute("loaiTTs", tieuThuyetService.getTT());
		KhachHangDTO user = (KhachHangDTO) session.getAttribute("user");
		KhachHangDTO dto = khachHangService.findByMaKH(user.getMaKH());
		model.addAttribute("khachhang", new KhachHangDTO());
		if (message != null) {
			model.addAttribute("message", "Đã đổi mật khẩu thành công");
		}
		if (message1 != null) {
			model.addAttribute("message", "Mật khẩu xác nhận không giống mật khẩu mới");
		}
		if (message2 != null) {
			model.addAttribute("message", "Sai mật khẩu cũ");
		}
		return "user/changepass";

	}

	@PostMapping("/changepass-edit")
	public String changePass(Model model, @ModelAttribute("khachhang") KhachHangDTO khachHang, HttpSession session) {
//		ResponseEntity<KhachHangDTO> responseEntity = restTemplate.getForEntity("/customer/"+maKH, KhachHangDTO.class);
//		model.addAttribute("loaiTTs", tieuThuyetService.getTT());
//		model.addAttribute(responseEntity)

		model.addAttribute("loaiTTs", tieuThuyetService.getTT());
		KhachHangDTO dto = (KhachHangDTO) session.getAttribute("user");

		if ((bCryptPasswordEncoder.matches(khachHang.getPass(), dto.getPass())
				&& (khachHang.getPass2().equals(khachHang.getConfirmpass())))
				|| (khachHang.getPass().equals(dto.getPass())
						&& (khachHang.getPass2().equals(khachHang.getConfirmpass())))) {
			khachHang.setMaKH((long) dto.getMaKH());
			khachHang.setEmail(dto.getEmail());
			khachHang.setDiaChi(dto.getDiaChi());
			khachHang.setSdt(dto.getSdt());
			khachHang.setTenKH(dto.getTenKH());
			khachHang.setRole_id(dto.getRole_id());
			khachHang.setPass(bCryptPasswordEncoder.encode(khachHang.getPass2()));
			khachHangService.save(khachHang);
			return "redirect:changepass-edit?message=invalid";
		} else if (bCryptPasswordEncoder.matches(khachHang.getPass(), dto.getPass())
				&& (khachHang.getPass2().equals(khachHang.getConfirmpass())) == false) {

			return "redirect:changepass-edit?message1=invalid";
		} else if (bCryptPasswordEncoder.matches(khachHang.getPass(), dto.getPass()) == false) {

			return "redirect:changepass-edit?message2=invalid";
		}

		return "redirect:changepass-edit";
	}

	@RequestMapping("/sendEmail")
	public String contact(Model model) {
		model.addAttribute("loaiTTs", tieuThuyetService.getTT());
		return "user/contact";
	}

	@RequestMapping("/order")
	public String order(Model model, HttpSession session) {
		model.addAttribute("loaiTTs", tieuThuyetService.getTT());
		KhachHangDTO dto = (KhachHangDTO) session.getAttribute("user");
		model.addAttribute("order", donHangService.getByUser(dto.getMaKH()));
		return "user/about";
	}

	@RequestMapping("/order/details")
	public String orderdetails(Model model, @RequestParam("IDDH") Long IDDH) {
		model.addAttribute("loaiTTs", tieuThuyetService.getTT());
		model.addAttribute("orderDetail", ctdhService.getByDonHang(IDDH));
		return "user/orderdetail";
	}

	@RequestMapping("/order-add")
	public String getorderadd(Model model, HttpSession session) {

		model.addAttribute("loaiTTs", tieuThuyetService.getTT());
		model.addAttribute("donhang", new DonHangDTO());

		return "user/order";
	}

	@PostMapping("/order-add")
	public String orderadd(@Valid @ModelAttribute("donhang") DonHangDTO donHang, Model model, HttpSession session,
			BindingResult result) {
		if (result.hasErrors()) {

			return "user/order";
		}

		KhachHangDTO kh = (KhachHangDTO) session.getAttribute("user");
		List<CartDTO> carts = cartService.getCartByUser(kh.getMaKH());
		donHang.setMaKH(kh.getMaKH());
		donHang.setNgayLap(new Date());
		donHang.setTongGia(cartService.getAmount(carts));
		System.out.println(donHang.getTongGia());
		donHang.setTrangthai(0);

		return donHangService.save(donHang);
	}

	@RequestMapping("/order/huydon")
	public String huydon(@RequestParam(name = "IDDH", required = false) Long IDDH, Model model) {
		DonHangDTO donHang = donHangService.getByIDDH(IDDH);
		donHang.setTrangthai(2);
		donHangService.HuyDon(donHang);
		return "redirect:/order";
	}

	@GetMapping("/product")
	public String getProductByLoaiTT(Model model, @RequestParam(name = "loaiTT_ID", required = false) Long loaiTT_ID,
			@RequestParam(name = "page", required = false) Integer page) {
		if (page == null)
			page = 1;
		int pageSize = 1;
//		List<TieuThuyetDTO> tieuThuyetDTOs = tieuThuyetService.findByLoaiTT(loaiTT_ID, page);
		Map<String, Object> tieuThuyetDTOs = tieuThuyetService.findByLoaiTT(loaiTT_ID, page);
		List<TieuThuyetDTO> tieuThuyets =(List<TieuThuyetDTO>) tieuThuyetDTOs.get("content");
//		PagedListHolder pages = new PagedListHolder<>(tieuThuyetDTOs);
//		pages.setPageSize(pageSize);

//		if (pages == null) {
//		} else {
//			final int goToPage = (int) (page - 1);
//			if (goToPage <= pages.getPageCount() && goToPage >= 0) {
//				pages.setPage(goToPage);
//			}
//		}
		int totalPage = (int) tieuThuyetDTOs.get("totalPages");
		int current = page;
		int begin = Math.max(1, current - tieuThuyets.size());
		int end = Math.min(begin + 5, totalPage);
//		int totalPageCount = pages.getPageCount();
		System.out.println(begin);
		String baseUrl = "/product?loaiTT_ID="+loaiTT_ID+"&page=";
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("totalPageCount", totalPage);
		model.addAttribute("baseUrl", baseUrl);
		model.addAttribute("tieuthuyets", tieuThuyets);
		model.addAttribute("loaiTTs", tieuThuyetService.getTT());
		return "user/product";
	}

	@GetMapping("/product/item")
	public String CTSP(Model model, @RequestParam(name = "maSach", required = false) Long maSach) {
		model.addAttribute("tt", tieuThuyetService.getByIDSP(maSach));
		model.addAttribute("loaiTTs", tieuThuyetService.getTT());
		return "user/item";
	}

	@GetMapping("search-product")
	public String search(Model model, @RequestParam(name = "keyword", required = false) String keyword) {
		model.addAttribute("loaiTTs", tieuThuyetService.getTT());
		List<TieuThuyetDTO> list = null;
		if (StringUtils.hasText(keyword)) {
			list = tieuThuyetService.search(keyword);
		}

		model.addAttribute("tieuthuyets", list);

		return "user/search";
	}

	@RequestMapping("/register")
	public String register(Model model, @RequestParam(required = false) String message,
			@RequestParam(required = false) String message1) {
		model.addAttribute("khachhang", new KhachHangDTO());
		if (message != null) {
			model.addAttribute("message", "Tài khoản đã tồn tại");
		}
		if (message1 != null) {
			model.addAttribute("message1", "Đăng kí thành công");
		}

		return "/user/register";
	}

	@PostMapping("/register")
	public String addCustomer(@ModelAttribute("khachhang") KhachHangDTO khachhang, Model model) {

		List<KhachHangDTO> kh = khachHangService.getAllKH();

		for (KhachHangDTO user : kh) {
			if (user.getEmail().equals(khachhang.getEmail())) {

				return "redirect:register?message=invalid";
			}
		}
		khachhang.setRole_id((long)1);
		khachhang.setPass(bCryptPasswordEncoder.encode(khachhang.getPass()));
		khachHangService.save(khachhang);
		return "redirect:register?message1=invalid";

	}

	@GetMapping("cart")
	public String getCart(Model model, HttpSession session, @RequestParam(required = false) String message) {
		model.addAttribute("loaiTTs", tieuThuyetService.getTT());
		KhachHangDTO user = (KhachHangDTO) session.getAttribute("user");
		List<CartDTO> cartDTO = cartService.getCartByUser(user.getMaKH());
		if (message != null)
			model.addAttribute("message", "Sản phẩm đã tồn tại");

		model.addAttribute("carts", cartDTO);
		double amount = cartService.getAmount(cartDTO);
		model.addAttribute("amount", amount);
		// model.addAttribute("totalCartItems", cartService.getCount());
		return "user/cart";
	}

	@RequestMapping("/cart/update")
	public String updateCart(@RequestParam("id") Long id, @RequestParam("soLuong") int soLuong, ModelMap model,
			HttpSession session) {
		CartDTO dto = new CartDTO();
		if (soLuong > 0) {
			dto.setId(id);
			dto.setSoLuong(soLuong);
			cartService.addtoCart(dto);
		} else {
			deleteProduct(id);
		}

		model.addAttribute("totalCartItems", cartService.getCount());

		return "redirect:/cart";
	}

	@PostMapping("cart")
	public String addCart(HttpSession session, Model model,
			@RequestParam(name = "maSach", required = false) Long maSach) {
		model.addAttribute("loaiTTs", tieuThuyetService.getTT());
		System.out.println("batdau");
		KhachHangDTO user = new KhachHangDTO();
		TieuThuyetDTO tieuThuyet = new TieuThuyetDTO();
		user = (KhachHangDTO) session.getAttribute("user");
		tieuThuyet = (TieuThuyetDTO) model.getAttribute("tieuthuyets");
		System.out.println("aaa" + user.getMaKH() + " " + maSach);
		List<CartDTO> cartDTO = cartService.getCartByUser(user.getMaKH());
		CartDTO cart = new CartDTO();
		cart.setMaKH((long) user.getMaKH());
		cart.setMaSach(maSach);
		cart.setSoLuong(1);
		for (CartDTO cartDTO2 : cartDTO) {
			if (maSach.equals(cartDTO2.getMaSach())) {
				return "redirect:cart?message=invalid";
			}
		}
		cartService.addtoCart(cart);
		// model.addAttribute("totalCartItems", cartService.getCount());
		return "redirect:cart";
	}

	@GetMapping("/cart-delete/{id}")
	public String deleteProduct(@PathVariable("id") Long id) {
		restTemplate.delete("/cart/" + id, id);
		return "redirect:/cart";
	}

	@GetMapping("/user-edit")
	public String editUser(Model model, HttpSession session, @RequestParam(name = "maKH", required = false) Long maKH,
			@RequestParam(required = false) String message) {
		model.addAttribute("loaiTTs", tieuThuyetService.getTT());
		KhachHangDTO user = (KhachHangDTO) session.getAttribute("user");
		KhachHangDTO dto = khachHangService.findByMaKH(user.getMaKH());
		if (message != null)
			model.addAttribute("message", "Đã đổi thông tin thành công");

		model.addAttribute("khachhang", dto);
		return "user/infor";
	}

	@PostMapping("/user-edit")
	public String editUser(HttpSession session, Model model, @Valid @ModelAttribute("khachhang") KhachHangDTO khachhang,
			BindingResult result) {
		if (result.hasErrors()) {
			return "user/infor";
		}
		model.addAttribute("loaiTTs", tieuThuyetService.getTT());
		KhachHangDTO dto = (KhachHangDTO) session.getAttribute("user");
		khachhang.setMaKH((long) dto.getMaKH());
		khachhang.setEmail(dto.getEmail());
		khachhang.setPass(dto.getPass());
		khachhang.setRole_id(dto.getRole_id());
		khachHangService.save(khachhang);
		return "redirect:user-edit?message=invalid";
	}

	@RequestMapping("/forgotPassword")
	public String forget(Model model, @RequestParam(required = false) String message,
			@RequestParam(required = false) String message1, @RequestParam(required = false) String message2) {
		model.addAttribute("khachhang", new KhachHangDTO());
		if (message != null) {
			model.addAttribute("message", "Lấy lại mật khẩu thành công!");
		}
		if (message1 != null) {
			model.addAttribute("message1", "Lấy lại mật khẩu thất bại!");
		}
		if (message2 != null) {
			model.addAttribute("message2", "Thông tin không hợp lệ, mời bạn xem lại thông tin và email!");
		}
		return "user/forgotPassword";
	}

	@PostMapping("/forgotPassword")
	public String forget(ModelMap model, @ModelAttribute("khachhang") KhachHangDTO khachhang) {

		List<KhachHangDTO> kh = khachHangService.getAllKH();
		for (KhachHangDTO khachHangDTO : kh) {
			if (khachHangDTO.getEmail().equals(khachhang.getEmail())) {
				int code = (int) Math.floor(((Math.random() * 8999999) + 1000000));
				String kq = String.valueOf(code);
				khachHangDTO.setPass(kq);
				khachHangService.save(khachHangDTO);
				email = khachHangDTO.getEmail();
				body = "Mật khẩu mới của bạn là:\r\n" + khachHangDTO.getPass() + "\r\n" + "Xin cảm ơn!\r\n";
				;
				mailService.sendSimpleEmail(email, body);
				return "redirect:forgotPassword?message=invalid";
			}
		}

		return "redirect:forgotPassword?message2=invalid";
	}

}
