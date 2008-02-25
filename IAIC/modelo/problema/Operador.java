package modelo.problema;


public interface Operador {
	Estado getInicial();
	Estado getFinal();
	int getCoste();
	String toString();
}
