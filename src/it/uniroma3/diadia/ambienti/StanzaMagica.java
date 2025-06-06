package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagica extends Stanza {
final static private int SOGLIA_MAGICA_DEFAULT = 3;
private int contatoreAttrezziPosati;
private int sogliaMagica;

public StanzaMagica(String nome) {
	this(nome, SOGLIA_MAGICA_DEFAULT);
	}

public StanzaMagica(String nome, int soglia) {
	super(nome);
	this.contatoreAttrezziPosati = 0;
	this.sogliaMagica = soglia;
}

@Override
public boolean addAttrezzo(Attrezzo attrezzo) {
	if(attrezzo!=null) {
		if(this.contatoreAttrezziPosati>this.sogliaMagica) {
		attrezzo=modificaAttrezzo(attrezzo);
		this.contatoreAttrezziPosati++;
	}
	return super.addAttrezzo(attrezzo);	
	}
	return false;
}

private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
	StringBuilder nomeInvertito;
	int pesoX2 = attrezzo.getPeso() * 2;
	nomeInvertito = new StringBuilder(attrezzo.getNome());
	nomeInvertito = nomeInvertito.reverse();
	attrezzo = new Attrezzo(nomeInvertito.toString(),
	pesoX2);
	return attrezzo;
}
}