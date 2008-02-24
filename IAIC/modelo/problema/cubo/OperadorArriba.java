package modelo.problema.cubo;

import java.util.ArrayList;

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
		c.abrirPuerta(num,this);
		EstadoFinal = c;
	}
	
	protected void transitarDelTodo (ArrayList <Puerta> puertasAbiertas){
		EstadoCubo c = (EstadoCubo)getInicial();
		int num = c.getNumHabitacion();
		EstadoFinal =  new EstadoCubo(c.getCubo(),num+100,puertasAbiertas);
	}

	
}
