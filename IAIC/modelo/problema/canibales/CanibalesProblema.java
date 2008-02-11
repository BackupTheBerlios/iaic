package modelo.problema.canibales;

import modelo.problema.Estado;
import modelo.problema.Problema;


public class CanibalesProblema implements Problema {

	public Estado getInicial() {
		return new CanibalesEstado(3,3,0);
	}

	public int evaluarHeuristica(Estado e) {
		return 0;
	}

	public boolean esObjetivo(Estado e) {
		CanibalesEstado c = (CanibalesEstado) e;
		return (c.getNM() == 0)&&(c.getNC() == 0)&&(c.getB() == 1);
	}

	public String getNombre() {
		
		return "Problema de los Canibales y Misioneros.";
	}

}
