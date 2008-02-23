package modelo.problema.jarras;

import modelo.problema.Estado;

public class OperadorVaciarJarraPeque extends OperadorJarras{

	public OperadorVaciarJarraPeque(EstadoJarras inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoJarras eFinal = (EstadoJarras)getInicial();
		estadoFinal = new EstadoJarras(0,eFinal.getJGrande());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Vaciar jarra 3 litros");
	}
}
