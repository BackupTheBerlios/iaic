package modelo.problema.cubo;

import modelo.problema.cubo.EstadoCubo;

public class OperadorAtras extends OperadorCubo{

	public OperadorAtras(EstadoCubo inicial) {
		super(inicial);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Cruzamos la puerta de atras";
	}

	@Override
	protected void transitar() {
		EstadoCubo c = (EstadoCubo)getInicial();//Aqui estoy
		int num = c.getNumHabitacion();
		EstadoFinal =  new EstadoCubo(c.getCubo(),num-1,c.abrirPuerta(num-1+2000));

	}

}
