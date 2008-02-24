package modelo.problema.misionerosCanibales;

import modelo.problema.Estado;

public class OperadorMover2Canibales extends OperadorMisionerosCanibales{

	public OperadorMover2Canibales(EstadoMisionerosCanibales inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoMisionerosCanibales eFinal = (EstadoMisionerosCanibales)getInicial();
		int posB, numC;
		if (eFinal.getPosicionBarca() == 0){
			posB = 1;
			numC = eFinal.getNumCanibales()+2;
		}
		else{ 
			posB = 0;
			numC = eFinal.getNumCanibales()-2;
		}
		estadoFinal = new EstadoMisionerosCanibales(eFinal.getNumMisioneros(),numC,posB,eFinal.getTamMaxMisioneros(),eFinal.getTamMaxCanibales());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Mover dos canibales");
	}
	
	public int getCoste(){
		return 1;
	}
}
