package kr.co.ch07.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.ch07.service.UserService;
import kr.co.ch07.vo.UserVO;

@Controller
public class UserController {
	//client한테서 post로 받은 req객체를 프론트객체가 받아서 컨트롤러한테 줌
	@Inject
	private UserService service;
	
	//get으로 요청하면 실행
	@RequestMapping(value = "/user/register", method = RequestMethod.GET)
	public String register() {
		return "user/register";
	}
	
	//post으로 요청하면 실행, 들어올 테이블의 데이터에 대한 vo 객체를 생성한 뒤 입력만 해주면 자동으로 처리된다. 
	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public String registerProc(UserVO vo) {
		service.insertUser(vo);
		return "redirect:/user/list";
	}
	
	@RequestMapping(value ="/user/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<UserVO> users = service.selectUsers();
		
		//view에서 참조하기 위한 model 추가
		model.addAttribute("users", users);
		
		return "user/list";
	}
	@RequestMapping(value = "/user/delete", method=RequestMethod.GET)
	public String delete(@RequestParam String uid) {
		service.deleteUser(uid);
		return "redirect:/user/list";
	}
	
	@RequestMapping(value = "/user/select", method = RequestMethod.GET)
	public String select(@RequestParam String uid, Model model) {
		UserVO vo =  service.selectUser(uid);
		model.addAttribute("user",vo);
		return "user/update";
	}
	
	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public String update(UserVO vo) {
		service.updateUser(vo);
		
		return "redirect:/user/list";
	}

}
