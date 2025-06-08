package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class LabirintoBuilderTest {
	private LabirintoBuilder labBuilder;
	
	@BeforeEach
	void setUp() throws Exception {
		labBuilder=new LabirintoBuilder();
	}

	@Test
	public void testGetLabirinto() {
		assertNotNull(labBuilder.getLabirinto());
		assertEquals(Labirinto.class, labBuilder.getLabirinto().getClass());
	}

	@Test
	public void testAddStanza() {
		labBuilder.addStanza("stanzetta");
		Stanza expected = new Stanza("stanzetta");
		assertEquals(expected, labBuilder.getNome2stanza().get("stanzetta"));
	}

	@Test
	public void testAddAttrezzoSenzaUltimaStanzaAggiunta(){
		assertEquals(LabirintoBuilder.class, labBuilder.addAttrezzo("cacciavite", 3).getClass());
	}
	
	@Test
	public void testAddAttrezzoConUltimaStanzaAggiunta(){
		labBuilder.addStanzaIniziale("stanzetta").addAttrezzo("cacciavite", 3);
		Attrezzo expected = new Attrezzo("cacciavite", 3);
		assertEquals(expected, labBuilder.getLabirinto().getStanzaCorrente().getAttrezzo("cacciavite"));		
	}

	@Test
    public void testAddAttrezzoConStanza() {
		labBuilder.addStanza("stanzetta");
		labBuilder.addAttrezzo("cacciavite", 3);
        assertTrue(labBuilder.getNome2stanza().get("stanzetta").hasAttrezzo("cacciavite"));
    }
}




