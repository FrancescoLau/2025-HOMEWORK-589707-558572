package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando{
	private IO io;
	
	
	public void esegui(Partita partita) {
		if(partita.getStanzaCorrente().getPersonaggio()==null) io.mostraMessaggio("Non c'e' nessun personaggio nella stanza");
		else {
			partita.getStanzaCorrente().getPersonaggio().saluta();
		}
	}
	public void setIo(IO io) {
		this.io=io;
	}
	
	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}
}
