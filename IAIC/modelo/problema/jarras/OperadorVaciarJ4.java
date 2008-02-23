package modelo.problema.jarras;

import modelo.problema.Estado;

public class OperadorVaciarJ4 extends OperadorJarras{
	
	public OperadorVaciarJ4(EstadoJarras inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoJarras eFinal = (EstadoJarras)getInicial();
		estadoFinal = new EstadoJarras(eFinal.getJarra3(),0);
		return estadoFinal;
	}
	
	public String getNombre(){
		return ("Vaciar jarra 4 litros");
	}
}
