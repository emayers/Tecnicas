package project;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatchesTest {

	@Test
	public void getPlayer1Test1() {
		//caso válido
		Matches m=new Matches();
		Player p=new Player();
		m.setPlayer1(p);
		assertEquals(m.getPlayer1(), p);
	}
	
	@Test
	public void getPlayer1Test2() {
		//caso inválido, retorna null
		Matches m=new Matches();
		assertEquals(m.getPlayer1(), null);
	}
	
	@Test
	public void getPlayer2Test1() {
		//caso válido
		Matches m=new Matches();
		Player p=new Player();
		m.setPlayer2(p);
		assertEquals(m.getPlayer2(), p);
	}
	
	
	@Test
	public void getPlayer2Test2() {
		//caso inválido, retorna null
		Matches m=new Matches();
		assertEquals(m.getPlayer2(), null);
	}

}
