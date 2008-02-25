package modelo.problema.cubo;
import java.util.ArrayList;

import modelo.problema.cubo.EstadoCubo;

public class OperadorIzquierda extends OperadorCubo {
	private int numPuerta;
	public OperadorIzquierda(EstadoCubo inicial) {
		super(inicial);
		numPuerta = inicial.getNumHabitacion()+1000;
		
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Cruzamos la puerta de atras: "+numPuerta;
	}

	@Override
	protected void transitar() {
		EstadoCubo c = (EstadoCubo)getInicial();//Aqui estoy
		int num = c.getNumHabitacion();		
		ArrayList<Puerta> aux = c.abrirPuerta(num+1000);
		if (aux.isEmpty()) EstadoFinal = (EstadoCubo)getInicial();
		else EstadoFinal =  new EstadoCubo(c.getCubo(),num+10,aux);

	}
	
	public int getCoste(){
		return 1;
	}
}
