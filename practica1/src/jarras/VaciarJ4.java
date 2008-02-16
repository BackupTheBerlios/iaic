package jarras;

import problema.Estado;

public class VaciarJ4 extends OperadorJarras{
	
	public VaciarJ4(EstadoJarras inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoJarras eFinal = (EstadoJarras)getEstadoInicial();
		estadoFinal = new EstadoJarras(eFinal.getJarra3(),0);
		return estadoFinal;
	}
}
