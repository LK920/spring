package kr.co.livingmarket.admin.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.livingmarket.vo.ProductsVo;


@Repository
public interface AdminProductDAO {
	
	
	public void insertProduct(ProductsVo vo); 
	public ProductsVo selectProduct(); 
	public List<ProductsVo> selectProducts(int start);
	
	public int selectCountProducts();
	public int selectCountProductsBySearch(String opt, String keyword);
	
	public List<ProductsVo>  selectProductsBySearch(int start, String opt, String keyword);
	
	public void updateProduct(); 
	
	public int deleteProduct(String[] codes); 

}
