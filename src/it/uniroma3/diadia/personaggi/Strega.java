package it.uniroma3.diadia.personaggi;

import java.util.LinkedList;
import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{
	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
		// TODO Auto-generated constructor stub
	}

	private String MESS_SALUTO="Mi hai salutato!";
	private String MESS_SALUTO_MANCATO="Non mi hai salutato, vai nella stanza con meno attrezzi!";
	private String messaggioGenerico;
	@Override
	public String agisci(Partita partita) {
		List<Stanza>stanze=new LinkedList<>();
		Stanza stanzaMax = stanze.get(0);
		Stanza stanzaMin = stanze.get(0);

		for(Stanza stanza: stanze) {
			if(stanza!=null) 
				{if(stanza.getNumeroAttrezzi()>stanzaMax.getNumeroAttrezzi()) {
					stanzaMax=stanza;
					
				}
				if(stanza.getNumeroAttrezzi()<stanzaMin.getNumeroAttrezzi()) {
					stanzaMin=stanza;				
				}
				}
			
			if(this.haSalutato()) {
				partita.setStanzaCorrente(stanzaMax);
				messaggioGenerico= MESS_SALUTO;
			}
			else {
				partita.setStanzaCorrente(stanzaMin);
				messaggioGenerico= MESS_SALUTO_MANCATO;
			}
			
		}
		return messaggioGenerico;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String messaggio="Ahahahahah";
		return messaggio;
	}
	
}
