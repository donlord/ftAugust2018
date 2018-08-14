package com.cooksys.day_6;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class App implements Runnable
{
	private static Addition lockA = new Addition(10, 10);
	private static Addition lockB = new Addition(10, 10);
	
	private int counter;
	
    public static void main( String[] args ) throws InterruptedException
    {
    	
    	App a = new App();
    	for (int i = 0; i < 10; i++) {
    		Thread t = new Thread(a);
    		t.start();
    		t.join();
    	}
    	System.out.println("Finished running the thread!");
    	
    }
    
    public void add () {
    	
    }

	public void run() {
		counter++;
		System.out.println(counter);
	}
}
