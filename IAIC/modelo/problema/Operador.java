package modelo.problema;


public interface Operador {
	boolean isEstadoEstable();
	Estado getInicial();
	Estado getFinal();
	int getCoste();
	String toString();
}
