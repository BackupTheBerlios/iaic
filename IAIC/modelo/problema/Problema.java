package modelo.problema;


public interface Problema {
	Estado getInicial();
	Estado getEstado();
	int evaluarHeuristica(Estado e);   
	boolean esObjetivo(Estado e);
	String	toString();
}