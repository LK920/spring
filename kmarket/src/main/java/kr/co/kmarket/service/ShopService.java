package kr.co.kmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.ShopDAO;
import kr.co.kmarket.vo.ProductsVo;

@Service
public class ShopService {
	@Autowired
	private ShopDAO dao;
	
	public List<ProductsVo> selectShop(int cate1, int cate2, int sort) {
		return dao.selectShop(cate1, cate2, sort);
	}

}
