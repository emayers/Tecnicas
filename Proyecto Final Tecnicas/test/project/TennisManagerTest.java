package project;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class TennisManagerTest {
	
	@SuppressWarnings("static-access")
	@Test
	public void addMatchTest() {
		File file = TennisManager.filePlayers;
		TennisManager matchTest = new TennisManager();
		Player player1 = new Player(), player2 = new Player();
		matchTest.player1 = player1;
		matchTest.player2 = player2;
		matchTest.player1.setScore(7);
		matchTest.player2.setScore(5);
		matchTest.player1.SetsList.add(new Sets());
		matchTest.player1.SetsList.add(new Sets());
		
		if(file.exists())
			assertTrue(TennisManager.checkFile());
		else{
			assertFalse(TennisManager.checkFile());
			assertEquals(matchTest.plays(matchTest.player1, 1), "Serve");
			assertEquals(matchTest.tiebreaker(matchTest.player1, matchTest.player2), 
					matchTest.player1);
			assertEquals(matchTest.winner(), matchTest.player1);
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
