package kr.co.ch02.sub2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * date : 20/08/31
 * name : kang
 * content : ������ Ioc �ǽ��ϱ�
 * 
 **/
public class IoCTest1 {
	public static void main(String[] args) {
		
		//ioc�� ������ ���
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");
		
		Tv lgTV = (Tv) ctx.getBean("lgTV");
		Tv samsungTV = (Tv) ctx.getBean("samsungTV");
		
		lgTV.power();
		lgTV.chUp();
		lgTV.soundUp();
		
		samsungTV.power();
		samsungTV.chUp();
		samsungTV.soundUp();
		
	}
}
