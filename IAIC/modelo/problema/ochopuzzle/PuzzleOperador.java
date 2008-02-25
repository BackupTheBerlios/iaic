package modelo.problema.ochopuzzle;

import modelo.problema.Estado;
import modelo.problema.Operador;

/**
 * Se tiene un tablero de 3x3 con los numeros del 1 al 8, ambos inclusive y un hueco pero desordenados, el objetivo es ordenarlos de izquierda a derecha y de arriba a abajo moviendo las fichas hacia el hueco.
 */
public abstract class PuzzleOperador implements Operador {
	private PuzzleEstado	inicial;
	
	/**
	 * @return  the inicial
	 * @uml.property  name="inicial"
	 */
	public Estado getInicial() {
		return inicial;
	}

	public void setInicial(Estado e) {
		inicial = (PuzzleEstado) e;
	}

	public int getCoste() {
		return 1;
	}

	protected	PuzzleEstado	EstadoFinal;
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
	public PuzzleOperador(PuzzleEstado inicial) {
		super();
		this.inicial = inicial;
	}
	
	public boolean isEstadoEstable() {
		return true;
	}
	
}
