package kr.co.kmarket.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.service.MainService;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.Category1Vo;
import kr.co.kmarket.vo.ProductsVo;

@Controller
public class MainController {
	
	@Autowired
	private MainService service;
	
	@GetMapping(value={"/", "/index"})
	public String index(Model model, HttpSession sess) {
		
		List<CategoriesVo> cate1List =  service.selectCategories();
		List<ProductsVo> bestList =  service.selectBestProduct();
		List<ProductsVo> hitList =  service.selectHitProduct();
		List<ProductsVo> newList =  service.selectNewProduct();
				
		sess.setAttribute("cate1List", cate1List);
		//System.out.println("길이 1 : "+cateList.size());
		//System.out.println("길이 2 : "+cateList.get(0).getCate2List().size());
		
		model.addAttribute("bestList", bestList);
		model.addAttribute("hitList", hitList);
		model.addAttribute("newList", newList);
		
		return "/index";
	}
	
	@ResponseBody
	@GetMapping("/main/recommend")
	public List<ProductsVo> recommend() {
		return service.selectRecProduct();
	}
	
	@ResponseBody
	@GetMapping("/main/newItems")
	public List<ProductsVo> newItems() {
		return service.selectNewProduct();
	}
	@ResponseBody
	@GetMapping("/main/discountItem")
	public List<ProductsVo> discountItem() {
		return service.selectDisProduct();
	}
	
}
