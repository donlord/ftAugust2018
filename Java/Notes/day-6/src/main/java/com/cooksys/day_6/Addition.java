package com.cooksys.day_6;

public class Addition implements Runnable {
	
	static int a;
	static int b;
	
	public Addition (int a, int b) {
		Addition.a = a;
		Addition.b = b;
	}
	
	static synchronized public void add () {
		Addition.a = Addition.a + Addition.b;
	}

	public void run() {
		Addition.add();
		System.out.println(Addition.a);
	}

}
