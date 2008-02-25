package modelo.problema.cubo;

import java.util.ArrayList;

import modelo.problema.cubo.EstadoCubo;

public class OperadorAtras extends OperadorCubo{

	
	public OperadorAtras(EstadoCubo inicial) {
		super(inicial);
		numPuerta = inicial.getNumHabitacion()+1999;
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Cruzamos la puerta de atras: "+numPuerta;
	}

	@Override
	protected void transitar() {
		EstadoCubo c = (EstadoCubo)getInicial();//Aqui estoy
		int num = c.getNumHabitacion();
		ArrayList<Puerta> aux = c.abrirPuerta(num-1+2000);
		if (aux.isEmpty()) EstadoFinal = (EstadoCubo)getInicial();
		else EstadoFinal =  new EstadoCubo(c.getCubo(),num-1,aux);

	}
	
	public int getCoste(){
		return 1;
	}

}
