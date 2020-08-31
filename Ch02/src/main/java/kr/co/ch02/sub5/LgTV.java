package kr.co.ch02.sub5;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component("sub5LgTV")
public class LgTV implements Tv{
	
	@Inject
	private Speaker spk;
	
	@Override
	public void power() {
		System.out.println("Sub5 lgTV power....");
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
