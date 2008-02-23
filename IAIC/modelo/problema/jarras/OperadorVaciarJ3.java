package modelo.problema.jarras;

import modelo.problema.Estado;

public class OperadorVaciarJ3 extends OperadorJarras{

	public OperadorVaciarJ3(EstadoJarras inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoJarras eFinal = (EstadoJarras)getInicial();
		estadoFinal = new EstadoJarras(0,eFinal.getJarra4());
		return estadoFinal;
	}
	
	public String getNombre(){
		return ("Vaciar jarra 3 litros");
	}
}
