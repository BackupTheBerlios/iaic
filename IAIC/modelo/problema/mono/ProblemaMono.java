package modelo.problema.mono;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import modelo.problema.Estado;
import modelo.problema.Problema;

public class ProblemaMono implements Problema {

	public ProblemaMono(boolean resoluble){
		super();
	}
	
	public Estado getInicial() {
		return new EstadoMono(0,0,2,0);
	}

	public int evaluarHeuristica(Estado e) {
		return 0;
	}

	public boolean esObjetivo(Estado e) {
		EstadoMono m = (EstadoMono) e;
		return (m.getPlatano() == 1);
	}

	public String toString() {
		return "Problema del Mono y el Platano \n";
	}

	public Estado getEstado() {
		return getInicial();
	}
}
