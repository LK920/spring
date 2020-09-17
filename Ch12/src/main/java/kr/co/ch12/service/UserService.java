package kr.co.ch12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch12.persistence.UserRepo;
import kr.co.ch12.vo.UserVo;

@Service
public class UserService {
	@Autowired
	private UserRepo repo;
	
	public void insertUser(UserVo vo) {
		repo.save(vo); //insert into ~ 수행
	}
	public UserVo selectUser(String uid) {
		return repo.findById(uid).get();
		//select *from where `uid` = uid ~ 수행
		//findbyid 만 할 경우 반환타입이 optional이라 uservo를 꺼내주기 위해 get 함수 사용
	}
	public List<UserVo> selectUsers() {
		return repo.findAll(); //select * from ~ 수행
	}
	public void updateUser(UserVo vo) {
		repo.save(vo); 	//update `` set name = , hp=?, age=? ~ 수행 table보고 저장할지 업데이트할지 할것 
	}
	public void deleteUser(String uid) {
		repo.deleteById(uid);// delete from ~ where ~ 수행
	}
	
	public List<UserVo> selectUsersOrderBy(String sort) {
		
		List<UserVo> users = null;
		
		if(sort.equals("asc")) {
			users = repo.findUserVoByOrderByAgeAsc();
		}else {
			users = repo.findUserVoByOrderByAgeDesc();
		}
		return users;
	}
	

}
