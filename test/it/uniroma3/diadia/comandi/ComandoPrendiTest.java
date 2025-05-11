package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPrendiTest {
	private Attrezzo lanterna;
	private Partita p;
	private Comando c;
	

	@BeforeEach
	void setUp(){
		lanterna=new Attrezzo("lanterna", 2);
		p=new Partita();
		c=new ComandoPrendi();
	}

	@Test
	final void testPrendi() {
		p.getStanzaCorrente().addAttrezzo(lanterna);
		c.setParametro("lanterna");
		c.esegui(p);
		assertTrue(p.getGiocatore().getBorsa().hasAttrezzo("lanterna"));
	}
	
	@Test
	public void testPrendiNull() {
		p.getStanzaCorrente().addAttrezzo(lanterna);
		c.esegui(p);
		assertFalse(p.getGiocatore().getBorsa().hasAttrezzo("lanterna"));
	}

}
