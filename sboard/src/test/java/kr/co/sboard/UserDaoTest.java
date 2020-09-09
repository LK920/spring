package kr.co.sboard;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.sboard.dao.UserDAO;
import kr.co.sboard.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context-test.xml"})
public class UserDaoTest {
	
	@Inject
	private UserDAO dao;
	
	@Test
	public void selectTerms() {
		dao.selectTerms();
	}
	
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
}
