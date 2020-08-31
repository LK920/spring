package kr.co.ch02.sub1;
/*
 * date : 20/08/31
 * name : kang
 * content : 스프링 Ioc 실습하기
 * 
 **/
public class IoCTest1 {
	public static void main(String[] args) {
		
		//ioc적용(DI기법)을 안할 경우
		Tv lgtv = new LgTV();
		lgtv.power();
		lgtv.chUp();
		lgtv.soundUp();
		
		Tv samsungtv = new SamsungTV();
		samsungtv.power();
		samsungtv.chUp();
		samsungtv.soundUp();
		
		
	}
}
