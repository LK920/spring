package kr.co.kmarket.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kmarket.persistence.TermsRepo;
import kr.co.kmarket.vo.TermsVo;

@Controller
public class MemberController {
	
	@Autowired
	private TermsRepo repo;

	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	
	@GetMapping("/member/join")
	public String join() {
		return "/member/join";
	}
	
	@GetMapping("/member/signup")
	public String signup(String type, Model model) {
		
		TermsVo vo = repo.findById(0).get();
		
		model.addAttribute("type", type);
		model.addAttribute(vo);
		
		return "/member/signup";
	}
	
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	
	@GetMapping("/member/register-seller")
	public String registerSeller() {
		return "/member/register-seller";
	}
	
}
