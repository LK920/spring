package kr.co.livingmarket.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.livingmarket.vo.MemberVo;

@Repository
public interface MemberRepo extends JpaRepository<MemberVo, String> {

}
