package modelo.problema;

/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
public interface Problema {
	Estado getInicial();
	Estado getEstado();
	int evaluarHeuristica(Estado e);   
	boolean esObjetivo(Estado e);
	String	toString();
}