package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

class PartitaTest {
	
	private Partita p;
	private Stanza atrio;
	private Stanza biblioteca;
	private Labirinto l;
	private Giocatore giocatore;
	
	@BeforeEach
	public void setUp() {
		p=new Partita();
		atrio=new Stanza("atrio");
		l=p.getLabirinto();
		biblioteca=new Stanza("biblioteca");
		biblioteca=l.getStanzaFinale();	
		
	}
	
	@Test 
	public void testStanzaCorrente() {
		p.setStanzaCorrente(atrio);
		assertEquals("atrio", p.getStanzaCorrente().getNome());	
	}
	
	@Test 
	public void testStanzaCorrenteN11() {
		Stanza n11=new Stanza("n11");
		p.setStanzaCorrente(n11);
		assertEquals("n11", p.getStanzaCorrente().getNome());
	}
	
	@Test 
	public void testStanzaCorrenteBiblioteca() {
		Stanza biblioteca=new Stanza("biblioteca");
		p.setStanzaCorrente(biblioteca);
		assertEquals("biblioteca", p.getStanzaCorrente().getNome());
	}
	
	@Test
	public void TestNomeStanzaFinale() {
		assertEquals("Biblioteca", p.getLabirinto().getStanzaFinale().getNome());
	}
	
	@Test
	public void testIsFinita() {
		assertFalse(p.isFinita());
	}
	
	@Test 
	public void testSetFinita() {
		p.setFinita();
		assertTrue(p.isFinita());
	}
	
	@Test 
	public void testVintaFalse() {
		p.setStanzaCorrente(atrio);
		assertFalse(p.vinta());
	}
	@Test 
	public void testVintaTrue() {
		p.setStanzaCorrente(biblioteca);
		assertTrue(p.vinta());
	}
}
