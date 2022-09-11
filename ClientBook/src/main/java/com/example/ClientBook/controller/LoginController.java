package com.example.ClientBook.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javax.security.auth.login.AccountException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.ClientBook.model.KhachHangDTO;
import com.example.ClientBook.service.IKhachHangService;

@Controller
public class LoginController {
	@Autowired
	private IKhachHangService khachHangService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@RequestMapping("login")
	public String login(Model model,HttpSession session, @RequestParam(required = false) String message) {
		session.setAttribute("user", null);
		model.addAttribute("khachhang", new KhachHangDTO());
		if(message!=null)
			model.addAttribute("message", "Tài khoản hoặc mật khẩu không đúng");
		return "user/login";
		
	}
	@PostMapping("login")
	public String login(Model model,  @ModelAttribute("khachhang") KhachHangDTO khachhang, HttpSession session,BindingResult result) {
	
		List<KhachHangDTO> kh= khachHangService.getAllKH();
		
		for (KhachHangDTO user: kh) {
			if((user.getEmail().equals(khachhang.getEmail()) && bCryptPasswordEncoder.matches(khachhang.getPass(), user.getPass()) && user.getRole_id() ==1)
				||(user.getEmail().equals(khachhang.getEmail()) && khachhang.getPass().equals(user.getPass()) && user.getRole_id() ==1))  {
				session.setAttribute("user", user);
				return "redirect:home";
			}
			else if((user.getEmail().equals(khachhang.getEmail()) && bCryptPasswordEncoder.matches(khachhang.getPass(), user.getPass()) && user.getRole_id() ==2)
					||(user.getEmail().equals(khachhang.getEmail()) && khachhang.getPass().equals(user.getPass()) && user.getRole_id() ==2))  {
					session.setAttribute("user", user);
					return "redirect:admin/home";
				}
			
		}
		
		return "redirect:login?message=invalid";
	}
	
	
	


}
