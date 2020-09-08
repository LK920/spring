package kr.co.sboard.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.sboard.dao.UserDAO;
import kr.co.sboard.vo.TermsVO;
import kr.co.sboard.vo.UserVO;

@Service
public class UserService {
	
	@Inject
	public UserDAO dao;
	
	public void selectUser() {}
	public void selectUsers() {}
	public void insertUser(UserVO vo) {
		dao.insertUser(vo);
	}
	public void updateUser() {}
	public void deleteUser() {}
	
	public TermsVO selectTerms() {
		return dao.selectTerms();
	}
	
	public int selectUserCount(String uid) {
		return dao.selectUserCount(uid);
	}
	public int selectNickCount(String nick) {
		return dao.selectNickCount(nick);
	}

}
