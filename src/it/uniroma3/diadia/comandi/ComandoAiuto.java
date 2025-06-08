package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando{
	static final public String[] COMANDI= {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};
	private IO io;
	private static final String NOMECOMANDO="aiuto";

	@Override
	public void esegui(Partita partita) {
		for(int i=0; i<COMANDI.length; i++) {
			io.mostraMessaggio(COMANDI[i]+" ");
		}		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIo(IO io) {
		this.io=io;
	}
	
}
