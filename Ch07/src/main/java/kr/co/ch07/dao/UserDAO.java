package kr.co.ch07.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.co.ch07.vo.UserVO;

@Repository
public class UserDAO {
	
	@Inject
	private JdbcTemplate jdbc;
	
	public void insertUser(UserVO vo) {
		String sql = "INSERT INTO `MEMBER` VALUES (?,?,?,?,?,NOW())";
		Object[] params = {vo.getUid(), vo.getName(), vo.getHp(), vo.getPos(), vo.getDep()};
		jdbc.update(sql, params);
	}
	public UserVO selectUser(String uid) {
		String sql = "SELECT * FROM `MEMBER` WHERE `uid` = ?";
		UserVO vo= jdbc.queryForObject(sql, new UserRowMapper(), uid);
		return vo;
				
	}
	public List<UserVO> selectUsers() {
		String sql = "SELECT * FROM `MEMBER`";
		List<UserVO> users= jdbc.query(sql, new UserRowMapper());
		
		return users;
	}
	public void updateUser() {
		
	}
	
	public void deleteUser(String uid) {
		
		String sql = "DELETE FROM `MEMBER` WHERE `uid` =?";
		jdbc.update(sql, uid);
	}

}
