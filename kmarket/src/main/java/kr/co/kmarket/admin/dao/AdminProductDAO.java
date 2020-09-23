package kr.co.kmarket.admin.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.ProductsVo;

@Repository
public interface AdminProductDAO {
	
	public void insertProduct(ProductsVo vo); 
	public ProductsVo selectProduct(); 
	public List<ProductsVo> selectProducts();
	
	public void updateProduct(); 
	public void deleteProduct(); 

}
