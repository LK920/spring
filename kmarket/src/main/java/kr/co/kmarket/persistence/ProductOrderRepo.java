package kr.co.kmarket.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.kmarket.vo.ProductsOrderVo;

public interface ProductOrderRepo extends JpaRepository<ProductsOrderVo, Integer> {

}
