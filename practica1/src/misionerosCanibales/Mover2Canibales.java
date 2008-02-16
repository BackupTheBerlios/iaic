package misionerosCanibales;

import problema.Estado;

public class Mover2Canibales extends OperadorMisionerosCanibales{

	public Mover2Canibales(EstadoMisionerosCanibales inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoMisionerosCanibales eFinal = (EstadoMisionerosCanibales)getEstadoInicial();
		int posB;
		if (eFinal.getPosicionBarca() == 0)
			posB = 1;
		else 
			posB = 0;
		estadoFinal = new EstadoMisionerosCanibales(eFinal.getNumMisioneros(),eFinal.getNumCanibales()-2,posB);
		return estadoFinal;
	}
}
