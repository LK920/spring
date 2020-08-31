package kr.co.ch02.sub3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * date : 20/08/31
 * name : kang
 * content : 스프링 Ioc - DI setter 적용
 * 
 **/
public class IoCTest1 {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");
		
		Tv lgTV = (Tv) ctx.getBean("sub3lgTV");
		Tv samsungTV = (Tv) ctx.getBean("sub3samsungTV");
		
		lgTV.power();
		lgTV.chUp();
		lgTV.soundUp();
		
		samsungTV.power();
		samsungTV.chUp();
		samsungTV.soundUp();
		
	}
}
