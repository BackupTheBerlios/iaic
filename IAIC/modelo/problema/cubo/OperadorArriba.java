package modelo.problema.cubo;

import java.util.ArrayList;

import modelo.problema.cubo.EstadoCubo;

public class OperadorArriba extends OperadorCubo{
	private int numPuerta;
	public OperadorArriba(EstadoCubo inicial) {
		super(inicial);
		numPuerta = inicial.getNumHabitacion();
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Cruzamos la puerta de arriba: "+numPuerta;
	}

	@Override
	protected void transitar() {
		EstadoCubo c = (EstadoCubo)getInicial();//Aqui estoy
		int num = c.getNumHabitacion();
		ArrayList<Puerta> aux = c.abrirPuerta(num);
		if (aux.isEmpty()) EstadoFinal = (EstadoCubo)getInicial();
		else EstadoFinal =  new EstadoCubo(c.getCubo(),num+100,aux);
	}
	
	public int getCoste(){
		return 1;
	}
}
