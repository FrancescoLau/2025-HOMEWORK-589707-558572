package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	private Partita partita;
	private Attrezzo attrezzo;
	private String nomeAttrezzo;
	private IO io;
	
	private final static String NOMECOMANDO = "prendi";

	@Override
	public void esegui(Partita p) {
		Attrezzo attrezzo=p.getStanzaCorrente().getAttrezzo(nomeAttrezzo);	
		if(this.nomeAttrezzo!=null) {		
			if(p.getStanzaCorrente().getNumeroAttrezzi()!=0){
				p.getStanzaCorrente().removeAttrezzo(attrezzo);
				p.getGiocatore().getBorsa().addAttrezzo(attrezzo);	
			}			
		}					
		else	System.out.println("Non si puo' prendere l'oggetto! ");
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
	


