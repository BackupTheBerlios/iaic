package modelo.busqueda;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import modelo.problema.Estado;
import modelo.problema.Operador;


abstract class Nodo {
	protected	Nodo padre;
	protected int numero;
	protected Estado estado;
	protected Operador operador;
	protected int coste;


	/**
	 * @param padre  the padre to set
	 * @uml.property  name="padre"
	 */
	public void setPadre(Nodo padre) {
		this.padre = padre;
	}
	/**
	 * @return  the padre
	 * @uml.property  name="padre"
	 */
	public Nodo getPadre(){
		return padre;
	}
	
	/**
	 * @return  the numero
	 * @uml.property  name="numero"
	 */
	public int getNumero() {
		return numero;
	}
	/**
	 * @param numero  the numero to set
	 * @uml.property  name="numero"
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return  the estado
	 * @uml.property  name="estado"
	 */
	public Estado getEstado() {
		return estado;
	}
	
	/**
	 * @return  the operador
	 * @uml.property  name="operador"
	 */
	public Operador getOperador() {
		return operador;
	}
	
	/**
	 * @return  the coste
	 * @uml.property  name="coste"
	 */
	public int getCoste() {
		return coste;
	}
	
	public boolean equals(Object o) {
		Nodo n = (Nodo) o;
		return estado.equals(n.estado);
	}


	public StringBuffer muestra() {
		StringBuffer	res	=	new	StringBuffer();
		res.append("Nodo de busqueda numero " + numero + "\n");
		if (padre == null){
			res.append("Es el nodo inicial, la raiz del arbol\n");				
		} else {
			res.append("Nodo Padre: " + getPadre().numero + "\n");
			res.append("Operador aplicado: " + operador.toString() + "\n");
			res.append(mostrarCoste()); // Mostrar el coste del camino menor
		}
		res.append("Estado del nodo:\n" + estado.mostrarInfo() + "\n");		
		return res;
	}
	

	/**  * Constructora con parametros.
	 * @param estado
	 * @param numero
	 * @param operador
	 * @param padre  */
	public Nodo(Estado estado, int numero, Operador operador, Nodo padre) {
		super();
		this.estado = estado;
		this.numero = numero;
		this.operador = operador;
		this.padre = padre;
		if (padre!=null){
			this.coste = padre.getCoste() + operador.getCoste();
		} else {
			this.coste =0;
		}
	}

	abstract protected StringBuffer mostrarCoste();

}
