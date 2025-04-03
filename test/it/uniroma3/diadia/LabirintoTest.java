package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

class LabirintoTest {
	
	private Labirinto l; 
	private Stanza atrio;
	private Stanza biblioteca;
	
	@BeforeEach
	void setUp() {
		l=new Labirinto();
		atrio=new Stanza("Atrio");
		biblioteca=new Stanza("biblioteca");
	}

	@Test
	public void testGetStanzaIniziale() {
		assertEquals(atrio.getNome(), l.getStanzaIniziale().getNome()); 
	}
	
	@Test
	public void testGetStanzaFinale() {
		assertEquals(biblioteca.getNome(), l.getStanzaFinale().getNome());
	}
	
}