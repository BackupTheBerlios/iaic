package modelo.laberinto;

import java.io.Serializable;

/**
 * Una puerta conecta dos habitaciones. En nuestro laberinto,  una puerta tiene una cara de color rojo y una cara de color azul.
 */
public class Puerta implements	Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8980161968504277301L;

	/** En qué habitación está la cara roja.*/
	private	Habitacion	rosa;
	
	/** En qué habitación está la cara azul */
	private	Habitacion	verde;

	public Puerta(Habitacion verde, Habitacion rosa) {
		super();
		this.verde = verde;
		this.rosa = rosa;
		verde.getPuertas().add(this);
		rosa.getPuertas().add(this);
	}

	/** El método tiene la semántica: 
	 * "Quiero cruzar esta puerta entrando desde la habitación hab.
	 * Si hab es el anverso, " */
	public	Habitacion	cruzar(Habitacion hab){
		Habitacion h;
		if (hab == verde){
			h	=	rosa;
		} else if (hab == rosa){
			h	=	verde;
		} else {
			h = null;
		}
		return h;		
	}

	/**
	 * @return  the rosa
	 * @uml.property  name="rosa"
	 */
	public Habitacion getRosa() {
		return rosa;
	}

	/**
	 * @return  the verde
	 * @uml.property  name="verde"
	 */
	public Habitacion getVerde() {
		return verde;
	}

	public String muestra() {
		return "Puerta entre\t" + rosa.getNumero() + "," + verde.getNumero() + "\n";
	}
	
	
}
