package kr.co.ch06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * date : 20/09/02
 * name : kang
 * content : spring JDBC �ǽ��ϱ�
 */
public class JDBCTest {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");
		
		UserDAO dao = (UserDAO) ctx.getBean("userDAO");
		
		dao.insertUser();
		dao.updateUser();
		dao.deleteUser();
		
		System.out.println("���α׷� ����...");
		
				
	}

}