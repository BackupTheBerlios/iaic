package modelo.busqueda;

public interface IAlgoritmoServidor {
	
	/** Permite pedirle al servidor que devuelva el objeto algoritmo
	 * que se corresponde con la selecci�n representada por el objeto 
	 * obj.*/
	public	AlgoritmoAbstracto	dameAlgoritmo(Object	obj);
	
	public	Object[]	dameListaAlgoritmos();

}
