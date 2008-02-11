package modelo.busqueda;

import modelo.problema.Estado;
import modelo.problema.Operador;

public class Uniforme extends AlgoritmoPrioritario{
	
	private class NodoUni extends NodoInformado{
		public NodoUni(Estado e,int numero, NodoInformado padre,Operador op) {
			super(e,numero,op,padre);
		}
		
		protected StringBuffer mostrarCoste() {
			return new StringBuffer(
				"Coste: " + getCoste() + "\t" + 
				" f'(n) = " + (getCoste()) + "\n");
		}

		protected int getCriterio() {
			return getCoste();
		}
	}
	
	public Uniforme() {
		super();
	}

	protected String getNombreAlgoritmo() {
		return "Búsqueda Uniforme";
	}

	protected NodoInformado construyeNodo(Estado estado, int numero, NodoInformado padre, Operador opera) {
		return new NodoUni(estado,numero,padre,opera);
	}
	
}
