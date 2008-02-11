package modelo.problema.jarras;

import modelo.problema.Estado;
import modelo.problema.Operador;

/**
 * St tienen dos jarras, de cinco y tres litros de capacidad Conseguir, con el mínimo número de movimientos,  tener cuatro litros en la jarra grande
 */
public abstract class JarrasOperador implements Operador {
	private JarrasEstado	inicial;
	
	/**
	 * @return  the inicial
	 * @uml.property  name="inicial"
	 */
	public Estado getInicial() {
		return inicial;
	}

	public void setInicial(Estado e) {
		inicial = (JarrasEstado) e;
	}

	public int getCoste() {
		return 1;
	}

	protected	JarrasEstado	EstadoFinal;
	public Estado getFinal() {
		if (EstadoFinal == null){
			calculaFinal();
		}
		return EstadoFinal;
	}
	
	protected	abstract	void	calculaFinal();

	/**
	 * @param inicial
	 */
	public JarrasOperador(JarrasEstado inicial) {
		super();
		this.inicial = inicial;
	}
	
}
