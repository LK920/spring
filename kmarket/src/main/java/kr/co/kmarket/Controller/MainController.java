package kr.co.kmarket.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.persistence.category1Repo;
import kr.co.kmarket.vo.Category1Vo;

@Controller
public class MainController {
	
	@Autowired
	private category1Repo cate1Repo;
	
	@GetMapping(value={"/", "/index"})
	public String index() {
		return "/index";
	}	
	
	@ResponseBody
	@GetMapping("/cate1")
	public List<Category1Vo> getCate1() {
		return  cate1Repo.findAll();
	}
}
