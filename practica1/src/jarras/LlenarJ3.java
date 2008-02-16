package jarras;

import problema.Estado;

public class LlenarJ3 extends OperadorJarras{
	
	public LlenarJ3(EstadoJarras inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoJarras eFinal = (EstadoJarras)getEstadoInicial();
		estadoFinal = new EstadoJarras(3,eFinal.getJarra4());
		return estadoFinal;
	}
}
