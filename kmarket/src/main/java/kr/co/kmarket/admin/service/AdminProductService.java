package kr.co.kmarket.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.admin.dao.AdminProductDAO;
import kr.co.kmarket.vo.ProductsVo;

@Service
public class AdminProductService {
	@Autowired
	private AdminProductDAO dao;
	
	public void insertProduct(ProductsVo vo) {
		dao.insertProduct(vo);
	} 
	public ProductsVo selectProduct() {
		return dao.selectProduct();
	}
	public List<ProductsVo> selectProducts(){
		return dao.selectProducts();
	}
	
	public void updateProduct() {
		dao.updateProduct();
	}
	public void deleteProduct() {
		dao.deleteProduct();
	}
}
