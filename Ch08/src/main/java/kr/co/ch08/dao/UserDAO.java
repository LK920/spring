package kr.co.ch08.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.co.ch08.vo.UserVO;

@Repository
public class UserDAO {
	
	@Inject
	private JdbcTemplate jdbc;
	@Inject
	private SqlSessionTemplate mybatis;
	
	public void insertUser(UserVO vo) {
		//jdbc ���
		//String sql = "INSERT INTO `USER3` VALUES (?,?,?,?)";
		//Object[] values = {vo.getUid(), vo.getName(), vo.getHp(), vo.getAge()};
		
		//jdbc.update(sql, values);
		
		//mybatis ���
		mybatis.insert("mapper.user.INSERT_USER", vo);
	}
	
	public UserVO selectUser(String uid) {
		return mybatis.selectOne("mapper.user.SELECT_USER", uid);
	}
	
	public List<UserVO> selectUsers() {
		
		//Spring jdbc ���
		//String sql = "SELECT * FROM `USER3`";
		//List<UserVO> users = jdbc.query(sql, new UserRowMapper()); 
	
		//mybatis ���
		List<UserVO> users = mybatis.selectList("mapper.user.SELECT_USERS");
		return users;
	}
	
	public void updatetUser(UserVO vo) {
		mybatis.update("mapper.user.UPDATE_USER", vo);
	}
	public void deleteUser(String uid) {
		mybatis.delete("mapper.user.DELETE_USER", uid);
	}

}
