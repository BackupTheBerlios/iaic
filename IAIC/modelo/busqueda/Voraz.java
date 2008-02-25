package modelo.busqueda;

import modelo.problema.Estado;
import modelo.problema.Operador;

class Voraz extends AlgoritmoPrioritario{
	
	class NodoVor extends NodoInformado {

		public NodoVor(Estado estado, int numero, Operador operador, NodoInformado padre) {
			super(estado, numero, operador, padre);
		}

		protected StringBuffer mostrarCoste() {
			return new StringBuffer(
				"Coste: " + getCoste() + "\t" + 
				"Heuristica: "  + getHeuristica() + "\t" + 
				" f'(n) = " + (getHeuristica()) + "\n");
		}

		protected int getCriterio() {
			return getHeuristica();
		}
		
	}
    
	public Voraz() {
		super();
	}
	
	protected String getNombreAlgoritmo() {
		return "Búsqueda Voraz Greedy";
	}

	protected NodoInformado construyeNodo(Estado estado, int numero, NodoInformado padre, Operador opera) {
		return new	NodoVor(estado, numero, opera,padre);
	}
	
}
