package kr.co.ch02.sub1;
/*
 * date : 20/08/31
 * name : kang
 * content : ������ Ioc �ǽ��ϱ�
 * 
 **/
public class IoCTest1 {
	public static void main(String[] args) {
		
		//ioc����(DI���)�� ���� ���
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
