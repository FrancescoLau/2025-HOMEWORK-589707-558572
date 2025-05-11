package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

	private  String nomeAttrezzo;
	public StanzaBuia(String nome , String nomeAttrezzo) {
		super(nome);
		this.nomeAttrezzo = nomeAttrezzo;
	}

@Override
public String getDescrizione() {
	String MessaggioBuio = "Qui c'è buio pesto!";
	if(!this.hasAttrezzo(nomeAttrezzo))
		return MessaggioBuio;
		return super.getDescrizione();
	}
}