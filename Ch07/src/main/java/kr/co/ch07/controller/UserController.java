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
	//client���׼� post�� ���� req��ü�� ����Ʈ��ü�� �޾Ƽ� ��Ʈ�ѷ����� ��
	@Inject
	private UserService service;
	
	//get���� ��û�ϸ� ����
	@RequestMapping(value = "/user/register", method = RequestMethod.GET)
	public String register() {
		return "user/register";
	}
	
	//post���� ��û�ϸ� ����, ���� ���̺��� �����Ϳ� ���� vo ��ü�� ������ �� �Է¸� ���ָ� �ڵ����� ó���ȴ�. 
	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public String registerProc(UserVO vo) {
		service.insertUser(vo);
		return "redirect:/user/list";
	}
	
	@RequestMapping(value ="/user/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<UserVO> users = service.selectUsers();
		
		//view���� �����ϱ� ���� model �߰�
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
