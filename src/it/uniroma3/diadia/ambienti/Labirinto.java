package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

public class Labirinto {
	private Stanza StanzaCorrente;
	private Stanza StanzaVincente;
	
	private Labirinto() {
	}
	
	
	
	/**
     * Crea tutte le stanze e le porte di collegamento
     */
    private void creaStanze() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
    
    /* pone gli attrezzi nelle stanze */
  		aulaN10.addAttrezzo(lanterna);
  		atrio.addAttrezzo(osso);

  		// il gioco comincia nell'atrio
          this.StanzaCorrente = atrio;  
  			this.StanzaVincente = biblioteca;
      }

    /**
     * Restituisce la stanza iniziale
     */
		public Stanza getStanzaCorrente() {
			return this.StanzaCorrente;
		}
		
	/**
	 * Restituisce la stanza finale
	 */
		public Stanza getStanzaVincente() {
			return this.StanzaVincente;
		}
		
		public void setStanzaVincente(Stanza s) {
			this.StanzaVincente=s;
		}
		public void setStanzaCorrente(Stanza s) {
			this.StanzaCorrente=s;
		}
		
		public static LabirintoBuilder newBuilder(String l) {
	        return new LabirintoBuilder(l);
	    } 
		public static class LabirintoBuilder {
			
			
			private Labirinto labirinto;
			private Stanza ultimaStanzaAggiunta;
			private Map<String, Stanza> nome2stanza;

			public LabirintoBuilder(String labirinto) throws Exception {
				this.labirinto = new Labirinto();
				this.nome2stanza = new HashMap<>();
			}

			public Map<String, Stanza> getNome2stanza() {
				return nome2stanza;
			}

			public Labirinto getLabirinto() {
				return this.labirinto;
			}

			public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
				Stanza i = new Stanza(stanzaIniziale);
				this.labirinto.setStanzaCorrente(i);
				this.UltimaStanzaAggiuntaEAggiorna(i);
				return this;
			}

			public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
				Stanza s = new Stanza(stanzaVincente);
				this.labirinto.setStanzaVincente(s);
				this.UltimaStanzaAggiuntaEAggiorna(s);
				return this;
			}

			public LabirintoBuilder addStanza(String stanza) {
				Stanza s = new Stanza(stanza);
				this.UltimaStanzaAggiuntaEAggiorna(s);
				return this;
			}	

			public LabirintoBuilder  addMago(String nome, String presentazione, Attrezzo attrezzo) {
				Mago m = new Mago(nome, presentazione, attrezzo);
				if(this.ultimaStanzaAggiunta==null)
					return this;
				this.ultimaStanzaAggiunta.setPersonaggio(m);
				return this;
			}

			public LabirintoBuilder  addCane(String nome, String presentazione) {
				Cane c = new Cane(nome, presentazione);
				if(this.ultimaStanzaAggiunta==null)
					return this;
				this.ultimaStanzaAggiunta.setPersonaggio(c);
				return this;
			}

			public LabirintoBuilder  addStrega(String nome, String presentazione) {
				Strega s = new Strega(nome, presentazione);
				if(this.ultimaStanzaAggiunta==null)
					return this;
				this.ultimaStanzaAggiunta.setPersonaggio(s);
				return this;
			}

			public LabirintoBuilder addAttrezzo(String attrezzo, int peso) {
				Attrezzo a = new Attrezzo(attrezzo, peso);
				if(this.ultimaStanzaAggiunta==null)
					return this;
				this.ultimaStanzaAggiunta.addAttrezzo(a);
				return this;
			}

			public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiecente, String direzione) {
				Stanza c = this.nome2stanza.get(stanzaCorrente);
				Stanza a = this.nome2stanza.get(stanzaAdiecente);
				c.impostaStanzaAdiacente(direzione, a);
				return this;
			}

			public LabirintoBuilder addStanzaMagica(String nome) {
				Stanza stanza = new StanzaMagica(nome);
				this.UltimaStanzaAggiuntaEAggiorna(stanza);
				return this;
			}

			public LabirintoBuilder addStanzaBuia(String nome, String attrezzoPerVedere) {
				Stanza stanza = new StanzaBuia(nome,attrezzoPerVedere);
				this.UltimaStanzaAggiuntaEAggiorna(stanza);
				return this;
			}

			public LabirintoBuilder addStanzaBloccata(String nome, String attrezzoSbloccante, String direzioneBloccata) {
				Stanza stanza = new StanzaBloccata(nome, Direzione.valueOf(direzioneBloccata), attrezzoSbloccante);
				this.UltimaStanzaAggiuntaEAggiorna(stanza);
				return this;
			}

			public void UltimaStanzaAggiuntaEAggiorna(Stanza stanza) {
				this.ultimaStanzaAggiunta = stanza;
				this.nome2stanza.put(stanza.getNome(), stanza);
			}
		}
}

