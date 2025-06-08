package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;

class FabbricaDiComandiFisarmonicaTest {
	
	private FabbricaDiComandiFisarmonica fabbrica;
	private Comando comando;
	private IOConsole io;
	

	@BeforeEach
	void setUp(){
		io = new IOConsole();
		fabbrica = new FabbricaDiComandiFisarmonica(io);
		comando=new ComandoVai();
		
	}

	@Test
	public void testComandoParametro() {
		comando.setParametro("nord");
		Comando current = fabbrica.costruisciComando("vai nord");
		assertEquals( comando.getNome(), current.getNome());
		assertEquals( comando.getParametro(), current.getParametro());
	}
		
	@Test
	public void testComandoNonValido() {
		comando = new ComandoNonValido();
		assertNotEquals( comando.getNome(), fabbrica.costruisciComando("vai").getNome());
	}
	
	@Test
	public void testComandoNonValido2() {
		comando = new ComandoNonValido();
		assertEquals( comando.getNome(), fabbrica.costruisciComando("vuoto").getNome());
	}
}
