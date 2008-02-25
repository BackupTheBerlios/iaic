package modelo.busqueda;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import modelo.problema.Estado;
import modelo.problema.Operador;

class NodoCiego extends Nodo {

	public NodoCiego(Estado estado, int numero, Operador operador, Nodo padre) {
		super(estado, numero, operador, padre);
	}
	
	
	protected StringBuffer mostrarCoste() {
		return new StringBuffer();
	}

}
