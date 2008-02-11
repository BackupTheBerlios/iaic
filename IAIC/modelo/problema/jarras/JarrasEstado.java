package modelo.problema.jarras;

import java.util.LinkedList;
import java.util.List;
import modelo.problema.Estado;
import modelo.problema.Operador;

/**
 * @author  Diego
 */
public class JarrasEstado implements Estado {

	/** Este es el numero de litros en la jarra de 5 litros */
	private int mayor;
	private int menor;
	
	/**
	 * @param mayor
	 * @param menor
	 */
	public JarrasEstado(int mayor, int menor) {
		super();
		this.mayor = mayor;
		this.menor = menor;
	}

	/**
	 * @return  the mayor
	 * @uml.property  name="mayor"
	 */
	public int getMayor() {
		return mayor;
	}

	/**
	 * @param mayor  the mayor to set
	 * @uml.property  name="mayor"
	 */
	public void setMayor(int mayor) {
		this.mayor = mayor;
	}

	/**
	 * @return  the menor
	 * @uml.property  name="menor"
	 */
	public int getMenor() {
		return menor;
	}

	/**
	 * @param menor  the menor to set
	 * @uml.property  name="menor"
	 */
	public void setMenor(int menor) {
		this.menor = menor;
	}

	public String mostrarInfo() {
		return "Jarra de 5 litros: " + mayor + "\nJarra de 3 litros: " + menor + "\n";
	}

	public List<Operador> getOperadoresAplicables() {
		List<Operador>	lista	=	new	LinkedList<Operador>();
		if (mayor < 5){
			lista.add(new JarrasOperadorLlenaGrande(this));
		}
		if(mayor > 0){
			lista.add(new JarrasOperadorVaciarGrande(this));
		}
		if (menor < 3){
			lista.add(new JarrasOperadorLlenarPequena(this));
		}
		if (menor > 0){
			lista.add(new JarrasOperadorVaciarPequena(this));
		}
		
		if ((mayor > 0) && (menor < 3)) {
			lista.add(new JarrasOperadorPasarGP(this));			
		}
		if ((mayor < 5) && (menor > 0)) {
			lista.add(new JarrasOperadorPasarPG(this));			
		}
		return lista;
	}

	public boolean equals(Object e) {
		JarrasEstado j = (JarrasEstado) e;
		return (this.mayor == j.mayor) && (this.menor == j.menor);
	}

	public Estado getCopia() {
		return new JarrasEstado(mayor,menor);
	}

	public int getHeuristica() {
		return 0;
	}

}
