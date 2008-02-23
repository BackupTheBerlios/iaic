package modelo.problema.jarras;

import modelo.problema.*;

public class OperadorTrasvaseJ4J3 extends OperadorJarras{
	
	public OperadorTrasvaseJ4J3(EstadoJarras inicial){
		super(inicial);
	}
	int big = 0;
	int little = 0;
	public Estado transitar(){
		EstadoJarras eFinal = (EstadoJarras)getInicial();
		big = eFinal.getJarra4() - (3 - eFinal.getJarra3());
		if (big < 0)
			big = 0;
		little = eFinal.getJarra3() + big;
		if (big > 3)
			big = 3;
		estadoFinal = new EstadoJarras(little,big);
		return estadoFinal;
	}
	
	public String getNombre(){
		return ("Trasvase jarra de 4 litros a jarra de 3 litros");
	}
}