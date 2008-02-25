package modelo;

import vista.OyenteVista;


/** Un Modelable es un objeto que es capaz lo primero de generar, 
 * guardar o cargar la información sobre los laberintos de la búsqueda.
 * En segundo lugar, es capaz de gestionar la ejecución de las búsquedas
 * tanto a nivel local como global.
 * */
public interface Modelable extends OyenteVista {
	
	/** Pide la información del cubo*/
	String	mostrarCubo();

	/** Pide la información de búsquedaGlobal */
	String	mostrarGlobal();

	/** Pide la información del búsquedaLocal*/
	String	mostrarLocal();
	
	boolean hayProblemasLocales();

}
