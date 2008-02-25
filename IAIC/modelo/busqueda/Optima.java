package modelo.busqueda;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import modelo.problema.Estado;
import modelo.problema.Operador;

class Optima extends AlgoritmoPrioritario {
	
	private class NodoOpt extends NodoInformado {		
		
		public NodoOpt(Estado e,int num,  NodoInformado padre,Operador op) {
			super(e,num,op,padre);						
		}
		
		protected StringBuffer mostrarCoste() {
			return new StringBuffer(
				"Coste: " + getCoste() + "\t" + 
				"Heuristica: "  + getHeuristica() + "\t" + 
				" f'(n) = " + (getCoste() + getHeuristica()) + "\n");
		}

		protected int getCriterio() {
			return coste + getHeuristica();
		}	
	}
	
	public Optima() {
		super();
	}
	
	protected String getNombreAlgoritmo() {
		return "Búsqueda óptima";
	}
	
	protected NodoInformado construyeNodo(Estado estado, int numero, NodoInformado padre, Operador opera) {
		return new NodoOpt(estado,numero,padre,opera);
	}

}
