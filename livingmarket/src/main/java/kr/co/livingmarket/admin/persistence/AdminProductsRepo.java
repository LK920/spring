package kr.co.livingmarket.admin.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.livingmarket.vo.ProductsVo;



@Repository
public interface AdminProductsRepo extends JpaRepository<ProductsVo, Integer> {
	
	
}
