package modelo.problema.problemaTesting;

import modelo.problema.Estado;
import modelo.problema.Operador;

/**
 * @author  Diego
 */
public class TestOperador implements	Operador {
	private		TestEstado	inicial;
	private		TestEstado	fin;
	private		int	coste;
	
	/**
	 * @return  the coste
	 * @uml.property  name="coste"
	 */
	public int getCoste() {
		return coste;
	}

	public Estado getFinal() {
		return fin;
	}

	/**
	 * @return  the inicial
	 * @uml.property  name="inicial"
	 */
	public Estado getInicial() {
		return inicial;
	}

	public String getNombre() {
		return "Operador entre " + inicial.mostrarInfo() + " " + fin.mostrarInfo();
	}

	public TestOperador(TestEstado inicial, TestEstado fin, int coste) {
		super();
		this.inicial = inicial;
		this.fin = fin;
		this.coste = coste;
	}

}
