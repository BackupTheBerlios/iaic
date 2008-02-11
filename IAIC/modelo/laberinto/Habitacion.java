package modelo.laberinto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * @author  Diego
 */
public class Habitacion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 882939467665125402L;
	private	int	numero;
	private	int	codigoProblema;
	private	int	ventanas;
	private	List<Puerta>	puertas;
	/**
	 * Este parámetro indica cual es la luminosidad de la habitación.
	 * 
	 * 
	 * */
	private	int	luminosidad;
	
	
	/**
	 * @return  the codigoProblema
	 * @uml.property  name="codigoProblema"
	 */
	public int getCodigoProblema() {
		return codigoProblema;
	}
	
	/**
	 * @return  the numero
	 * @uml.property  name="numero"
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @return  the luminosidad
	 * @uml.property  name="luminosidad"
	 */
	public int getLuminosidad() {
		return luminosidad;
	}

	/**
	 * @param luminosidad  the luminosidad to set
	 * @uml.property  name="luminosidad"
	 */
	public void setLuminosidad(int luminosidad) {
		this.luminosidad = luminosidad;
	}

	/**
	 * @return  the ventanas
	 * @uml.property  name="ventanas"
	 */
	public int getVentanas() {
		return ventanas;
	}

	/**
	 * @param ventanas  the ventanas to set
	 * @uml.property  name="ventanas"
	 */
	public void setVentanas(int ventanas) {
		this.ventanas = ventanas;
	}

	/**
	 * @param codigoProblema  the codigoProblema to set
	 * @uml.property  name="codigoProblema"
	 */
	public void setCodigoProblema(int codigoProblema) {
		this.codigoProblema = codigoProblema;
	}

	/**
	 * @param numero  the numero to set
	 * @uml.property  name="numero"
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	
	public Habitacion(int numero) {
		super();
		this.numero = numero;
		ventanas	=	0;
		luminosidad	=	Integer.MAX_VALUE;
		puertas		=	new	LinkedList<Puerta>();
	}
	
	public	boolean	isIgual(Habitacion h){
		return numero == h.numero;
	}

	/**
	 * @return  the puertas
	 * @uml.property  name="puertas"
	 */
	public List<Puerta> getPuertas() {
		return puertas;
	}
	
}
