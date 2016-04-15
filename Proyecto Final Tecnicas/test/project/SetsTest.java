package project;

import static org.junit.Assert.*;

import org.junit.Test;

public class SetsTest {

	@Test
	public void getPlayer1Test1() {
		//caso válido
		Sets s=new Sets();
		Player p=new Player();
		s.setPlayer1(p);
		assertEquals(s.getPlayer1(), p);
	}
	
	@Test
	public void getPlayer1Test2() {
		//caso inválido, retorna null
		Sets s=new Sets();
		assertEquals(s.getPlayer1(), null);
	}
	
	@Test
	public void getPlayer2Test1() {
		//caso válido
		Sets s=new Sets();
		Player p=new Player();
		s.setPlayer2(p);
		assertEquals(s.getPlayer2(), p);
	}
	
	
	@Test
	public void getPlayer2Test2() {
		//caso inválido, retorna null
		Sets s=new Sets();
		assertEquals(s.getPlayer2(), null);
	}

}
