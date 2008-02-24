package modelo.problema.misionerosCanibales;

import modelo.problema.Estado;

public class OperadorMover2Misioneros extends OperadorMisionerosCanibales{

	public OperadorMover2Misioneros(EstadoMisionerosCanibales inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoMisionerosCanibales eFinal = (EstadoMisionerosCanibales)getInicial();
		int posB, numM;
		if (eFinal.getPosicionBarca() == 0){
			posB = 1;
			numM = eFinal.getNumMisioneros()+2;
		}
		else{ 
			posB = 0;
			numM = eFinal.getNumMisioneros()-2;
		}		
		estadoFinal = new EstadoMisionerosCanibales(numM,eFinal.getNumCanibales(),posB,eFinal.getTamMaxMisioneros(),eFinal.getTamMaxCanibales());
		return estadoFinal;
	}

	public String toString(){
		return ("Mover dos misioneros");
	}
	
	public int getCoste(){
		return 1;
	}
}
