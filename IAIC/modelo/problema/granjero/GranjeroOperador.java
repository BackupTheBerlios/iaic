package modelo.problema.granjero;

import modelo.problema.Estado;
import modelo.problema.Operador;


/**
 * Se tienen un granjero con su bote, una col, una cabra y un  lobo en la orilla izquierda de un rio. El objetivo es que pasen a la orilla derecha del rio. RESTRICCIONES: deben cruzar en barca que debe ser tripulada por el granjero, y sólo pueden ir 2 en ella. El lobo se  come a la cabra si se les deja solos sin el granjero en una de las orillas, y la cabra se come a la col tambien si se  les deja solos sin el granjero.*
 */

abstract class GranjeroOperador implements Operador {
	
	private GranjeroEstado inicial;

	/**
	 * @return  the inicial
	 * @uml.property  name="inicial"
	 */
	public Estado getInicial() {
   		return inicial;
	}

	public void setInicial(Estado e) {
		inicial = (GranjeroEstado) e;
	}

	public int getCoste() {
		return 1;
	}

	protected	GranjeroEstado	EstadoFinal;
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
	public GranjeroOperador(GranjeroEstado inicial) {
		super();
		this.inicial = inicial;
	}

}
