package kr.co.ch02.sub4;

public class LgTV implements Tv{
	
	private Speaker spk;
	
	public LgTV(Speaker spk) {
		this.spk = spk;
	}
	
	@Override
	public void power() {
		System.out.print("lgTV power....");
		
	}
	@Override
	public void chUp() {
		System.out.print("lgTV chUp....");
		
	}
	@Override
	public void soundUp() {
		spk.soundUp();
	}
	

}
