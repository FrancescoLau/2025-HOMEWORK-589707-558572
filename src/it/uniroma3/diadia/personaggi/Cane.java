package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

public class Cane extends AbstractPersonaggio{

public Cane(String nome, String presentaz) {
		super(nome, presentaz);
	}

private static String CIBOPREFERITO="osso";
private static String MESSAGGIO="Ho tolto un CFU!";



@Override
public String agisci(Partita partita) {
	Giocatore g=partita.getGiocatore();
	g.setCfu(g.getCfu()-1);
	return MESSAGGIO;
}

@Override
public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
	if(attrezzo!=null) {
		if(attrezzo.getNome().equals(CIBOPREFERITO)) {
			partita.getStanzaCorrente().addAttrezzo(new Attrezzo("collare", 1));
			return "Grazie per il regalo!";
		}
		else {
			this.agisci(partita);
			return "Non e' il cibo che preferisco";
		}
	}
	return "Non ci sono attrezzi da regalare";
}
}
