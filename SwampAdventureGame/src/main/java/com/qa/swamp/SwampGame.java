package com.qa.swamp;

import java.util.Random;
import java.util.Scanner;

public class SwampGame {

	private String userInput = "";
	private Random rand = new Random();
	
	public static void main(String[] args) {
		//Initialisation
		SwampGame swamp = new SwampGame();
		swamp.gameLoop();
	}
	
	public void gameLoop() {
		Player player = new Player("Trevor",0,0);
		Objective target = new Objective("Location",3,0);
		
		//Opening Text
		System.out.println("Grey foggy clouds float oppressively close to you,\r\n"
						+ "reflected in the murky grey water which reaches up your shins.\r\n"
						+ "Some black plants barely poke out of the shallow water.");
		
		while (!userInput.equals("Quit")) {
			
			if (player.getFoundObjective() != true) {
				System.out.println("----------------------------------");
				System.out.println("Which way would you like to go?");
				System.out.println("'North', 'East', 'South' or 'West'");
				System.out.println("----------------------------------");
				userInput = input();
			
			
				if(userInput.equals("North")) {
					System.out.println("You stroll in a northward direction.");
					player.goNorth();
					areWeThereYet(player, target);
				}else if(userInput.equals("East")) {
					System.out.println("You stroll in a easterly direction.");
					player.goEast();
					areWeThereYet(player, target);
				}else if(userInput.equals("South")) {
					System.out.println("You stroll in a southward direction.");
					player.goSouth();
					areWeThereYet(player, target);
				}else if(userInput.equals("West")) {
					System.out.println("You stroll in a westerly direction.");
					player.goWest();
					areWeThereYet(player, target);
				}else if(userInput.equals("Quit")){
					break;
				}else {
					System.out.println("Incorrect Input, You walk around in circles, everything looks familiar.");
				}
				
				// Make new objective
			} else {
				
				target = setNewObjective(player);
				player.setFoundObjective(false);
			}
			
			
			
		}
	}
	
	public void areWeThereYet(Player player, Objective objective) {
		if (player.getXPosition() == objective.getXPosition() && player.getYPosition() == objective.getYPosition()) {
			player.setFoundObjective(true);
			objective.event();
		} else {
			calculateDistance(player.getXPosition(),objective.getXPosition(),player.getYPosition(),objective.getYPosition());
		}
	}
	
	public void calculateDistance(int playerX, int objectiveX, int playerY, int objectiveY) {
		double distance = 0;
		float x = 0;
		float y = 0;
		
		//Sort them so it's not negative.
		if (playerX > objectiveX){
			x = (playerX - objectiveX);
		} else {
			x = (objectiveX - playerX);
		}
		
		if (playerY > objectiveY) {
			y = (playerY - objectiveY);
		} else {
			y = (objectiveY - playerY);
		}
		
		distance = Math.sqrt((x*x) + (y*y));
		 
		System.out.println("The dial reads: " + distance);
	}
	
	public String input() {
		Scanner scanner = new Scanner(System.in);
		String x = scanner.nextLine();
		return x;
	}
	
	public Objective setNewObjective(Player player) {
		Objective newObjective;
		int xPos = 0;
		int yPos = 0;
		
		//Randomises and sets a new position within a 5/5 square of the player.
		xPos = player.getXPosition() + rand.nextInt(5) - rand.nextInt(5); //Not perfect but it'll do.
		yPos = player.getYPosition() + rand.nextInt(5) - rand.nextInt(5);
		
		newObjective = new Objective("name",xPos,yPos);
		
		
		return newObjective;
	}

}
