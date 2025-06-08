package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

public abstract class AbstractComando implements Comando{
	private String parametroComando;
	private IO io;
	private final static String NomeComando="Comando"; 
	
	
	public String getParametroComando() {
		return parametroComando;
	}
	public void setParametroComando(String parametroComando) {
		this.parametroComando = parametroComando;
	}
	public IO getIo() {
		return io;
	}
	public void setIo(IO io) {
		this.io = io;
	}
	public String getNome() {
		return this.NomeComando;
	}
	

}
