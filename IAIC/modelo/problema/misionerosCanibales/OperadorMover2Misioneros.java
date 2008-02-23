package modelo.problema.misionerosCanibales;

import modelo.problema.Estado;

public class OperadorMover2Misioneros extends OperadorMisionerosCanibales{

	public OperadorMover2Misioneros(EstadoMisionerosCanibales inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoMisionerosCanibales eFinal = (EstadoMisionerosCanibales)getInicial();
		int posB;
		if (eFinal.getPosicionBarca() == 0)
			posB = 1;
		else 
			posB = 0;
		estadoFinal = new EstadoMisionerosCanibales(eFinal.getNumMisioneros()- 2,eFinal.getNumCanibales(),posB);
		return estadoFinal;
	}

	public String toString(){
		return ("Mover un canibal");
	}
	
	public int getCoste(){
		return 1;
	}
}
