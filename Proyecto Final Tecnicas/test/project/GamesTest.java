package project;

import static org.junit.Assert.*;

import org.junit.Test;

public class GamesTest {

	@Test
	public void getPlayer1Test1() {
		//caso válido
		Games g=new Games();
		Player p=new Player();
		g.setPlayer1(p);
		assertEquals(g.getPlayer1(), p);
	}
	
	@Test
	public void getPlayer1Test2() {
		//caso inválido, retorna null
		Games g=new Games();
		assertEquals(g.getPlayer1(), null);
	}
	
	@Test
	public void getPlayer2Test1() {
		//caso válido
		Games g=new Games();
		Player p=new Player();
		g.setPlayer2(p);
		assertEquals(g.getPlayer2(), p);
	}
	
	
	@Test
	public void getPlayer2Test2() {
		//caso inválido, retorna null
		Games g=new Games();
		assertEquals(g.getPlayer2(), null);
	}
	


}
