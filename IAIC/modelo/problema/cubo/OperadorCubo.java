package modelo.problema.cubo;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import java.util.ArrayList;

import modelo.problema.Estado;
import modelo.problema.Operador;



public abstract class OperadorCubo implements Operador  {
	protected int numPuerta;
	private EstadoCubo inicial;
	protected EstadoCubo EstadoFinal;
	
	public int getCoste() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Estado getFinal() {
		if (EstadoFinal == null){
			transitar();
		}
		return EstadoFinal;
	}
	
	protected abstract void transitar();

	
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
	}


}
