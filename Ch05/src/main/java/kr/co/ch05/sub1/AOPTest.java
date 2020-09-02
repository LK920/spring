package kr.co.ch05.sub1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * date : 20/09/02
 * name : kang
 * content : 어노테이션 기반 aop 실습하기
 */
public class AOPTest {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");
		
		BoardService bs = (BoardService) ctx.getBean("boardService");
		
		System.out.println("==================");
		bs.insert();
		bs.select();
		bs.update(1);
		bs.delete(1, "abcd");
		System.out.println("---------------------");
		
		
	}

}
