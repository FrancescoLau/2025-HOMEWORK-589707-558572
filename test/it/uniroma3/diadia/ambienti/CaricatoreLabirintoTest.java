package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

package it.uniroma3.diadia;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class CaricatoreLabirintoTest {

	private final String monolocale = 
			"Stanze:biblioteca\n"+
			"Bloccata:\n"+
			"Buia:\n"+
			"Magica: \n"+
			"Inizio:biblioteca\n"+
			"Vincente:biblioteca\n"+
			"Cane:\n"+
			"Strega:\n"+
			"Mago:\n"+
			"Attrezzi:\n"+
			"Uscite:\n";

	private final String bilocale = 
			"Stanze:N12,N11\n"+
			"Bloccata:\n"+
			"Magica:\n"+
			"Buia:\n"+
			"Inizio:atrio\n"+
			"Vincente:biblioteca\n"+
			"Mago: \n"+
			"Strega: \n"+
			"Cane:\n"+
			"Attrezzi:lanterna 2 atrio\n"+
			"Uscite:\n";
	
	private CaricatoreLabirinto caricatore;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBilocale() throws FormatoFileNonValidoException, FileNotFoundException {
		caricatore = new CaricatoreLabirinto(new StringReader(bilocale));
		caricatore.carica();
		assertEquals("atrio", this.caricatore.getStanzaIniziale().getNome());
		assertEquals("biblioteca", this.caricatore.getStanzaVincente().getNome());
		}
	
	
	@Test
	public void testBilocaleAttrezzo() throws FormatoFileNonValidoException, FileNotFoundException {
		caricatore = new CaricatoreLabirinto(new StringReader(bilocale));
		caricatore.carica();
		Attrezzo attrezzo = new Attrezzo("lanterna", 3);
		assertEquals(attrezzo, this.caricatore.getStanzaIniziale().getAttrezzo("lanterna"));
		}
}
