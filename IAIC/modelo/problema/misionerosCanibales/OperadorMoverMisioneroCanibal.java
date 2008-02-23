package modelo.problema.misionerosCanibales;

import modelo.problema.Estado;

public class OperadorMoverMisioneroCanibal extends OperadorMisionerosCanibales{

	public OperadorMoverMisioneroCanibal(EstadoMisionerosCanibales inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoMisionerosCanibales eFinal = (EstadoMisionerosCanibales)getInicial();
		int posB;
		if (eFinal.getPosicionBarca() == 0)
			posB = 1;
		else 
			posB = 0;
		estadoFinal = new EstadoMisionerosCanibales(eFinal.getNumMisioneros()-1,eFinal.getNumCanibales()-1,posB);
		return estadoFinal;
	}

	public String toString(){
		return ("Mover un misionero y un canibal");
	}
	
	public int getCoste(){
		return 1;
	}
}
