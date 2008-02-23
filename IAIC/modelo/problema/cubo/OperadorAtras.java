package modelo.problema.cubo;

import cubo.EstadoCubo;
import modelo.problema.granjero.GranjeroEstado;

public class OperadorAtras extends OperadorCubo{

	public OperadorAtras(EstadoCubo inicial) {
		super(inicial);
		// TODO Auto-generated constructor stub
	}
	
	public String getNombre() {
		return "Cruzamos la puerta de atras";
	}

	@Override
	protected void transitar() {
		EstadoCubo c = (EstadoCubo)getInicial();
		int aux = 0;
		if (aux == 0) aux = 1;
		else aux = 0;
		//EstadoFinal = new EstadoCubo(aux,c.getLO(),aux,c.getCO());
		EstadoFinal =  new EstadoCubo(c.getNumHabitacion()-1,abrirPuerta(num-1+2000,puertas));
		
		
	}

}
