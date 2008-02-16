package jarras;

import problema.Estado;

public class TrasvaseJ3J4 extends OperadorJarras{
	
	public TrasvaseJ3J4(EstadoJarras inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoJarras eFinal = (EstadoJarras)getEstadoInicial();
		int little = eFinal.getJarra3() - (4 - eFinal.getJarra4());
		if (little < 0)
			little = 0;
		int big = eFinal.getJarra4() + (eFinal.getJarra3() - little);
		if (big > 4)
			big = 4;
		estadoFinal = new EstadoJarras(little,big);
		return estadoFinal;
	}
}
