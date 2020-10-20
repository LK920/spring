package kr.co.livingmarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	@GetMapping("/member/signup")
	public String signup() {
		return "/member/signup";
	}
}
