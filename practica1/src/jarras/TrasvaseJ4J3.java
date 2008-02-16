package jarras;

import problema.Estado;

public class TrasvaseJ4J3 extends OperadorJarras{
	
	public TrasvaseJ4J3(EstadoJarras inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoJarras eFinal = (EstadoJarras)getEstadoInicial();
		int big = eFinal.getJarra4() - (3 - eFinal.getJarra3());
		if (big < 0)
			big = 0;
		int little = eFinal.getJarra3() + big;
		if (big > 4)
			big = 4;
		estadoFinal = new EstadoJarras(little,big);
		return estadoFinal;
	}
}