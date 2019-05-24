package com.qa.swampTests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import com.qa.swamp.*;

public class PlayerTests {

	SwampGame swmpGame;
	Player player;
	Objective target;
	
	@Before
	public void TestSetup(){
		swmpGame = new SwampGame();
		player = new Player("TestesIV",0,0);
		target = new Objective("Place",0,2);
	}
	
	@Test
	public void NorthTest() {
		
		player.goNorth();
		assertEquals("Player got lost going North", 1 , player.getYPosition());		
	
	}
	
	@Test
	public void EastTest() {
		
		player.goEast();
		assertEquals("Player got lost going East", 1 , player.getXPosition());
		
	}
	
	@Test
	public void SouthTest() {
		
		player.goSouth();
		assertEquals("Player got lost going South", -1 , player.getYPosition());
		
	}
	
	@Test
	public void WestTest() {
		
		player.goWest();
		assertEquals("Player got lost going West", -1 , player.getXPosition());
		
	}
	
	@Test
	public void PlayerAtObjectiveTest() {
		player.goNorth();
		player.goNorth();
		assertEquals("The player missed the objective on x axis", target.getXPosition() , player.getXPosition());
		assertEquals("The player missed the objective on y axis", target.getYPosition() , player.getYPosition());
	}
			
}
