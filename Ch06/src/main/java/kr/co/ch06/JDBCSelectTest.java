package kr.co.ch06;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * date : 20/09/02
 * name : kang
 * content : spring  JDBC select 실습하기
 */
public class JDBCSelectTest {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");
		
		UserDAO dao = (UserDAO) ctx.getBean("userDAO");
		
		UserVO vo = dao.selectUser("B101");
		System.out.println("아이디 : "+vo.getUid());
		System.out.println("이름 : "+vo.getName());
		System.out.println("전화번호 : "+vo.getHp());
		System.out.println("나이 : "+vo.getAge());
		
		List<UserVO> users = dao.selectUsers();
		
		for(UserVO user : users) {
			System.out.println("=======================");
			System.out.println("아이디 : " + user.getUid());
			System.out.println("이름 : " + user.getName());
			System.out.println("전화번호 : " + user.getHp());
			System.out.println("나이 : " + user.getAge());
			System.out.println("------------------------");
		}
		
		System.out.println("프로그램 종료...");
	}

}
