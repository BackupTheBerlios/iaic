package modelo.problema.cubo;

import java.util.ArrayList;

import modelo.problema.Estado;
import modelo.problema.Operador;



public abstract class OperadorCubo implements Operador  {

	private EstadoCubo inicial;
	protected EstadoCubo EstadoFinal;
	protected boolean estadoEstable;
	
	public boolean isEstadoEstable() {
		return estadoEstable;
	}
	
	public int getCoste() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Estado getFinal() {
		if (EstadoFinal == null){
			transitar();
			estadoEstable = false;
		}
		return EstadoFinal;
	}
	
	protected abstract void transitar();

	protected abstract void transitarDelTodo(boolean transitado, ArrayList <Puerta> puertasAbiertas);
	
	public void setInicial(Estado e) {
		inicial = (EstadoCubo) e;
	}

	
	public Estado getInicial() {
		// TODO Auto-generated method stub
		return inicial;
	}

	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public OperadorCubo (EstadoCubo inicial) {
		super();
		this.inicial = inicial;
		this.estadoEstable = false;
	}


}
