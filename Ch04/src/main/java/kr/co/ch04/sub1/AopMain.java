package kr.co.ch04.sub1;
/*
 * 날짜 : 20/09/01
 * 이름 : 강래구
 * 내용 : AOP 실습하기
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.co.ch04.sub2.BoardService;

public class AopMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");
		
		BoardService bs = (BoardService) ctx.getBean("boardService");
		
		bs.insert();
		bs.select();
		bs.update(1);
		bs.delete(1,"abcd");
	}
}
