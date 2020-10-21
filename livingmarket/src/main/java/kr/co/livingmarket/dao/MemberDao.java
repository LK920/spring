package kr.co.livingmarket.dao;

import org.springframework.stereotype.Repository;

import kr.co.livingmarket.vo.MemberVo;
import kr.co.livingmarket.vo.ResultVo;

@Repository
public interface MemberDao {
	
	public ResultVo checkUid(String uid);
	public ResultVo checkEmail(String email);
	public ResultVo checkHp(String hp);
	public MemberVo selectMember(MemberVo vo);
}
