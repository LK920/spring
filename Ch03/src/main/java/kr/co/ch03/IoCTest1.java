package kr.co.ch03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * date : 20/08/31
 * name : kang
 * content : DI ������̼��� �̿��� ������ Ioc ����
 * 
 * 
 *  ������̼� ����
 *  @component
 *   - ������ �����̳ʰ� �ش� ������̼� ���� Ŭ������ ���, ����
��*   - @Controller, Service, Repository�� ����ȭ
 *	@Autowired
 *	 - ��������(��ü)�� ��ü�� �����ϴ� ������̼�, ������ ���� ������̼�
 *	 - 
 *	@Inject
 *	 - ��������(��ü)�� ��ü�� �����ϴ� ������̼�, �ڹ� ���� ������̼�  
 * 
 **/
public class IoCTest1 {
	public static void main(String[] args) {
		
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
