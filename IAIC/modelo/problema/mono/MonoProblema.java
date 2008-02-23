package modelo.problema.mono;

import modelo.problema.Estado;
import modelo.problema.Problema;

public class MonoProblema implements Problema {

	public MonoProblema(boolean resoluble){
		super();
	}
	
	public Estado getInicial() {
		return new MonoEstado(0,0,2,0);
	}

	public int evaluarHeuristica(Estado e) {
		return 0;
	}

	public boolean esObjetivo(Estado e) {
		MonoEstado m = (MonoEstado) e;
		return (m.getPlatano() == 1);
	}

	public String toString() {
		return "Problema del Mono y el Pl�tano \n";
	}

	public Estado getEstado() {
		return getInicial();
	}
}
