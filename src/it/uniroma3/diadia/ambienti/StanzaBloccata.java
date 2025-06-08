package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	
	private String nomeDirezioneBloccata;
	private String attrezzoSbloccaDirezione;

	public StanzaBloccata(String nome, String attrezzoSbloccaDirezione, String nomeDirezioneBloccata ) {
		super(nome);
		this.attrezzoSbloccaDirezione=attrezzoSbloccaDirezione;
		this.nomeDirezioneBloccata=nomeDirezioneBloccata;
	}
	
@Override
public Stanza getStanzaAdiacente(String direzione) {
	if(!(this.hasAttrezzo(attrezzoSbloccaDirezione))&&(direzione.equals(nomeDirezioneBloccata)))
		return this;
	else 
		return super.getStanzaAdiacente(direzione);
	}
	
@Override 
public String getDescrizione() {
	String messaggioStanzaBloccata="Stanza bloccata in direzione " + nomeDirezioneBloccata + "con attrezzo sbloccante "+ attrezzoSbloccaDirezione +"!";
	if(this.hasAttrezzo(attrezzoSbloccaDirezione))
		return super.getDescrizione();
	else
		return messaggioStanzaBloccata;
}
}
