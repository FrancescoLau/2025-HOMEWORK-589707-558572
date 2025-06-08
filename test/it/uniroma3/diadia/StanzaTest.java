package it.uniroma3.diadia;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	
	private Stanza atrio;
	private Attrezzo lanterna; 
	private Attrezzo spada;
	private Stanza biblioteca;
	private Stanza laboratorio;
	private Stanza Aulan10;
	
	@BeforeEach
	void setUp() {
		atrio=new Stanza("atrio");
		lanterna = new Attrezzo("lanterna", 2);
		atrio.addAttrezzo(lanterna);
		spada= new Attrezzo("spada", 3);
		biblioteca=new Stanza("biblioteca");
		laboratorio=new Stanza ("laboratorio");
		Aulan10=new Stanza("Aulan10");
	}

	@Test
	public void testhasAttrezzoTrue() {	
		assertTrue(atrio.hasAttrezzo("lanterna"));
	}
	
	@Test
	public void testhasAttrezzoFalse() {	
		assertFalse(atrio.hasAttrezzo("spada"));
	}
	
	@Test
	public void testaddAttrezzo() {	
		atrio.addAttrezzo(spada);
		assertTrue(atrio.hasAttrezzo("spada"));
	}
	
	@Test
	public void testgetAttrezzo() {
	assertEquals(lanterna, atrio.getAttrezzo("lanterna"));	
	}
	
	@Test
	public void testStanzaAdiacente() {
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		assertEquals(biblioteca, atrio.getStanzaAdiacente("nord"));		
	}
	
}









