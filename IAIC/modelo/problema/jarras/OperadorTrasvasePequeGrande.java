package modelo.problema.jarras;

import modelo.problema.Estado;

public class OperadorTrasvasePequeGrande extends OperadorJarras{
	
	public OperadorTrasvasePequeGrande(EstadoJarras inicial){
		super(inicial);
	}
	int little = 0;
	int big = 0;
	public Estado transitar(){
		EstadoJarras eFinal = (EstadoJarras)getInicial();
		little = eFinal.getJPeque() - (4 - eFinal.getJGrande());
		if (little < 0)
			little = 0;
		big = eFinal.getJGrande() + (eFinal.getJPeque() - little);
		if (big > 4)
			big = 4;
		estadoFinal = new EstadoJarras(little,big,eFinal.getTamP(),eFinal.getTamG());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Trasvase de jarra de 3 litros a jarra de 4 litros");
	}
}
