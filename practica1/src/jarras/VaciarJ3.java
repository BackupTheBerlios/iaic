package jarras;

import problema.Estado;

public class VaciarJ3 extends OperadorJarras{

	public VaciarJ3(EstadoJarras inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoJarras eFinal = (EstadoJarras)getEstadoInicial();
		estadoFinal = new EstadoJarras(0,eFinal.getJarra4());
		return estadoFinal;
	}
}
