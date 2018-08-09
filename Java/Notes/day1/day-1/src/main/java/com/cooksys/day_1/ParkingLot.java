package com.cooksys.day_1;

public class ParkingLot {
	private static String name;
	private ParkingSpace space;
	
	public ParkingLot () {
		
	}
	
	public ParkingLot (String name1) {
		name = name1;
	}
	
	public ParkingLot (String name1, ParkingSpace space) {
		name = name1;
		if (space != null) {
			this.space = space;
		}
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name1) {
		name = name1;
	}

	public ParkingSpace getSpace() {
		return space;
	}

	public void setSpace(ParkingSpace space) {
		this.space = space;
	}

}
