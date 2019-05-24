package com.qa.swamp;

import java.net.SocketTimeoutException;
import java.util.Random;
import java.util.Scanner;

public class Objective extends GameObject {
	
	private String userInput = "";
	private Random rand = new Random();
	
	public Objective(String name, int xCoOrd, int yCoOrd) {
		super(name,xCoOrd,yCoOrd);
	}
	
	public void event() {
		int value = rand.nextInt(4);
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
	
	public String input() {
		Scanner scanner = new Scanner(System.in);
		String x = scanner.nextLine();
		return x;
	}

}
