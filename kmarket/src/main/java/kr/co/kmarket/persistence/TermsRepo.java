package kr.co.kmarket.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.kmarket.vo.TermsVo;

public interface TermsRepo extends JpaRepository<TermsVo, Integer> {
	
}
