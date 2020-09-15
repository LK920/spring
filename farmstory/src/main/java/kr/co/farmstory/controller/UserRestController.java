package kr.co.farmstory.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.farmstory.service.UserService;


//@responsebody + @controller = @restcontroller  <-- 무조건 문자열과 json을 리턴하는 컨트롤러
@RestController 
public class UserRestController {
	
	@Inject
	private UserService service;
	
	
	@GetMapping("/user/checkUid")
	public String checkUid(String uid) {
		
		int result = service.selectUserCount(uid);
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
	}
	
	@GetMapping("/user/checkNick")
	public String checkNick() {
		return null;
	}
	
	@GetMapping("/user/checkEmail")
	public String checkEmail() {
		return null;
	}
	
	@GetMapping("/user/checkHp")
	public String checkHp() {
		return null;
	}

}
