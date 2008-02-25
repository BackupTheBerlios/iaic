package modelo.problema.cubo;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import java.util.ArrayList;

import modelo.problema.cubo.EstadoCubo;

public class OperadorAdelante extends OperadorCubo  {
	private int numPuerta;
	public OperadorAdelante(EstadoCubo inicial) {
		super(inicial);
		// TODO Auto-generated constructor stub
		numPuerta = inicial.getNumHabitacion()+2000;
	}
	
	public String toString() {
		return "Cruzamos la puerta de adelante: "+numPuerta;
	}
	
	@Override
	protected void transitar() {
		EstadoCubo c = (EstadoCubo)getInicial();
		int num = c.getNumHabitacion();
		ArrayList<Puerta> aux = c.abrirPuerta(num+2000);
		if (aux.isEmpty()) EstadoFinal = (EstadoCubo)getInicial();
		else EstadoFinal =  new EstadoCubo(c.getCubo(),num+1,aux);
	}
	
	public int getCoste(){
		return 1;
	}
}
