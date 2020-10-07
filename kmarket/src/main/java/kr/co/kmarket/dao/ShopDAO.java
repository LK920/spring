package kr.co.kmarket.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.ProductsVo;

@Repository
public interface ShopDAO {

	public List<ProductsVo> selectShop(int cate1, int cate2, int sort);
}
