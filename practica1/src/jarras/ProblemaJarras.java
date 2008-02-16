package jarras;

import problema.Estado;
import problema.Problema;

public class ProblemaJarras implements Problema{
	
	public ProblemaJarras(){
		super();
	}
	
	public int evaluaHeuristica(Estado e){
		return 0;		
	}
	
	public Estado getEstadoInicial(){
		return (new EstadoJarras(0,0));
	}
	
	public boolean esObjetivo(Estado e){
		if (((EstadoJarras)e).getJarra4() == 2)
			return true;
		else 
			return false;
	}
}
