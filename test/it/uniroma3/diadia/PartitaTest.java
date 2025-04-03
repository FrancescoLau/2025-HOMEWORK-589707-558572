package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {
	
	private Partita p;
	private Stanza atrio;
	private Stanza biblioteca;
	
	
	@BeforeEach
	public void setUp() {
		p=new Partita();
		atrio=new Stanza("atrio");
		biblioteca=new Stanza("biblioteca");
	}

	@Test 
	public void testStanzaCorrente() {
		p.setStanzaCorrente(atrio);
		assertEquals("atrio", p.getStanzaCorrente().getNome());
		
		Stanza n11=new Stanza("n11");
		p.setStanzaCorrente(n11);
		assertEquals("n11", p.getStanzaCorrente().getNome());
		
		Stanza biblioteca=new Stanza("biblioteca");
		p.setStanzaCorrente(biblioteca);
		assertEquals("biblioteca", p.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testisFinita() {
		assertFalse(p.isFinita());
	}
	
	@Test 
	public void testsetFinita() {
		p.setFinita();
		assertTrue(p.isFinita());
	}
	
	@Test
	public void testGetStanzaVincente() {
		biblioteca=p.getStanzaCorrente();
		p.setStanzaCorrente(biblioteca);
		assertTrue(p.vinta());
	}
	
}
