package modelo.problema.jarras;

import modelo.problema.Estado;

public class OperadorLlenarJ3 extends OperadorJarras{
	
	public OperadorLlenarJ3(EstadoJarras inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoJarras eFinal = (EstadoJarras)getInicial();
		estadoFinal = new EstadoJarras(3,eFinal.getJarra4());
		return estadoFinal;
	}
	
	public String getNombre(){
		return ("Llenar jarra 3 litros");
	}
}
