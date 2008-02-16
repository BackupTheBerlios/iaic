package misionerosCanibales;

import problema.Estado;
import problema.Problema;

/**
 * @author gnufede
 *
 */
public class ProblemaMisionerosCanibales implements Problema {
	
	public ProblemaMisionerosCanibales(){
		super();
	}
	
	public int evaluaHeuristica(Estado e){
		return 0;		
	}
	
	public Estado getEstadoInicial(){
		return (new EstadoMisionerosCanibales(3,3,1));
	}
	
	public boolean esObjetivo(Estado e){
		EstadoMisionerosCanibales estadoObjetivo = new EstadoMisionerosCanibales(0,0,0);
		if (e.equals(estadoObjetivo))
			return true;
		else 
			return false;
	}
}
