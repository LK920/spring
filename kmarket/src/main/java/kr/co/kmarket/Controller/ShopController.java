package kr.co.kmarket.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.persistence.ShopRepo;
import kr.co.kmarket.service.ShopService;
import kr.co.kmarket.vo.CartTotalInfoVo;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.MemberVo;
import kr.co.kmarket.vo.ProductCartVo;
import kr.co.kmarket.vo.ProductsVo;
import kr.co.kmarket.vo.ResultVo;

@Controller
public class ShopController {
	
	@Autowired
	private ShopService service;
	
	@GetMapping("/shop/search")
	public String search() {
		return "/shop/search";
	}
	
	@GetMapping("/shop/list")
	public String list(int cate1, int cate2, int sort, Model model, HttpSession sess) {
		
		List<ProductsVo> items = service.selectShop(cate1, cate2, sort);
		service.setTitles(sess, cate1, cate2);
		String[] tits = service.getTitles(sess);
		
		model.addAttribute("tit1", tits[0]);
		model.addAttribute("tit2", tits[1]);
		model.addAttribute("cate1", cate1);
		model.addAttribute("cate2", cate2);
		model.addAttribute("items", items);
		
		return "/shop/list";
	}
	
	@GetMapping("/shop/view")
	public String view(int code, Model model, HttpSession sess) {
		
		//세션명의 컬럼 명이 member 왜냐하면 로그인 할때 세션에 member로 저장해둠
		MemberVo member = (MemberVo) sess.getAttribute("member");
		
		ProductsVo vo = service.selectProduct(code);
		String[] tits = service.getTitles(sess);
		
		model.addAttribute("tit1", tits[0]);
		model.addAttribute("tit2", tits[1]);
		model.addAttribute("product", vo);
		model.addAttribute("member", member);
		
		return "/shop/view";
	}
	
	@GetMapping("/shop/cart")
	public String cart(Model model, HttpSession sess) {
		
		MemberVo member = (MemberVo) sess.getAttribute("member");
		
		if(member != null) {
			List<ProductCartVo> items =  service.selectCart(member.getUid());
			model.addAttribute("items", items);
			
			//전체합계에 출력될 데이터
			CartTotalInfoVo totalInfo = service.cartTotalInfo(items);
			
			model.addAttribute("totalInfo", totalInfo);
			
			return "/shop/cart";
		}else {
			return "redirect:/member/login?success=cart";
		}
		
	}
	@ResponseBody
	@PostMapping("/shop/cart")
	public ResultVo cart(ProductCartVo vo) {
		
		int result = service.insertCart(vo);
		return new ResultVo(result);
	}
	
	@ResponseBody
	@PostMapping("/shop/cartDel")
	public int cartDel(int[] codes, String uid) {
		
		int result = service.deleteCart(uid, codes); 
		
		return result;
		
	}
	
	@GetMapping("/shop/order")
	public String order() {
		return "/shop/order";
	}
	
	@GetMapping("/shop/order-complete")
	public String orderComplete() {
		return "/shop/order-complete";
	}
}
