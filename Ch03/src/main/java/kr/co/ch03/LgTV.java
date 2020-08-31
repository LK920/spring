package kr.co.ch03;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

@Repository
public class LgTV implements Tv{
	
	@Inject
	private Speaker spk;
	@Inject
	private Internet internet;
	
	@Override
	public void power() {
		System.out.println("Sub5 lgTV power....");
		internet.access();
	}
	@Override
	public void chUp() {
		System.out.println("Sub5 lgTV chUp....");
	}
	@Override
	public void soundUp() {
		spk.soundUp();
	}
}
