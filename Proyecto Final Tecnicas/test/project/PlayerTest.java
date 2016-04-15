package project;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void getSetsListTest1() {
		//caso válido
		Player p=new Player();
		ArrayList<Sets> l=new ArrayList<Sets>();
		Sets s1=new Sets();
		l.add(s1);
		Sets s2=new Sets();
		l.add(s2);
		Sets s3=new Sets();
		l.add(s3);
		Sets s4=new Sets();
		l.add(s4);
		Sets s5=new Sets();
		l.add(s5);
		p.setSetsList(l);
		assertEquals(p.getSetsList(), l);
		
	}
	@Test
	public void getSetsListTest2() {
		//caso válido
		Player p=new Player();
		ArrayList<Sets> l=new ArrayList<Sets>();
		Sets s1=new Sets();
		l.add(s1);
		Sets s2=new Sets();
		l.add(s2);
		Sets s3=new Sets();
		l.add(s3);
		Sets s4=new Sets();
		l.add(s4);
		Sets s5=new Sets();
		l.add(s5);
		Sets s6=new Sets();
		l.add(s6);
		Sets s7=new Sets();
		l.add(s7);
		Sets s8=new Sets();
		l.add(s8);
		Sets s9=new Sets();
		l.add(s9);
		Sets s10=new Sets();
		l.add(s10);
		Sets s11=new Sets();
		l.add(s11);
		Sets s12=new Sets();
		l.add(s12);
		p.setSetsList(l);
		assertEquals(p.getSetsList(), l);
	}
	@Test
	public void getSetsListTest3() {
		//caso inválido, ArrayList vacío
		Player p=new Player();
		assertEquals(p.getSetsList().size(), 0);
	}
	
	@Test
	public void getScoreTest1() {
		//caso válido
		Player p=new Player();
		p.setScore(6);
		assertEquals(p.getScore(), 6);
	}
	@Test
	public void getScoreTest2() {
		//caso válido
		Player p=new Player();
		p.setScore(3);
		assertEquals(p.getScore(),3);
		
	}
	@Test
	public void getScoreTest3() {
		//caso en que no haya iniciado un juego, retorna cero
		Player p=new Player();
		assertEquals(p.getScore(),0);
	}
	@Test
	public void getGamesListTest1() {
		//caso válido
		Player p=new Player();
		ArrayList<Games> l=new ArrayList<Games>();
		Games s1=new Games();
		l.add(s1);
		Games s2=new Games();
		l.add(s2);
		Games s3=new Games();
		l.add(s3);
		Games s4=new Games();
		l.add(s4);
		Games s5=new Games();
		l.add(s5);
		p.setGamesList(l);
		assertEquals(p.getGamesList(), l);
	}
	@Test
	public void getGamesListTest2() {
		//caso válido
		Player p=new Player();
		ArrayList<Games> l=new ArrayList<Games>();
		Games s1=new Games();
		l.add(s1);
		Games s2=new Games();
		l.add(s2);
		Games s3=new Games();
		l.add(s3);
		Games s4=new Games();
		l.add(s4);
		Games s5=new Games();
		l.add(s5);
		Games s6=new Games();
		l.add(s6);
		Games s7=new Games();
		l.add(s7);
		Games s8=new Games();
		l.add(s8);
		Games s9=new Games();
		l.add(s9);
		Games s10=new Games();
		l.add(s10);
		Games s11=new Games();
		l.add(s11);
		Games s12=new Games();
		l.add(s12);
		p.setGamesList(l);
		assertEquals(p.getGamesList(), l);
	}
	@Test
	public void getGamesListTest3() {
		//no han realizado games, ArrayList vacío
		Player p=new Player();
		assertEquals(p.getGamesList().size(), 0);
	}
	
	@Test
	public void getNameTest1() {
		//caso válido
		Player p=new Player();
		p.setName("Seismic toss Mayers");
		assertEquals(p.getName(), "Seismic toss Mayers");
	}
	@Test
	public void getNameTest2() {
		//caso válido
		Player p=new Player();
		p.setName("Flash cannon Edison");
		assertEquals(p.getName(), "Flash cannon Edison");
	}
	@Test
	public void getNameTest3() {
		//no hay player, retorna null
		Player p=new Player();
		assertEquals(p.getName(), null);
	}
	
	@Test
	public void getMatchesListTest1() {
		//caso válido
		Player p=new Player();
		ArrayList<Matches> l=new ArrayList<Matches>();
		Matches s1=new Matches();
		l.add(s1);
		Matches s2=new Matches();
		l.add(s2);
		Matches s3=new Matches();
		l.add(s3);
		Matches s4=new Matches();
		l.add(s4);
		Matches s5=new Matches();
		l.add(s5);
		p.setMatchesList(l);
		assertEquals(p.getMatchesList(), l);
	}
	@Test
	public void getMatchesListTest2() {
		//ncaso válido
		Player p=new Player();
		ArrayList<Matches> l=new ArrayList<Matches>();
		Matches s1=new Matches();
		l.add(s1);
		Matches s2=new Matches();
		l.add(s2);
		Matches s3=new Matches();
		l.add(s3);
		Matches s4=new Matches();
		l.add(s4);
		Matches s5=new Matches();
		l.add(s5);
		Matches s6=new Matches();
		l.add(s6);
		Matches s7=new Matches();
		l.add(s7);
		Matches s8=new Matches();
		l.add(s8);
		Matches s9=new Matches();
		l.add(s9);
		Matches s10=new Matches();
		l.add(s10);
		Matches s11=new Matches();
		l.add(s11);
		Matches s12=new Matches();
		l.add(s12);
		p.setMatchesList(l);
		assertEquals(p.getMatchesList(), l);
	}
	@Test
	public void getMatchesListTest3() {
		//no hay matches, ArrayList vacía
		Player p=new Player();
		assertEquals(p.getMatchesList().size(), 0);
	}
	


}
