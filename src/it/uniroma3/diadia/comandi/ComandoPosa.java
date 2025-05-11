package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{
	private static final String NOMECOMANDO = "Posa";
	private String nomeAttrezzo;
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzo=partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);	
		
		if(attrezzo!=null) {
			if(partita.getStanzaCorrente().getNumeroAttrezziPossibili()>0) {	
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			partita.getStanzaCorrente().addAttrezzo(attrezzo);					
					
		}
		else
			System.out.println("L'attrezzo non puo' essere aggiunto");
			
		}
		
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;					
	}

	@Override
	public String getNome() {
		return NOMECOMANDO;
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public void setIo(IO io) {		
		this.io=io;
	}

}


