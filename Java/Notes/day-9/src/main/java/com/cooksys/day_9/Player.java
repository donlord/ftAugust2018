package com.cooksys.day_9;

@Position(positions = { "leftfield", "rightfield", "centerfield", "firstbase", "secondbase", "shortstop", "thirdbase",
		"pitcher", "catcher" })
public class Player implements AnnotatedClass {

	@ThemeSong(song = "Take Me Out to the Ballgame")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@DoItWithABaseballBat(batType = BaseballBat.METAL)
	public void atBat() {
		// TODO Auto-generated method stub
	}

}
