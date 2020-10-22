package kr.co.livingmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.livingmarket.dao.MemberDao;
import kr.co.livingmarket.vo.MemberVo;
import kr.co.livingmarket.vo.ResultVo;

@Service
public class MemberService {
	@Autowired
	private MemberDao dao;
	
	public ResultVo checkUid(String uid) {
		return dao.checkUid(uid);
	}
	
	public ResultVo checkEmail(String email) {
		return dao.checkEmail(email);
	}
	public ResultVo checkHp(String hp) {
		return dao.checkHp(hp);
	}
	public void registerMember(MemberVo vo) {
		dao.registerMember(vo);
	}
	public MemberVo selectMember(MemberVo vo) {
		return dao.selectMember(vo);
	}

}
