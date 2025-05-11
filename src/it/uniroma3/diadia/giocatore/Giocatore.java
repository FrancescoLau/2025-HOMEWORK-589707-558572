package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Giocatore {
	private Giocatore giocatore;
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa borsa;
	
	public Giocatore() {
		this.borsa=new Borsa();
		this.cfu=CFU_INIZIALI;
	}
	
	public boolean prendiAttrezzo(Attrezzo a) {
        return this.borsa.addAttrezzo(a);
    }

    public boolean posaAttrezzo(String nomeAttrezzo) {
        return this.borsa.removeAttrezzo(nomeAttrezzo);
    }
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	
	public void setBorsa(Borsa borsa) {
		this.borsa=borsa;
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
}
