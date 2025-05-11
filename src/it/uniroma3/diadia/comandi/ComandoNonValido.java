package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando{
	private IO io;
	private final static String NOMECOMANDO = "non valido";

	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Il comando non è valido!");	
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNome() {
		return NOMECOMANDO;
	}

	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public void setIo(IO io) {
		this.io=io;
	}

}
