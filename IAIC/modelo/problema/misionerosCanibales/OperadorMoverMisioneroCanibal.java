package modelo.problema.misionerosCanibales;

import modelo.problema.Estado;

public class OperadorMoverMisioneroCanibal extends OperadorMisionerosCanibales{

	public OperadorMoverMisioneroCanibal(EstadoMisionerosCanibales inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoMisionerosCanibales eFinal = (EstadoMisionerosCanibales)getInicial();
		int posB,numM,numC;
		if (eFinal.getPosicionBarca() == 0){
			posB = 1;
			numM = eFinal.getNumMisioneros()+1;
			numC = eFinal.getNumCanibales()+1;
		}
		else{ 
			posB = 0;
			numM = eFinal.getNumMisioneros() - 1;
			numC = eFinal.getNumCanibales() - 1;
		}
		estadoFinal = new EstadoMisionerosCanibales(numM,numC,posB,eFinal.getTamMaxMisioneros(),eFinal.getTamMaxCanibales());
		return estadoFinal;
	}

	public String toString(){
		return ("Mover un misionero y un canibal");
	}
	
	public int getCoste(){
		return 1;
	}
}
