package modelo.busqueda;

import java.util.LinkedList;
import java.util.Queue;

class Anchura extends AlgoritmoCiego{
	private	Queue<NodoCiego>	abiertos;
	public Anchura() {
		super();
		abiertos	=	new	LinkedList<NodoCiego>();
	}

	protected String getNombreAlgoritmo() {
		return " Anchura " ;
	}

	protected boolean quedanAbiertos() {
		return ! abiertos.isEmpty();
	}

	protected void añadirAbierto(NodoCiego n) {
		abiertos.add(n);		
	}

	protected NodoCiego sacaAbierto() {
		return abiertos.poll();
	}

	protected boolean estaEnAbiertos(NodoCiego n) {
		return abiertos.contains(n);
	}

	protected void vaciaAbiertos() {
		abiertos.clear();
	}
}
