package com.cooksys.day_2;

public interface Instrument {
	
	int INSTRUMENT_CONSTANT = 50;

	public default void play (Instrument i) {
		System.out.println("Interface Instrument is playing a song");
	}

}
