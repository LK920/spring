package kr.co.ch03;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SamsungTV implements Tv {
	
	@Autowired
	private Speaker spk;
	@Inject
	private Internet internet;
	
	@Override
	public void power() {
		System.out.println("Sub5 SamsungTV power....");
		internet.access();
	}
	@Override
	public void chUp() {
		System.out.println("Sub5 SamsungTV chUp....");
	}
	@Override
	public void soundUp() {
		spk.soundUp();
	}
}