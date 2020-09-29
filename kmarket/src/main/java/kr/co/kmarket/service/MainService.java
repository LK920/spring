package kr.co.kmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.MainDAO;
import kr.co.kmarket.vo.Category1Vo;
import kr.co.kmarket.vo.ProductsVo;

@Service
public class MainService {
	
	@Autowired
	private MainDAO dao;
	
	public List<Category1Vo> selectCate1(){
		return dao.selectCate1();
	}
	public List<ProductsVo> selectHitProduct(){
		return dao.selectHitProduct();
	}
	public List<ProductsVo> selectBestProduct(){
		return dao.selectBestProduct();
	}
	public List<ProductsVo> selectNewProduct(){
		return dao.selectNewProduct();
	}
	public List<ProductsVo> selectRecProduct(){
		return dao.selectRecProduct();
	}
}
