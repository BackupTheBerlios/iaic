package modelo.problema.misionerosCanibales;

import modelo.problema.Estado;

public class OperadorMover1Canibal extends OperadorMisionerosCanibales{

	public OperadorMover1Canibal(EstadoMisionerosCanibales inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoMisionerosCanibales eFinal = (EstadoMisionerosCanibales)getInicial();
		int posB;
		if (eFinal.getPosicionBarca() == 0)
			posB = 1;
		else 
			posB = 0;
		estadoFinal = new EstadoMisionerosCanibales(eFinal.getNumMisioneros(),eFinal.getNumCanibales()-1,posB);
		return estadoFinal;
	}
	
	public String toString(){
		return ("Mover un canibal");
	}
	
	public int getCoste(){
		return 1;
	}
}
