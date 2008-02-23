package modelo.problema.jarras;

import modelo.problema.Estado;

public class OperadorVaciarJarraGrande extends OperadorJarras{
	
	public OperadorVaciarJarraGrande(EstadoJarras inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoJarras eFinal = (EstadoJarras)getInicial();
		estadoFinal = new EstadoJarras(eFinal.getJPeque(),0,eFinal.getTamP(),eFinal.getTamG());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Vaciar jarra 4 litros");
	}
}
