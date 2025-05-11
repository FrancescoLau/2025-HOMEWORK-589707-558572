package it.uniroma3.diadia;

public class IOSimulator implements IO{

	private String[] righeLette;
	private int indiceMessaggiProdotti;
	private int indiceMessaggiMostrati;
	private int numeroRigheLette;
	private String[] messaggiProdotti;
	
	public String[] getMessaggiProdotti() {
		return messaggiProdotti;
	}

	public void setMessaggiProdotti(String[] messaggiProdotti) {
		this.messaggiProdotti = messaggiProdotti;
	}

	public IOSimulator(String[] righeDaLeggere) {
		this.messaggiProdotti = new String[100];
		this.righeLette = righeDaLeggere;
		this.numeroRigheLette = 0;
		this.indiceMessaggiMostrati = 0;
	}

	@Override
	public String leggiRiga() {
		String riga = null;
		riga = this.righeLette[numeroRigheLette];
		this.numeroRigheLette++;
		return riga;
	}

	@Override
	public void mostraMessaggio(String messaggio) {
		this.messaggiProdotti[indiceMessaggiProdotti] = messaggio;
		this.indiceMessaggiProdotti++;
	}

	public String nextMessaggio() {
		String next = this.messaggiProdotti[this.indiceMessaggiMostrati];
		this.indiceMessaggiMostrati++;
		return next;
	}

	public boolean hasNextMessaggio() {
		if (this.indiceMessaggiMostrati < this.indiceMessaggiProdotti) return true;
		else return false;
	}

}



