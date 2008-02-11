package modelo.problema.canibales;

import modelo.problema.Estado;
import modelo.problema.Operador;

/**
 * Se tienen 3 Canibales y 3 Misioneros en la orilla izda (0) de  un rio y se pretende pasar a todos estos a la orilla dcha(1). En la barca pueden ir como máximo 2 personas, independientemente de que sean canibales o misioneros. RESTRICCIONES: no puede haber en cualquier orilla mayor numero de canibales que de misioneros, porque los primeros se comeran a los ultimos.*
 */

abstract class CanibalesOperador implements Operador{
	
	private CanibalesEstado inicial;

	public void setInicial(Estado inicial) {
		this.inicial = (CanibalesEstado) inicial;
	}
	
	/**
	 * @return  the inicial
	 * @uml.property  name="inicial"
	 */
	public Estado getInicial() {
		return this.inicial;
	}

	public int getCoste() {
		return 1;
	}

	protected CanibalesEstado EstadoFinal;
	public Estado getFinal() {
		if (EstadoFinal == null){
			calculaFinal();
		}
		return EstadoFinal;
	}

	protected	abstract	void	calculaFinal();

	public CanibalesOperador(CanibalesEstado inicial) {
		super();
		this.inicial = inicial;
	}

	

	

}
