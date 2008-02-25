package modelo.problema.cubo;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import java.util.ArrayList;

import modelo.problema.cubo.EstadoCubo;

public class OperadorIzquierda extends OperadorCubo {
	private int numPuerta;
	public OperadorIzquierda(EstadoCubo inicial) {
		super(inicial);
		numPuerta = inicial.getNumHabitacion()+1000;
	}
	
	public String toString() {
		return "Cruzamos la puerta de atras: "+numPuerta;
	}

	@Override
	protected void transitar() {
		EstadoCubo c = (EstadoCubo)getInicial();
		int num = c.getNumHabitacion();		
		ArrayList<Puerta> aux = c.abrirPuerta(num+1000);
		if (aux.isEmpty()) EstadoFinal = (EstadoCubo)getInicial();
		else EstadoFinal =  new EstadoCubo(c.getCubo(),num+10,aux);

	}
	
	public int getCoste(){
		return 1;
	}
}
