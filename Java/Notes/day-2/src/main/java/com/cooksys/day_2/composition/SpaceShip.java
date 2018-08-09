package com.cooksys.day_2.composition;

public class SpaceShip {
	
	private SpaceShipController control = new SpaceShipController();

	public SpaceShipController getControl() {
		return control;
	}

	public void setControl(SpaceShipController control) {
		this.control = control;
	}

	public void left(int velocity) {
		control.left(velocity);
	}

	public void right(int velocity) {
		control.right(velocity);
	}

	public void up(int velocity) {
		control.up(velocity);
	}

	public void down(int velocity) {
		control.down(velocity);
	}

	public void forward(int velocity) {
		control.forward(velocity);
	}

	public void backward(int velocity) {
		control.backward(velocity);
	}
	
	

}
