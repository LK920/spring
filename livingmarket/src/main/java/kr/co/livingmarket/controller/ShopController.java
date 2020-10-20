package kr.co.livingmarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {
	
	@GetMapping("/shop/list")
	public String list() {
		return "/shop/list";
	}
	@GetMapping("/shop/cart")
	public String cart() {
		return "/shop/cart";
	}
	@GetMapping("/shop/view")
	public String view() {
		return "/shop/view";
	}
	@GetMapping("/shop/order")
	public String order() {
		return "/shop/order";
	}
	@GetMapping("/shop/order-complete")
	public String ordered() {
		return "/shop/order-complete";
	}
}
