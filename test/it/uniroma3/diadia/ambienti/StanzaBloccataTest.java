package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {

	private Stanza s;
	private Attrezzo attrezzo;
	private Stanza atrio;
	
	@BeforeEach
	void setUp(){
		s=new StanzaBloccata("s", "lanterna", "nord");
		attrezzo=new Attrezzo("lanterna", 1);
		atrio=new Stanza("atrio");
		s.impostaStanzaAdiacente("nord", atrio);		
	}

	@Test
	public void testDirezioneBloccata() {
		assertEquals(s, s.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testDescrizione() {
		s.addAttrezzo(attrezzo);
		assertEquals(s.toString(), s.getDescrizione());
	}
	
	@Test
	public void testDirezioneSbloccata() {
		s.addAttrezzo(attrezzo);
		assertEquals(atrio, s.getStanzaAdiacente("nord"));
	}
	
}
