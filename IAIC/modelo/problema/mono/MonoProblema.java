package modelo.problema.mono;

import modelo.problema.Estado;
import modelo.problema.Problema;

public class MonoProblema implements Problema {

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

	public String getNombre() {
		return "Problema del Mono y el Plátano \n";
	}

}
