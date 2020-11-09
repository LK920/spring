package kr.co.kmarket.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.kmarket.vo.MemberVo;

@Controller
public class AdminMainController {
	
	@GetMapping(value={"/admin", "/admin/index"})
	public String index(HttpSession session, Model model) {
		
		MemberVo member =  (MemberVo) session.getAttribute("member");
		if(member != null && member.getType() ==2) {
			model.addAttribute("member", member);
			return "/admin/index";
		}else {
			return "redirect:/";
		}
	
	}
}
