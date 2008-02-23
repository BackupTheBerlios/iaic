package modelo.problema.jarras;

import modelo.problema.Estado;
import modelo.problema.Problema;

public class ProblemaJarras implements Problema{
	private int tamPeque = 3;
	private int tamGrande = 4;
	private int litrosObjetivo;
	
	public ProblemaJarras(boolean resoluble){
		super();
		if (resoluble)
			litrosObjetivo = 2;
		else
			litrosObjetivo = 5;
	}
	
	public int evaluarHeuristica(Estado e){
		return 0;		
	}
	
	public Estado getInicial(){
		return (new EstadoJarras(0,0,tamPeque,tamGrande));
	}
	
	public boolean esObjetivo(Estado e){
		if (((EstadoJarras)e).getJGrande() == litrosObjetivo)
			return true;
		else 
			return false;			
	}
	
	public String	getNombre(){
		return ("Problema de las jarras");
	}

	public int getLitrosObjetivo() {
		return litrosObjetivo;
	}

	public void setLitrosObjetivo(int litrosObjetivo) {
		this.litrosObjetivo = litrosObjetivo;
	}

	public int getTamGrande() {
		return tamGrande;
	}

	public void setTamGrande(int tamGrande) {
		this.tamGrande = tamGrande;
	}

	public int getTamPeque() {
		return tamPeque;
	}

	public void setTamPeque(int tamPeque) {
		this.tamPeque = tamPeque;
	}
}
