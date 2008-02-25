package modelo.problema.cubo;
import java.util.ArrayList;

import modelo.problema.cubo.EstadoCubo;

public class OperadorAdelante extends OperadorCubo  {
	public OperadorAdelante(EstadoCubo inicial) {
		super(inicial);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Cruzamos la puerta de adelante";
	}
	
	@Override	
	protected void transitar() {
		EstadoCubo c = (EstadoCubo)getInicial();//Aqui estoy
		int num = c.getNumHabitacion();
		c.abrirPuerta(num+2000,this);
		EstadoFinal = c;
	}
	
	protected void transitarDelTodo (boolean transitado,ArrayList <Puerta> puertasAbiertas){

System.out.println("transitando la vuelta");
		
		if (transitado) {
			EstadoCubo c = (EstadoCubo)getInicial();
			int num = c.getNumHabitacion();
			EstadoFinal =  new EstadoCubo(c.getCubo(),num+2000,puertasAbiertas);
		}
		this.estadoEstable = true;
	}

	
	
	
}
