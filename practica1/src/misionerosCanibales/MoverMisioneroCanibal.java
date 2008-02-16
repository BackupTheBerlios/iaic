package misionerosCanibales;

import problema.Estado;

public class MoverMisioneroCanibal extends OperadorMisionerosCanibales{

	public MoverMisioneroCanibal(EstadoMisionerosCanibales inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoMisionerosCanibales eFinal = (EstadoMisionerosCanibales)getEstadoInicial();
		int posB;
		if (eFinal.getPosicionBarca() == 0)
			posB = 1;
		else 
			posB = 0;
		estadoFinal = new EstadoMisionerosCanibales(eFinal.getNumMisioneros()-1,eFinal.getNumCanibales()-1,posB);
		return estadoFinal;
	}

}
