package modelo.problema.jarras;

import modelo.problema.Estado;
import modelo.problema.Problema;

public class JarrasProblema implements Problema {
	
	public Estado getInicial() {
		return new JarrasEstado(0,0);
	}

	public int evaluarHeuristica(Estado e) {
		return 0;
	}

	public boolean esObjetivo(Estado e) {
		JarrasEstado	j	=	(JarrasEstado)e;
		return j.getMayor() == 4;
	}

	public String getNombre() {
		return "Problema de las Jarras \n\n";
	}

}
