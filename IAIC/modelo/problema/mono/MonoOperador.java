package modelo.problema.mono;

import modelo.problema.Estado;
import modelo.problema.Operador;

/** Hay un mono en la puerta de una habitacion. En el centro
 * hay un plátano colgando del techo. El mono lo quiere coger
 * pero no alcanza porque está muy alto. En la habitación
 * también hay una caja, pero al lado de la ventana.
 * El objetivo es que el mono coja el plátano con 4 posibles
 * movimientos: andar por el suelo; subirse a la caja;
 * empujar la caja (SI EL MONO ESTA EN LA MISMA POSICION QUE
 * LA CAJA) y coger el plátano (SI ESTA SUBIDO ENCIMA DE LA CAJA
 * Y LA CAJA ESTA JUSTO EN EL CENTRO, DEBAJO DEL PLÁTANO)*/

public abstract class MonoOperador implements Operador{
	
	private MonoEstado inicial;

	public Estado getInicial(){
		return inicial;
	}
	
	public void setInicial(Estado e){
		inicial = (MonoEstado) e;
	}
	public int getCoste(){
		return 1;
	}
	
	protected MonoEstado EstadoFinal;
	
	public Estado getFinal(){
		if (EstadoFinal == null){
			calculaFinal();
		}
		return EstadoFinal;
	}
	
	protected	abstract	void	calculaFinal();

	public MonoOperador(MonoEstado inicial) {
		super();
		this.inicial = inicial;
	}
	
	
	
	

}
