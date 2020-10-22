package kr.co.livingmarket.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.livingmarket.persistence.MemberRepo;
import kr.co.livingmarket.persistence.TermsRepo;
import kr.co.livingmarket.service.MemberService;
import kr.co.livingmarket.vo.MemberVo;
import kr.co.livingmarket.vo.ResultVo;
import kr.co.livingmarket.vo.TermsVo;

@Controller
public class MemberController {
	
	@Autowired
	private TermsRepo termsRepo;
	
	@Autowired
	private MemberRepo memberRepo;
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/member/login")
	public String login(String success, Model model) {
		model.addAttribute("success", success);
		return "/member/login";
	}
	@PostMapping("/member/login")
	public String login(MemberVo vo , HttpSession sess) {
		
		MemberVo member = service.selectMember(vo);
		if(member != null) {
			sess.setAttribute("member", member);
			return "redirect:/";
		}else {
			return "redirect:/member/login?success=fail";
		}
	}
	@GetMapping("/member/logout")
	public String logout(HttpSession sess) {
		sess.invalidate();
		return "redirect:/";
	}
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	@PostMapping("/member/register")
	public String register(MemberVo vo, HttpServletRequest req) {
		vo.setIp(req.getRemoteAddr());
		vo.setRdate(LocalDateTime.now().toString());
		service.registerMember(vo);
		return "redirect:/member/login";
	}
	
	@GetMapping("/member/signup")
	public String signup(Model model) {
		TermsVo vo = termsRepo.findById(0).get();
		model.addAttribute(vo);
		
		return "/member/signup";
	}
	
}
