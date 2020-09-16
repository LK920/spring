package kr.co.ch11_1.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ch11_1.vo.UserVO;

@Repository
public interface UserDAO {
	
	public void insertUser(UserVO vo);
	public UserVO selectUser();
	public List<UserVO> selectUsers();
	public void updateUser(UserVO vo);
	public void deleteUser(String uid);
}
