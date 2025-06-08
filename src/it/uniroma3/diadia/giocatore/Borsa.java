package it.uniroma3.diadia.giocatore;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.*;

public class Borsa {
public final static int DEFAULT_PESO_MAX_BORSA = 10;
private List<Attrezzo> attrezzi;
private int numeroAttrezzi;
private int pesoMax;

public Borsa() {
	this(DEFAULT_PESO_MAX_BORSA);
}

public Borsa(int pesoMax) {
	this.pesoMax = pesoMax;
	this.attrezzi = new LinkedList<>(); 
	this.numeroAttrezzi = 0;
}

public boolean addAttrezzo(Attrezzo attrezzo) {
	if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
	return false;
	
	
	this.attrezzi.addLast(attrezzo);
	this.numeroAttrezzi++;
	return true;
}
/*Restituisce peso massimo della borsa*/
public int getPesoMax() {
	return pesoMax;
}

public Attrezzo getAttrezzo(String nomeAttrezzo) {
	Attrezzo a = null;
	for (int i= 0; i<this.numeroAttrezzi; i++)
		if (attrezzi.get(i).getNome().equals(nomeAttrezzo))	a = attrezzi.get(i);
	
	return a;
}

public int getPeso() {
	int peso = 0;
	for (int i= 0; i<this.numeroAttrezzi; i++)
	peso += attrezzi.get(i).getPeso();
	return peso;
}

public boolean isEmpty() {
	return this.numeroAttrezzi == 0;
}

public boolean hasAttrezzo(String nomeAttrezzo) {
	return this.getAttrezzo(nomeAttrezzo)!=null;
}

public boolean removeAttrezzo(String nomeAttrezzo) {
	
	if(nomeAttrezzo!=null){
	for(int i=0; i<this.attrezzi.size(); i++) 
		if(this.attrezzi.get(i).getNome().equals(nomeAttrezzo))
			{attrezzi.remove(attrezzi.get(i));
			this.numeroAttrezzi--;
			return true;}
	}
	return false;
}

public String toString() {
	StringBuilder s = new StringBuilder();
	if (!this.isEmpty()) {
	s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
	s.append(this.getContenutoOrdinatoPerNome().toString());
	s.append(this.getContenutoOrdinatoPerPeso().toString());
	s.append(this.getContenutoRaggruppatoPerPeso().toString());
	}
	else s.append("La borsa e' vuota!");
	return s.toString();
}
	
public List<Attrezzo> getContenutoOrdinatoPerPeso(){
	List<Attrezzo>lista=new LinkedList<>();
	for(Attrezzo a: this.attrezzi)
	lista.add(a);
	return lista;
}

public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
	SortedSet<Attrezzo> insiemeOrdinato = new TreeSet<>(new Attrezzo.ComparatoreAttrezzi());
	insiemeOrdinato.addAll(this.attrezzi);
	return insiemeOrdinato;
}

public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
	Map<Integer, Set<Attrezzo>>mappaFinale=new HashMap<>();
	for(Attrezzo a: this.attrezzi) {
		if (mappaFinale.containsKey(a.getPeso())) mappaFinale.get(a.getPeso()).add(a);
		else {
			Set<Attrezzo>insiemeNuovo=new TreeSet<>();
			mappaFinale.put(a.getPeso(), insiemeNuovo);
		}
	}
	return mappaFinale;
}

public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
	Collections.sort(this.attrezzi, new Attrezzo.ComparatoreAttrezzi());
	SortedSet<Attrezzo>insiemeFinale=new TreeSet<>(this.attrezzi);
	return insiemeFinale;
}

}