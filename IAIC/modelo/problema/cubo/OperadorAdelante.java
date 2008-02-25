package modelo.problema.cubo;
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
		EstadoCubo c = (EstadoCubo)getInicial();//Aqui estoy
		int num = c.getNumHabitacion();
		//EstadoFinal = new EstadoCubo(aux,c.getLO(),aux,c.getCO());
		ArrayList<Puerta> aux = c.abrirPuerta(num+2000);
		if (aux.isEmpty()) EstadoFinal = (EstadoCubo)getInicial();
		else EstadoFinal =  new EstadoCubo(c.getCubo(),num+1,aux);
	}
}
