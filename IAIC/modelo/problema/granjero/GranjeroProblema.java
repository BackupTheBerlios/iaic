package modelo.problema.granjero;

import modelo.problema.Estado;
import modelo.problema.Problema;

public class GranjeroProblema implements Problema{

	public Estado getInicial() {
		return new GranjeroEstado(0,0,0,0);
	}

	public int evaluarHeuristica(Estado e) {
		return 0;
	}

	public boolean esObjetivo(Estado e) {
		GranjeroEstado g = (GranjeroEstado) e;
		return (g.getCA() == 1) && (g.getCO() == 1) && (g.getGB() == 1) && (g.getLO() == 1);
	}

	public String getNombre() {
		return "Problema del Granjero la col la cabra y el lobo \n\n";
	}

}
