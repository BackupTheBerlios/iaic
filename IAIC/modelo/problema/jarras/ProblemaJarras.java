package modelo.problema.jarras;

import modelo.problema.Estado;
import modelo.problema.Problema;

public class ProblemaJarras implements Problema{
	private int litrosObjetivo;
	
	public ProblemaJarras(){
		super();
	}
	
	public int evaluarHeuristica(Estado e){
		return 0;		
	}
	
	public Estado getInicial(){
		return (new EstadoJarras(0,0));
	}
	
	public boolean esObjetivo(Estado e){
		if (((EstadoJarras)e).getJarra4() == litrosObjetivo)
			return true;
		else 
			return false;
	}
	
	public String	getNombre(){
		return ("Problema de las jarras");
	}
}
