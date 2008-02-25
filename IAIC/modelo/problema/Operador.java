package modelo.problema;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */

public interface Operador {
	Estado getInicial();
	Estado getFinal();
	int getCoste();
	String toString();
}
