package modelo.problema.misionerosCanibales;

import modelo.problema.Estado;

public class OperadorMover2Canibales extends OperadorMisionerosCanibales{

	public OperadorMover2Canibales(EstadoMisionerosCanibales inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoMisionerosCanibales eFinal = (EstadoMisionerosCanibales)getInicial();
		int posB;
		if (eFinal.getPosicionBarca() == 0)
			posB = 1;
		else 
			posB = 0;
		estadoFinal = new EstadoMisionerosCanibales(eFinal.getNumMisioneros(),eFinal.getNumCanibales()-2,posB);
		return estadoFinal;
	}
	
	public String toString(){
		return ("Mover dos canibales");
	}
	
	public int getCoste(){
		return 1;
	}
}
