package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando{
	private IO io;
	

	public void setIo(IO io) {
		this.io=io;
	}

	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzo;
		attrezzo=partita.getGiocatore().getBorsa().getAttrezzo(getParametro());
		partita.getGiocatore().getBorsa().removeAttrezzo(getParametro());
		partita.getStanzaCorrente().getPersonaggio().riceviRegalo(attrezzo, partita);
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
