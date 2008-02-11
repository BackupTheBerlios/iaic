package modelo.problema.problemaTesting;

import java.util.LinkedList;
import java.util.List;
import modelo.problema.Estado;
import modelo.problema.Operador;

/**
 * @author  Diego
 */
public class TestEstado implements Estado {

	private	char nombre;
	private	int	heuristica;
	private	List<Operador> operadores;
	
	public boolean equals(Object e) {
		return nombre	==	((TestEstado)e).nombre;
	}

	/**
	 * @return  the heuristica
	 * @uml.property  name="heuristica"
	 */
	public int getHeuristica() {
		return heuristica;
	}

	public List<Operador> getOperadoresAplicables() {
		return operadores;
	}

	public String mostrarInfo() {
		return "Estado  " + nombre + "\n";
	}

	public TestEstado(char nombre, int heuristica) {
		super();
		this.nombre = nombre;
		this.heuristica = heuristica;
		operadores	=	new	LinkedList<Operador>();
	}
	

}
