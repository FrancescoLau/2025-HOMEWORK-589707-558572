package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	
	private Stanza s;
	private Attrezzo attrezzo;

	@BeforeEach
	void setUp(){
		attrezzo=new Attrezzo("lanterna", 1);
		s=new StanzaBuia("s", "lanterna");
		
	}

	@Test
	final void testStanzaNonBuia() {
		s.addAttrezzo(attrezzo);
		assertEquals(s.toString(), s.getDescrizione());
	}
	
	@Test
	final void testStanzaBuia() {
		String buio="Qui c'è buio pesto!";
		assertEquals(buio, s.getDescrizione());
	}

}
