package com.qa.swamp;

public abstract class GameObject {
	private String name;
	private int xPosition;
	private int yPosition;
	
	
	public GameObject(String newName, int xCoOrd, int yCoOrd) {
		name = newName;
		xPosition = xCoOrd;
		yPosition = yCoOrd;
	}
	
	
	public String getName() {
		return name;
	}
	
	public int getXPosition() {
		return xPosition;
	}
	
	public int getYPosition() {
		return yPosition;
	}
	
	public void setXPosition(int xPos) {
		xPosition = xPos;
	}
	
	public void setYPosition(int yPos) {
		yPosition = yPos;
	}
}
