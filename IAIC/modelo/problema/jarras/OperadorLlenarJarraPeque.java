package modelo.problema.jarras;

import modelo.problema.Estado;

public class OperadorLlenarJarraPeque extends OperadorJarras{
	
	public OperadorLlenarJarraPeque(EstadoJarras inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoJarras eFinal = (EstadoJarras)getInicial();
		estadoFinal = new EstadoJarras(eFinal.getTamP(),eFinal.getJGrande(),eFinal.getTamP(),eFinal.getTamG());
//		System.out.println("Transita: \n" + eFinal.toString() + "a\n" + estadoFinal.toString());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Llenar jarra 3 litros");
	}
}
