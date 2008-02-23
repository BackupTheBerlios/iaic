package modelo.problema.misionerosCanibales;

import modelo.problema.Estado;
import modelo.problema.Problema;

/**
 * @author gnufede
 *
 */
public class ProblemaMisionerosCanibales implements Problema {
	
	private int tamMaxMisioneros = 3;
	private int tamMaxCanibales = 3;
	
	public ProblemaMisionerosCanibales(boolean resoluble){
		super();
	}
	
	public int evaluarHeuristica(Estado e){
		return 0;		
	}
	
	public Estado getInicial(){
		return (new EstadoMisionerosCanibales(tamMaxMisioneros,tamMaxCanibales,1));
	}
	
	public boolean esObjetivo(Estado e){
		EstadoMisionerosCanibales estadoObjetivo = new EstadoMisionerosCanibales(0,0,0);
		if (e.equals(estadoObjetivo))
			return true;
		else 
			return false;
	}
	
	public String getNombre(){
		return "Problema de los Misioneros y los Canibales";
	}

	public int getTamMaxCanibales() {
		return tamMaxCanibales;
	}

	public void setTamMaxCanibales(int tamMaxCanibales) {
		this.tamMaxCanibales = tamMaxCanibales;
	}

	public int getTamMaxMisioneros() {
		return tamMaxMisioneros;
	}

	public void setTamMaxMisioneros(int tamMaxMisioneros) {
		this.tamMaxMisioneros = tamMaxMisioneros;
	}
}
