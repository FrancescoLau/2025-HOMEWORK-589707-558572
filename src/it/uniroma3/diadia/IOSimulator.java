package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IOSimulator implements IO{

	private List<String> righeLette;
	private int indiceMessaggiProdotti;
	private int indiceMessaggiMostrati;
	private int numeroRigheLette;
	private List<String> messaggiProdotti;
	
	public List<String> getMessaggiProdotti() {
		return messaggiProdotti;
	}

	public void setMessaggiProdotti(List<String> messaggiProdotti) {
		this.messaggiProdotti = messaggiProdotti;
	}

	public IOSimulator(List<String> righeDaLeggere) {
		this.messaggiProdotti = new ArrayList<>();
		this.righeLette = righeDaLeggere;
		this.numeroRigheLette = 0;
		this.indiceMessaggiMostrati = 0;
	}

	@Override
	public String leggiRiga() {
		String riga = null;
		riga=this.righeLette.get(numeroRigheLette);
		this.numeroRigheLette++;
		return riga;
	}

	@Override
	public void mostraMessaggio(String messaggio) {
		this.messaggiProdotti.add(messaggio);
		this.indiceMessaggiProdotti++;
	}

	public String nextMessaggio() {
		String next = this.messaggiProdotti.get(indiceMessaggiMostrati);
		this.indiceMessaggiMostrati++;
		return next;
	}

	public boolean hasNextMessaggio() {
		if (this.indiceMessaggiMostrati < this.indiceMessaggiProdotti) return true;
		else return false;
	}

}



