package modelo.busqueda;
import java.util.Stack;


 class Profundidad extends AlgoritmoCiego {
	
	/* Uso de una PILA para los nodos abiertos */	
	private	Stack<NodoCiego>	abiertos;  
	
	public Profundidad() {
		super();
		abiertos	=	new	Stack<NodoCiego>();
	}

	protected String getNombreAlgoritmo() {
		return " Profundidad " ;
	}

	protected boolean quedanAbiertos() {
		return ! abiertos.isEmpty();
	}

	protected void añadirAbierto(NodoCiego n) {
		abiertos.push(n);		
	}

	protected NodoCiego sacaAbierto() {
		return abiertos.pop();
	}

	protected boolean estaEnAbiertos(NodoCiego n) {
		return abiertos.contains(n);
	}

	protected void vaciaAbiertos() {
		abiertos.clear();		
	}

}
