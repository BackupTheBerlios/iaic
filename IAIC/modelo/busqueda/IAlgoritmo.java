package modelo.busqueda;

import modelo.problema.Problema;

/**
 * @author  Diego
 */
public interface IAlgoritmo {

	/**
	 * @param p
	 * @uml.property  name="problema"
	 */
	abstract public void		setProblema(Problema p);
	abstract public Problema	getProblema();
	
	abstract public String muestra();

	abstract public boolean estaResuelto();

	/** La orden de reiniciar, en todos los algoritmos, es la que 
	 * inicializa la búsqueda a tener un árbol con un solo nodo*/
	abstract public void inicializar();

	/** Todos los algoritmos de búsqueda se basan en un bucle
	 * que reitera el proceso seleección-expansión. Este método es 
	 * como una vuelta del bucle. */
	abstract public void avanzarPaso();

}