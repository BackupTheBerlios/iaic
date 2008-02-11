package modelo.laberinto;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import modelo.problema.Estado;
import modelo.problema.Operador;

/**
 * @author  Diego
 */
class LaberintoEstado implements Estado {
	private	Habitacion	mihabitacion;
	private	LaberintoProblema	problema;
	
	public LaberintoEstado(Habitacion mihabitacion, LaberintoProblema problema) {
		super();
		this.mihabitacion = mihabitacion;
		this.problema = problema;
	}

	public String mostrarInfo() {
		return "Estoy en la habitación " + mihabitacion.getNumero() +  "\n";
	}

	public List<Operador> getOperadoresAplicables() {
		problema.visitar(this.getMihabitacion());
		
		List<Operador> res	=	new	LinkedList<Operador>();
		Iterator<Puerta> itera	=	mihabitacion.getPuertas().iterator();
		
		while (itera.hasNext()){
			res.add(new LaberintoOperador(this,itera.next()));
		}
		return res;
	}

	/** Dos estados del laberinto son iguales si 
	 * las habitaciones que contienen son iguales*/
	public boolean equals(Estado e) {
		LaberintoEstado l	=	(LaberintoEstado)e;
		return mihabitacion.isIgual( l.mihabitacion );
	}

	/** La heurística de un laberinto es la luminosidad
	 * de la habitación*/
	public int getHeuristica() {
		return mihabitacion.getLuminosidad();
	}

	/**
	 * @return  the mihabitacion
	 * @uml.property  name="mihabitacion"
	 */
	public Habitacion getMihabitacion() {
		return mihabitacion;
	}

	/**
	 * @return  the problema
	 * @uml.property  name="problema"
	 */
	public LaberintoProblema getProblema() {
		return problema;
	}

}
