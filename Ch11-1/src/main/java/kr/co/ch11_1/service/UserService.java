package kr.co.ch11_1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch11_1.dao.UserDAO;
import kr.co.ch11_1.vo.UserVO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO dao;
	
	public void insertUser(UserVO vo) {
		dao.insertUser(vo);
	};
	public UserVO selectUser() {
		return dao.selectUser();
	};
	public List<UserVO> selectUsers(){
		return dao.selectUsers();
	};
	public void updateUser(UserVO vo) {
		dao.updateUser(vo);
	};
	public void deleteUser(String uid) {
		dao.deleteUser(uid);
	};

}
