package com.cooksys.day_2.composition;

public class ParkingLot {
	
	private ParkingSpace space = new ParkingSpace(1);
	
	public ParkingSpace getSpace() {
		return space;
	}
	
	public void setSpace(ParkingSpace space) {
		this.space = space;
	}

}
