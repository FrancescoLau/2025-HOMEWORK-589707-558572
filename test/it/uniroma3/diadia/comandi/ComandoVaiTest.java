package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

class ComandoVaiTest {
	
	private ComandoVai c;
	private Stanza atrio;
	private Partita p;
	private Stanza biblioteca;
	private Stanza s;

	
	@BeforeEach
	void setUp(){	
		atrio=new Stanza("atrio");
		c=new ComandoVai();
		p=new Partita();
		s=new Stanza("s");
		biblioteca=new Stanza("biblioteca");
		p.setStanzaCorrente(atrio);
	}

	@Test
	public void testDirezioneEsistente() {	
		c.setParametro("nord");
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		c.esegui(p);
		assertEquals(biblioteca, p.getStanzaCorrente());
		
	}
	@Test
	public void testCambioParametro() {			
		
		atrio.impostaStanzaAdiacente("sud", s);		
		c.setParametro("sud");
		c.esegui(p);
		assertEquals(s, p.getStanzaCorrente());
		
	}
	
}
