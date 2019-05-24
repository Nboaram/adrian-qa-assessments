package com.qa.swamp;

public class Player extends GameObject {
	
	private boolean foundObjective = false;
	
	public Player(String name, int xCoOrd, int yCoOrd) {
		super(name,xCoOrd,yCoOrd);
	}
	
	public void goNorth() {
		int position = this.getYPosition();
		position = position + 1;
		this.setYPosition(position);
	}
	
	public void goEast() {
		int position = this.getXPosition();
		position = position + 1;
		this.setXPosition(position);
	}
	
	public void goSouth() {
		int position = this.getYPosition();
		position = position - 1;
		this.setYPosition(position);
	}	
	
	public void goWest() {
		int position = this.getXPosition();
		position = position - 1;
		this.setXPosition(position);
	}
	
	public void setFoundObjective(boolean newState) {
		foundObjective = newState;
	}
	
	public boolean getFoundObjective() {
		return foundObjective;
	}
	
}
