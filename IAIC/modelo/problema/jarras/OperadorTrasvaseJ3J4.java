package modelo.problema.jarras;

import modelo.problema.Estado;

public class OperadorTrasvaseJ3J4 extends OperadorJarras{
	
	public OperadorTrasvaseJ3J4(EstadoJarras inicial){
		super(inicial);
	}
	int little = 0;
	int big = 0;
	public Estado transitar(){
		EstadoJarras eFinal = (EstadoJarras)getInicial();
		little = eFinal.getJarra3() - (4 - eFinal.getJarra4());
		if (little < 0)
			little = 0;
		big = eFinal.getJarra4() + (eFinal.getJarra3() - little);
		if (big > 4)
			big = 4;
		estadoFinal = new EstadoJarras(little,big);
		return estadoFinal;
	}
	
	public String getNombre(){
		return ("Trasvase de jarra de 3 litros a jarra de 4 litros");
	}
}
