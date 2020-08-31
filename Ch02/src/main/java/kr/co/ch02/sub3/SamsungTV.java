package kr.co.ch02.sub3;

public class SamsungTV implements Tv {
	
	private Speaker spk;
	public void setSpk(Speaker spk) {
		this.spk = spk;
	}
	
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