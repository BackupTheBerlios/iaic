package modelo.busqueda;

import modelo.problema.Estado;
import modelo.problema.Operador;

/**
 * @author  Diego
 */
abstract class NodoInformado extends Nodo implements  Comparable {
	private int heuristica;
	
	public NodoInformado(Estado estado, int numero, Operador operador,
			Nodo padre) {
		super(estado, numero, operador, padre);
		heuristica = estado.getHeuristica();		
	}
	
	/**
	 * @return  the heuristica
	 * @uml.property  name="heuristica"
	 */
	public int getHeuristica() {
		return heuristica;
	}
	
	public	int	compareTo(Object o ){
		int res;
		NodoInformado n = (NodoInformado)o;
		if (getCriterio() < n.getCriterio()){
			res = -1;
		} else if (getCriterio() == n.getCriterio()) {
			res = 0;			
		} else {
			res = 1;
		}
		return res;
	}

	protected	abstract int getCriterio();

}
