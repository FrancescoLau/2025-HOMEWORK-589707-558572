package it.uniroma3.diadia.giocatore;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {

	private Borsa b = new Borsa();
	private Attrezzo lanterna;
	private Attrezzo osso;
		
	@BeforeEach
	void setUp() {
		lanterna=new Attrezzo("lanterna", 1);
		osso=new Attrezzo("osso", 2);
		b.addAttrezzo(lanterna);
		b.addAttrezzo(osso);
		
	}

	@Test
	public void testGetPesoMax() {
		assertEquals(10, b.getPesoMax());
	}
	
	@Test
	public void testAddRemoveAttrezzo() {
		assertTrue(b.addAttrezzo(lanterna));
		assertTrue(b.addAttrezzo(osso));
	}
	
	@Test
	public void testHasAttrezzo() {
		assertTrue(b.hasAttrezzo("lanterna"));
	}
}
