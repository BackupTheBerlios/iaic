package modelo.problema.granjero;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import modelo.problema.Estado;
import modelo.problema.Problema;

public class GranjeroProblema implements Problema{

	public GranjeroProblema(boolean resoluble){
		super();
	}
	
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

	public String toString() {
		return "Problema del Granjero la col la cabra y el lobo \n\n";
	}

	public Estado getEstado() {
		return getInicial();
	}

}
