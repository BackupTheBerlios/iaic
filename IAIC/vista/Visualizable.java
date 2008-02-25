package vista;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */

/** Un Visualizable es una interfaz de Usuario capaz de mostrarle a �ste
 * la informaci�n sobre un Laberinto o sobre la s b�squedas global y local, 
 * por los canales m�s convenientes para ello.
 * 
 * Tambi�n es capaz de pedirle al usuario que escoja un algoritmo 
 * de entre una lista que se presume impl�cita, as� como
 * alterar su estado en respuesta a ciertos eventos externos*/

public interface Visualizable {
	/** Le pide a la vista que le de el algoritmo que se va a usar.
	 * @return el objeto que representa el algoritmo escogido. */
	Object	escogeAlgoritmo();

	/** Manda a la vista que se ponga en el modo sin laberinto*/
	void	atiendeSinCubo();
	/** Manda al visualizable que se ponga en el modo de estar con 
	 * un laberinto pero sin ejecuci�n*/
	void	atiendeConCubo();
	
	/** Manda al visualizable que se prepare p�ra estar en modo
	 * de ejecuci�n Local.*/
	void	atiendeEjecutandoLocal();

	/** Avisa al visualizable de que se prepare para 
	 * estar en modo de elecuci�n global*/
	void atiendeEjecutandoGlobal();

	/** Avisa al visualizable de que la b�squeda global ha terminado, 
	 * para que act�e en consecuencia.*/
	void	atiendeFinGlobal();
	
	/** Avisa al visualizable de que la b�squeda local ha terminado, 
	 * para que act�e en consecuencia.*/
	void	atiendeFinLocal();
	
	/** Manda   que imprima la informaci�n 	 del Laberinto.
	 * @param infoLab la informaci�n que hay que imprimir*/
	void	muestraCubo(String infoLab);
	
	/** Manda imprimir la informaci�n sobre la b�squeda global
	 * @param infoGlob la informaci�n que hay que imprimir.*/
	void	muestraGlobal(String infoGlob);
	
	/** Manda al Visualizable que imprima la informaci�n 
	 * sobre la b�squeda local.
	 * @param infoLoc la informaci�n que hay que imprimir*/
	void	muestraLocal(String infoLoc);

}
