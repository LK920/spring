package kr.co.ch02.sub2;

public class SamsungTV implements Tv {

	@Override
	public void power() {
		System.out.print("SamsungTV power....");
		
	}

	public void chUp() {
		System.out.print("SamsungTV chUp....");
		
	}

	public void soundUp() {
		System.out.print("SamsungTV soundUp....");
		
	}
}