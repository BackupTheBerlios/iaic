package modelo.problema.jarras;

import modelo.problema.Estado;

public class OperadorLlenarJarraGrande extends OperadorJarras{
	
	public OperadorLlenarJarraGrande(EstadoJarras inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoJarras eFinal = (EstadoJarras)getInicial();
		estadoFinal = new EstadoJarras(eFinal.getJPeque(),eFinal.getTamG());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Llenar jarra 4 litros");
	}
}