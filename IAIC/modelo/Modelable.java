package modelo;

import vista.OyenteVista;


/** Un Modelable es un objeto que es capaz lo primero de generar, 
 * guardar o cargar la informaci�n sobre los laberintos de la b�squeda.
 * En segundo lugar, es capaz de gestionar la ejecuci�n de las b�squedas
 * tanto a nivel local como global.
 * */
public interface Modelable extends OyenteVista {
	
	/** Pide la informaci�n del cubo*/
	String	mostrarCubo();

	/** Pide la informaci�n de b�squedaGlobal */
	String	mostrarGlobal();

	/** Pide la informaci�n del b�squedaLocal*/
	String	mostrarLocal();
	
	boolean hayProblemasLocales();

}
