package kr.co.ch02.sub1;

public class SamsungTV implements Tv {

	@Override
	public void power() {
		System.out.println("SamsungTV power....");
		
	}

	public void chUp() {
		System.out.println("SamsungTV chUp....");
		
	}

	public void soundUp() {
		System.out.println("SamsungTV soundUp....");
		
	}
}