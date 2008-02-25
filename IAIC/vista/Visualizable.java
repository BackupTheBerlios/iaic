package vista;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */

/** Un Visualizable es una interfaz de Usuario capaz de mostrarle a éste
 * la información sobre un Laberinto o sobre la s búsquedas global y local, 
 * por los canales más convenientes para ello.
 * 
 * También es capaz de pedirle al usuario que escoja un algoritmo 
 * de entre una lista que se presume implícita, así como
 * alterar su estado en respuesta a ciertos eventos externos*/

public interface Visualizable {
	/** Le pide a la vista que le de el algoritmo que se va a usar.
	 * @return el objeto que representa el algoritmo escogido. */
	Object	escogeAlgoritmo();

	/** Manda a la vista que se ponga en el modo sin laberinto*/
	void	atiendeSinCubo();
	/** Manda al visualizable que se ponga en el modo de estar con 
	 * un laberinto pero sin ejecución*/
	void	atiendeConCubo();
	
	/** Manda al visualizable que se prepare pàra estar en modo
	 * de ejecución Local.*/
	void	atiendeEjecutandoLocal();

	/** Avisa al visualizable de que se prepare para 
	 * estar en modo de elecución global*/
	void atiendeEjecutandoGlobal();

	/** Avisa al visualizable de que la búsqueda global ha terminado, 
	 * para que actúe en consecuencia.*/
	void	atiendeFinGlobal();
	
	/** Avisa al visualizable de que la búsqueda local ha terminado, 
	 * para que actúe en consecuencia.*/
	void	atiendeFinLocal();
	
	/** Manda   que imprima la información 	 del Laberinto.
	 * @param infoLab la información que hay que imprimir*/
	void	muestraCubo(String infoLab);
	
	/** Manda imprimir la información sobre la búsqueda global
	 * @param infoGlob la información que hay que imprimir.*/
	void	muestraGlobal(String infoGlob);
	
	/** Manda al Visualizable que imprima la información 
	 * sobre la búsqueda local.
	 * @param infoLoc la información que hay que imprimir*/
	void	muestraLocal(String infoLoc);

}
