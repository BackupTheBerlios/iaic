package modelo.problema.misionerosCanibales;

import modelo.problema.Estado;

public class OperadorMover1Misionero extends OperadorMisionerosCanibales{

	public OperadorMover1Misionero(EstadoMisionerosCanibales inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoMisionerosCanibales eFinal = (EstadoMisionerosCanibales)getInicial();
		int posB,numM;
		if (eFinal.getPosicionBarca() == 0){
			posB = 1;
			numM = eFinal.getNumMisioneros()+1;
		}else{ 
			posB = 0;
			numM = eFinal.getNumMisioneros()-1;
		}
		estadoFinal = new EstadoMisionerosCanibales(numM,eFinal.getNumCanibales(),posB,eFinal.getTamMaxMisioneros(),eFinal.getTamMaxCanibales());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Mover un misionero");
	}
	
	public int getCoste(){
		return 1;
	}
}
