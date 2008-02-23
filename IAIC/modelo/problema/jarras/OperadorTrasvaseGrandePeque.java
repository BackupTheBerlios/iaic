package modelo.problema.jarras;

import modelo.problema.*;

public class OperadorTrasvaseGrandePeque extends OperadorJarras{
	
	public OperadorTrasvaseGrandePeque(EstadoJarras inicial){
		super(inicial);
	}
	int big = 0;
	int little = 0;
	public Estado transitar(){
		EstadoJarras eFinal = (EstadoJarras)getInicial();
		big = eFinal.getJGrande() - (3 - eFinal.getJPeque());
		if (big < 0)
			big = 0;
		little = eFinal.getJPeque() + big;
		if (big > 3)
			big = 3;
		estadoFinal = new EstadoJarras(little,big,eFinal.getTamP(),eFinal.getTamG());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Trasvase jarra de 4 litros a jarra de 3 litros");
	}
}