package modelo.busqueda;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
public interface IAlgoritmoServidor {
	
	/** Permite pedirle al servidor que devuelva el objeto algoritmo
	 * que se corresponde con la selección representada por el objeto 
	 * obj.*/
	public	AlgoritmoAbstracto	dameAlgoritmo(Object	obj);
	
	public	Object[]	dameListaAlgoritmos();

}
