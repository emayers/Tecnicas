package project;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class TennisManagerTest {
	
	@SuppressWarnings("static-access")
	@Test
	public void addMatchTest() {
		File file = TennisManager.filePlayers;
		TennisManager gameTest = new TennisManager();
		Player player1 = new Player(), player2 = new Player();
		gameTest.player1 = player1;
		gameTest.player2 = player2;
		gameTest.player1.setScore(7);
		gameTest.player2.setScore(5);
		gameTest.player1.SetsList.add(new Sets());
		gameTest.player1.SetsList.add(new Sets());
		
		if(file.exists())
			assertTrue(TennisManager.checkFile());
		else{
			assertFalse(TennisManager.checkFile());
			assertEquals(gameTest.plays(gameTest.player1, 1), "Serve");
			assertEquals(gameTest.tiebreaker(gameTest.player1, gameTest.player2), 
					gameTest.player1);
			assertEquals(gameTest.addMatch(), player1);
		}
	}
	
	@Test
	public void previousMatchTest() {

		File file = TennisManager.filePlayers;
		
		if(file.exists()){
			assertTrue(TennisManager.checkFile());
			assertEquals(file.getName(), "previousMatch.csv");
		}
		else
			assertFalse(TennisManager.checkFile());
	}
	
}
