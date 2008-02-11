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
	 * inicializa la b�squeda a tener un �rbol con un solo nodo*/
	abstract public void inicializar();

	/** Todos los algoritmos de b�squeda se basan en un bucle
	 * que reitera el proceso seleecci�n-expansi�n. Este m�todo es 
	 * como una vuelta del bucle. */
	abstract public void avanzarPaso();

}