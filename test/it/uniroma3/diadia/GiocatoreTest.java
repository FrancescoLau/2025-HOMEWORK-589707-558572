package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {
	
	private Giocatore g;

	@BeforeEach
	void setUp(){
	g=new Giocatore();
	
	}

	@Test
	public void testGetCfu() {
		assertEquals(20, g.getCfu()); 
	}
	
	@Test
	
	public void testGetCfu2() {
		g.setCfu(10);
		assertEquals(10, g.getCfu());
	}
}
