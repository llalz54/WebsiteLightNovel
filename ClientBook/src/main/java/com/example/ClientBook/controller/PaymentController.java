package com.example.ClientBook.controller;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.example.ClientBook.config.PaypalPaymentIntent;
import com.example.ClientBook.config.PaypalPaymentMethod;
import com.example.ClientBook.model.CartDTO;
import com.example.ClientBook.model.DonHangDTO;
import com.example.ClientBook.model.KhachHangDTO;
import com.example.ClientBook.service.ICartService;
import com.example.ClientBook.service.IDonHangService;
import com.example.ClientBook.service.ITieuThuyetService;
import com.example.ClientBook.service.impl.*;
import com.example.ClientBook.utils.*;
@Controller
public class PaymentController {
	public static final String URL_PAYPAL_SUCCESS = "pay/success";
	public static final String URL_PAYPAL_CANCEL = "./cart";
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private PaypalService paypalService;
	@Autowired
	private ICartService cartService;
	@Autowired
	private ITieuThuyetService tieuThuyetService;
	@Autowired
	IDonHangService donHangService;
	
	
	@GetMapping("/")
	public String index(Model model, HttpSession session){
		model.addAttribute("loaiTTs", tieuThuyetService.getTT());
		model.addAttribute("donhang", new DonHangDTO());
		return "user/orderOnline";
	}
	@PostMapping("/")
	public String pay(HttpServletRequest request , HttpSession session ,@Valid @ModelAttribute("donhang") DonHangDTO donHang) throws PayPalRESTException{
		String cancelUrl = Utils.getBaseURL(request) + "/" + URL_PAYPAL_CANCEL;
		String successUrl = Utils.getBaseURL(request) + "/" + URL_PAYPAL_SUCCESS;
		KhachHangDTO kh = (KhachHangDTO) session.getAttribute("user");
		List<CartDTO> carts = cartService.getCartByUser(kh.getMaKH());
		donHang.setMaKH(kh.getMaKH());
		donHang.setNgayLap(new Date());
		donHang.setTongGia(cartService.getAmount(carts));
		donHang.setTrangthai(3);
		donHangService.save(donHang);
			Payment payment = paypalService.createPayment(
					cartService.getAmount(carts) ,
					"USD",
					PaypalPaymentMethod.paypal,
					PaypalPaymentIntent.sale,
					donHang.getGhiChu(),
					cancelUrl,
					successUrl);
			for(Links links : payment.getLinks()){
				if(links.getRel().equals("approval_url")){
					return "redirect:" + links.getHref();
				}
			}
			
			
		return "redirect:/";
	}
	@GetMapping(URL_PAYPAL_CANCEL)
	public String cancelPay(){
		return "user/cart";
	}
	@GetMapping(URL_PAYPAL_SUCCESS)
	public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId){
		try {
			Payment payment = paypalService.executePayment(paymentId, payerId);
			if(payment.getState().equals("approved")){
				return "user/success";
			}
		} catch (PayPalRESTException e) {
			log.error(e.getMessage());
		}
		return "redirect:/";
	}
}