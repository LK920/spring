package kr.co.ch02.sub5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * date : 20/08/31
 * name : kang
 * content : DI 어노테이션을 이용한 스프링 Ioc 구현
 * 
 **/
public class IoCTest1 {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");
		
		Tv lgTV = (Tv) ctx.getBean("sub5LgTV");
		Tv samsungTV = (Tv) ctx.getBean("sub5SamsungTV");
		
		lgTV.power();
		lgTV.chUp();
		lgTV.soundUp();
		
		samsungTV.power();
		samsungTV.chUp();
		samsungTV.soundUp();
		
		
	}
}
