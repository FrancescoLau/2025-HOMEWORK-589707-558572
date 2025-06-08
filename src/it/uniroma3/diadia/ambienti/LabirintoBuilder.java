package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class LabirintoBuilder {
	private Labirinto labirinto;
	private Stanza ultimaStanza;
	private Map<String, Stanza> nome2stanza;

	public LabirintoBuilder() {
		this.labirinto=new Labirinto();
		this.nome2stanza=new HashMap<>();
	}
	
	public Map<String, Stanza> getNome2stanza(){
		return this.nome2stanza;
	}
	
	public LabirintoBuilder setPersonaggio(AbstractPersonaggio personaggio) {
        if (this.ultimaStanza != null) {
            this.ultimaStanza.setPersonaggio(personaggio);
        }
        return this;
    }
	public void AggiungiUltimaStanzaAggiorna(Stanza stanza) {
		this.ultimaStanza=stanza;
		this.nome2stanza.put(stanza.getNome(), stanza);
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
		
		    Stanza i = new Stanza(stanzaIniziale);
		    this.labirinto.setStanzaCorrente(i);
		    this.AggiungiUltimaStanzaAggiorna(i); 
		    return this;
	}
	
	public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
		Stanza s = new Stanza(stanzaVincente);
		this.labirinto.setStanzaVincente(s);
		this.AggiungiUltimaStanzaAggiorna(s);
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
		Attrezzo attrezzo=new Attrezzo(nomeAttrezzo, peso);
		if(this.ultimaStanza!=null) {
			this.ultimaStanza.addAttrezzo(attrezzo);
			return this;
		}
		return this;
	}
	
	public LabirintoBuilder addStanza(String nomeStanza) {
		Stanza stanza=new Stanza(nomeStanza);
		this.AggiungiUltimaStanzaAggiorna(stanza);
		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String nomeStanzaCorrente, String nomeStanzaAdiacente, String direzione) {
		Stanza stanzaCorrente = this.nome2stanza.get(nomeStanzaCorrente);
		Stanza stanzaAdiacente = this.nome2stanza.get(nomeStanzaAdiacente);
		
		if (stanzaCorrente == null || stanzaAdiacente == null) {
			throw new IllegalArgumentException("Stanze non trovate nella mappa: " 
				+ nomeStanzaCorrente + " o " + nomeStanzaAdiacente);
		}

		stanzaCorrente.impostaStanzaAdiacente(direzione, stanzaAdiacente);
		return this;
	}

	
	public LabirintoBuilder addStanzaBuia(String nomeStanzaBuia, String attrezzo) {
		Stanza stanzaBuia=new StanzaBuia(nomeStanzaBuia, attrezzo);
		this.AggiungiUltimaStanzaAggiorna(stanzaBuia);
		return this;
	}
	
	
	public LabirintoBuilder addStanzaMagica(String nomeStanzaMagica) {
		Stanza stanzaMagica=new Stanza(nomeStanzaMagica);
		this.AggiungiUltimaStanzaAggiorna(stanzaMagica);
		return this;
	}
	public LabirintoBuilder addStanzaBloccata(String nomeStanzaBloccata, String attrezzo, String direzioneBloccata) {
		Stanza stanzaBloccata=new StanzaBloccata(nomeStanzaBloccata, attrezzo, direzioneBloccata);
		this.AggiungiUltimaStanzaAggiorna(stanzaBloccata);
		return this;
	}	
	
	}
}
