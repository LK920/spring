package kr.co.livingmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.livingmarket.service.MemberService;
import kr.co.livingmarket.vo.ResultVo;

@RestController
public class MemberRestController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/member/checkuid")
	public ResultVo checkUid(String uid) {
		return service.checkUid(uid);
	}
	@GetMapping("/member/checkemail")
	public ResultVo checkEmail(String email) {
		return service.checkEmail(email);
	}
	@GetMapping("/member/checkHp")
	public ResultVo checkHp(String hp) {
		return service.checkHp(hp);
	}
}
