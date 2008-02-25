package modelo.problema.cubo;
import java.util.ArrayList;

import modelo.problema.cubo.EstadoCubo;

public class OperadorIzquierda extends OperadorCubo {
	public OperadorIzquierda(EstadoCubo inicial) {
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
		c.abrirPuerta(num+1000,this);
		EstadoFinal = c;
	}
	
	protected void transitarDelTodo (boolean transitado, ArrayList <Puerta> puertasAbiertas){
System.out.println("transitando la vuelta");
		
		if (transitado) {

			EstadoCubo c = (EstadoCubo)getInicial();
			int num = c.getNumHabitacion();
			EstadoFinal =  new EstadoCubo(c.getCubo(),num+10,puertasAbiertas);
	
		}
		estadoEstable = true;

	}

	
	
}
