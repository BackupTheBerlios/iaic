package modelo.problema.jarras;

import modelo.problema.Estado;

public class OperadorLlenarJ4 extends OperadorJarras{
	
	public OperadorLlenarJ4(EstadoJarras inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoJarras eFinal = (EstadoJarras)getInicial();
		estadoFinal = new EstadoJarras(eFinal.getJarra3(),4);
		return estadoFinal;
	}
	
	public String getNombre(){
		return ("Llenar jarra 4 litros");
	}
}
