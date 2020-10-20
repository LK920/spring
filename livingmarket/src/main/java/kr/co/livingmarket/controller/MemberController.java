package kr.co.livingmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.livingmarket.persistence.TermsRepo;
import kr.co.livingmarket.vo.TermsVo;

@Controller
public class MemberController {
	@Autowired
	private TermsRepo termsRepo;
	
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	@GetMapping("/member/signup")
	public String signup(Model model) {
		TermsVo vo = termsRepo.findById(0).get();
		model.addAttribute(vo);
		
		return "/member/signup";
	}
}
