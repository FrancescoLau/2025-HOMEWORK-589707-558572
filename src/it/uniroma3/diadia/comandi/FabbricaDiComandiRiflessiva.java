package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi{
	private IO io;
	public FabbricaDiComandiRiflessiva(IO io) {
		this.io = io;}
		
	@Override
	public Comando costruisciComando(String istruzione) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		String comando=null;
		String parametro=null;
		Comando c=null;
		Scanner scannerIstruzione=new Scanner(istruzione);
		
		if(scannerIstruzione.hasNext()) comando=scannerIstruzione.next();
		if(scannerIstruzione.hasNext()) parametro=scannerIstruzione.next();
		
		StringBuilder classe = new StringBuilder("it.uniroma3.diadia.comandi.Comando");
		classe.append( Character.toUpperCase(comando.charAt(0)) );
		classe.append( comando.substring(1) );
		c = (Comando)Class.forName(classe.toString()).newInstance();
		c.setParametro(parametro);
		c.setIo(io);
		
		return c;
	}
}
