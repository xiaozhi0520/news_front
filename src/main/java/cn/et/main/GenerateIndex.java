package cn.et.main;

import java.util.Timer;

public class GenerateIndex {

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new MyTimerTask(), 1,5000);
	}
}
