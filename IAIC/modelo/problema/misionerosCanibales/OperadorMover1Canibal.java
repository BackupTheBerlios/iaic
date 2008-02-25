package modelo.problema.misionerosCanibales;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import modelo.problema.Estado;

public class OperadorMover1Canibal extends OperadorMisionerosCanibales{

	public OperadorMover1Canibal(EstadoMisionerosCanibales inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoMisionerosCanibales eFinal = (EstadoMisionerosCanibales)getInicial();
		int posB,numC;
		if (eFinal.getPosicionBarca() == 0){
			posB = 1;
			numC = eFinal.getNumCanibales()+1;
		}else{ 
			posB = 0;
			numC = eFinal.getNumCanibales()-1;
		}
		estadoFinal = new EstadoMisionerosCanibales(eFinal.getNumMisioneros(),numC,posB,eFinal.getTamMaxMisioneros(),eFinal.getTamMaxCanibales());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Mover un canibal");
	}
	
	public int getCoste(){
		return 1;
	}
}
