package kr.co.kmarket.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.ShopDAO;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.ProductCartVo;
import kr.co.kmarket.vo.ProductsVo;

@Service
public class ShopService {
	@Autowired
	private ShopDAO dao;
	
	public List<ProductsVo> selectShop(int cate1, int cate2, int sort) {
		return dao.selectShop(cate1, cate2, sort);
	}
	
	public ProductsVo selectProduct(int code) {
		return dao.selectProduct(code);
	};
	
	public void setTitles(HttpSession sess, int cate1, int cate2) {
		
		List<CategoriesVo> categories =  (List<CategoriesVo>) sess.getAttribute("cate1List");
		
		String tit1 = categories.get(cate1-1).getTitle();
		String tit2 = categories.get(cate1-1).getCate2List().get(cate2-1).getTitle();
		
		sess.setAttribute("tit1", tit1);
		sess.setAttribute("tit2", tit2);
	}
	
	public String[] getTitles(HttpSession sess) {
		String tit1 = (String) sess.getAttribute("tit1");
		String tit2 = (String)sess.getAttribute("tit2");
		
		String tits[] = {tit1, tit2} ;
		
		return tits;
	}
	
	public int insertCart(ProductCartVo vo) {
		
		return dao.insertCart(vo);
		
	}
	public List<ProductCartVo> selectCart(String uid){
		return dao.selectCart(uid);
	};
	

}
