package com.qa.swamp;

import java.util.Random;
import java.util.Scanner;

public class Objective extends GameObject {
	
	private String userInput = "";
	private Random rand = new Random();
	
	public Objective(String name, int xCoOrd, int yCoOrd) {
		super(name,xCoOrd,yCoOrd);
	}
	
	public void event() {
		int value = rand.nextInt(8);
		switch (value) {
		case 0:
			niceLake();
			break;
		case 1:
			spiderFight();
			break;
		case 2:
			cave();
			break;
		case 3:
			skeletonFight();
			break;
		case 4:
			path();
			break;
		case 5:
			bog();
			break;
		case 6:
			bee();
			break;
		case 7:
			mole();
			break;
		}
	}
	
	public void spiderFight() {
		
		System.out.println("A spider winds down from a tree infront of you, bearing it's mandibles!!!!");
		while(!userInput.equals("Leave")) {
			System.out.println("What do you do?");
			System.out.println("Fight, Leave, Dance");
			userInput = input();
			
			if (userInput.equals("Fight")) {
				System.out.println("You stamp on the spider, that'll teach him to catch flies!");
				break;
			} else if (userInput.equals("Dance")) {
				System.out.println("The mighty spider rears back, raising itself up on it's back legs,\r\n"
								 + "and starts dancing along with you, \r\n"
								 + "he loves a good dance.");
			} else if (userInput.equals("Leave")) {
				System.out.println("Yeah, spider's are no laughing matter! You very quickly run away");
				break;
			} else {
				System.out.println("Incorrect Input, You and the spider stare at each other");
			}
			
		}
	}
	
	public void niceLake() {
		System.out.println("You come across a nice lake, it's almost idyllic.");
	}
	
	public void cave() {
		System.out.println("You discover a cave, it doesn't go very far before you find the end though.");
	}
	
	public void skeletonFight() {
		System.out.println("From out of the mire and fog infront of you,\r\n"
						+ " you see a skeleton walking towards you menacingly!");
		
		while(!userInput.equals("Leave")) {
			System.out.println("What do you do?");
			System.out.println("Fight, Leave, Dance");
			userInput = input();
			
			if (userInput.equals("Fight")) {
				System.out.println("You draw your... stick? and batter the skeleton down mercilessly.\r\n"
								 + "dead things should stay dead!");
				break;
			} else if (userInput.equals("Dance")) {
				System.out.println("The skeleton rams it's arm through your chest and pulls out your heart,\r\n"
								 + "it then looks disappointed as your heart stops beating,\r\n"
								 + "so it strolls off looking sad...\r\n"
								 + "You die though.");
									System.exit(0);
			} else if (userInput.equals("Leave")) {
				System.out.println("Yeah, the dead walking!!! I'm not being paid enough for this!");
				break;
			} else {
				System.out.println("Incorrect Input, You and the skeleton stare at each other");
			}
			
		}
		
	}
	
	public void path() {
		System.out.println("You find a path, you follow it for a while\r\n"
						+ "but eventually you start recognising more and more scenery.");
	}
	
	public void bog() {
		System.out.println("You stroll along and then, BAM,\r\n"
						+ "You are waist deep in a bog");
		
		while(!userInput.equals("Look")) {
			System.out.println("What do you do?");
			System.out.println("Swim, Float, Look");
			userInput = input();
			
			if (userInput.equals("Swim")) {
				System.out.println("You try to swim for dry land,\r\n"
								 + "but you end up sinking more and more\r\n"
								 + "and you die...");
									System.exit(0);
			} else if (userInput.equals("Float")) {
				System.out.println("You float about for a bit contemplating life");
			} else if (userInput.equals("Look")) {
				System.out.println("You see a handly placed rope,\r\n"
								+ "and pull yourself to safety.");
									break;
			} else {
				System.out.println("Incorrect Input, You start to sink...");
			}
			
		}
	}
	
	public void bee() {
		System.out.println("You come across a Bee. You try to ask him the way out. He's busy.");
	}
	
	public void mole() {
		System.out.println("A mole tunnels under your feet. He notices your there and decides he's not interested.");
	}
	
	
	
	public String input() {
		Scanner scanner = new Scanner(System.in);
		String x = scanner.nextLine();
		return x;
	}

}
