package jarras;

import problema.Estado;

public class LlenarJ4 extends OperadorJarras{
	
	public LlenarJ4(EstadoJarras inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoJarras eFinal = (EstadoJarras)getEstadoInicial();
		estadoFinal = new EstadoJarras(eFinal.getJarra3(),4);
		return estadoFinal;
	}
}
