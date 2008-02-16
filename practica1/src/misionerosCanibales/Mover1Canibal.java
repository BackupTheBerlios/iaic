package misionerosCanibales;

import problema.Estado;

public class Mover1Canibal extends OperadorMisionerosCanibales{

	public Mover1Canibal(EstadoMisionerosCanibales inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoMisionerosCanibales eFinal = (EstadoMisionerosCanibales)getEstadoInicial();
		int posB;
		if (eFinal.getPosicionBarca() == 0)
			posB = 1;
		else 
			posB = 0;
		estadoFinal = new EstadoMisionerosCanibales(eFinal.getNumMisioneros(),eFinal.getNumCanibales()-1,posB);
		return estadoFinal;
	}
}
