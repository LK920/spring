package kr.co.farmstory;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.farmstory.dao.UserDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context-test.xml"})
public class UserDaoTest {
	
	@Inject
	private UserDao dao;
	
	@Test
	public void selectTerms() {
		dao.selectTerms();
	}
	/*
	public void selectUserCount() {
		 int result = dao.selectUserCount("abcd");
		 System.out.println("result: "+result);
	}
	
	public void insertUser() {
		
		UserVO vo = new UserVO();
		vo.setUid("asdfw");
		vo.setPass1("1234");
		vo.setName("¿”≤©¡§");
		vo.setNick("≤©¡§");
		vo.setEmail("sakldjf@kasdf.com");
		vo.setHp("010-1118-8879");
		vo.setRegip("192.100.1.01");
		
		dao.insertUser(vo);
	}
	*/
}
