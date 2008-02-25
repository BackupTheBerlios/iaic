package modelo.problema.cubo;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import java.util.ArrayList;

import modelo.problema.cubo.EstadoCubo;

public class OperadorAbajo extends OperadorCubo  {

	private int numPuerta;
	
	public OperadorAbajo(EstadoCubo inicial) {
		super(inicial);
		numPuerta = inicial.getNumHabitacion()-100;
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Cruzamos la puerta de abajo: "+numPuerta;
	}

	@Override
	protected void transitar() {
		EstadoCubo c = (EstadoCubo)getInicial();
		int num = c.getNumHabitacion();
		ArrayList<Puerta> aux = c.abrirPuerta(num-100);
		if (aux.isEmpty()) EstadoFinal = (EstadoCubo)getInicial();
		else EstadoFinal =  new EstadoCubo(c.getCubo(),num-100,aux);
	}
	
	public int getCoste(){
		return 1;
	}

}
