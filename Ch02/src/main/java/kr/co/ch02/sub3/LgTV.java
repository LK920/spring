package kr.co.ch02.sub3;

public class LgTV implements Tv{
	
	private Speaker spk;
	public void setSpk(Speaker spk) {
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
