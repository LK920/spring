package kr.co.kmarket.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.Category1Vo;

@Repository
public interface category1Repo extends JpaRepository<Category1Vo, Integer> {

}
