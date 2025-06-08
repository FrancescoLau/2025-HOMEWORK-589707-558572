package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {
	
	private static final int CFU_INIZIALI=20;

	private Stanza stanzaCorrente;
	private boolean finita;
	private Giocatore giocatore;
	private Labirinto labirinto;
	
	public Partita(Labirinto labirinto){
		this.labirinto=labirinto;
		this.stanzaCorrente=labirinto.getStanzaIniziale();
		this.giocatore=new Giocatore();
		this.giocatore.setCfu(CFU_INIZIALI);
		this.finita = false;
		
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return (this.getStanzaCorrente() == this.labirinto.getStanzaFinale() );
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return ( finita || vinta() || (giocatore.getCfu() == 0) );
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
}
