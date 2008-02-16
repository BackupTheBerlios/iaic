package misionerosCanibales;

import problema.Estado;

public class Mover2Misioneros extends OperadorMisionerosCanibales{

	public Mover2Misioneros(EstadoMisionerosCanibales inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoMisionerosCanibales eFinal = (EstadoMisionerosCanibales)getEstadoInicial();
		int posB;
		if (eFinal.getPosicionBarca() == 0)
			posB = 1;
		else 
			posB = 0;
		estadoFinal = new EstadoMisionerosCanibales(eFinal.getNumMisioneros()- 2,eFinal.getNumCanibales(),posB);
		return estadoFinal;
	}

}
