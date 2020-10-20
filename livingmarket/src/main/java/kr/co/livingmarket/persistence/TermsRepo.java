package kr.co.livingmarket.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.livingmarket.vo.TermsVo;

@Repository
public interface TermsRepo extends JpaRepository<TermsVo, Integer>{

}
