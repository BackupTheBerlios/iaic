package modelo.problema;


public interface Problema {
	Estado getInicial();
	int evaluarHeuristica(Estado e);   
	boolean esObjetivo(Estado e);
	String	getNombre();
}
