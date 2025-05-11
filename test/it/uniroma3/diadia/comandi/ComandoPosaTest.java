package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class ComandoPosaTest {

	private Partita p;
	private Attrezzo attrezzo;
	private Comando comando;

	@BeforeEach
	public void setUp(){
		p = new Partita();
		attrezzo = new Attrezzo("martello", 2);
		comando = new ComandoPosa();
	}

	@Test
	public void testAttrezzoPosato() {
		p.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("martello");
		comando.esegui(p);
		assertTrue(p.getStanzaCorrente().hasAttrezzo("martello"));
	}

	@Test
	public void testAttrezzoPosatoNull() {
		comando.setParametro("lanterna");
		comando.esegui(p);
		assertFalse(p.getStanzaCorrente().hasAttrezzo("lanterna"));
	}
}
