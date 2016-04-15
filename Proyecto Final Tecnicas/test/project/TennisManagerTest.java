package project;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class TennisManagerTest {

	//falta addMatch, previousMatch
//	@Test
//	public void playsTest() {
//		Player p=new Player();
//		TennisManager m=new TennisManager();
//		
//		
//		
//	}
//	@Test
//	public void tieBreakerTest() {
//		Player p1=new Player();
//		Player p2=new Player();
//		TennisManager m=new TennisManager();
//		p1.setScore(5);
//		p2.setScore(5);
//		m.tiebreaker(p1, p2);
//		
//		
//		
//	}
	
	@SuppressWarnings("static-access")
	@Test
	public void addMatchTest() {
		File file = TennisManager.filePlayers;
		TennisManager gameTest = new TennisManager();
		Player p1 = new Player();
		Player p2 = new Player();
		gameTest.player1 = p1;
		gameTest.player2 = p2;
		gameTest.player1.setScore(7);
		gameTest.player2.setScore(5);
		
		if(file.exists())
			assertTrue(TennisManager.checkFile());
		else{
			assertFalse(TennisManager.checkFile());
			assertEquals(gameTest.tiebreaker(gameTest.player1, gameTest.player2), 
					gameTest.player1);
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
