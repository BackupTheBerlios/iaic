package modelo.problema.probprueba;

import modelo.problema.Estado;
import modelo.problema.Problema;



public class ProbpruebaProblema implements Problema {

	public Estado getInicial() {
		return new ProbpruebaEstado(1);
	}

	public int evaluarHeuristica(Estado e) {
		return 0;
	}

	public boolean esObjetivo(Estado e) {
		ProbpruebaEstado c = (ProbpruebaEstado) e;
		return (c.getID() == 1);
	}

	public String toString() {
		return "Problema de los Canibales y Misioneros.";
	}

}
