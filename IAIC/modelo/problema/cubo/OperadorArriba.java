package modelo.problema.cubo;

import modelo.problema.cubo.EstadoCubo;

public class OperadorArriba extends OperadorCubo{


	public OperadorArriba(EstadoCubo inicial) {
		super(inicial);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Cruzamos la puerta de arriba";
	}

	@Override
	protected void transitar() {
		EstadoCubo c = (EstadoCubo)getInicial();//Aqui estoy
		int num = c.getNumHabitacion();
		EstadoFinal =  new EstadoCubo(c.getCubo(),num+100,c.abrirPuerta(num));

	}
}
