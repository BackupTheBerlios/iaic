package modelo.problema;

import java.util.List;
/** Un estado es una situación en un problema.*/
public interface Estado {
	
	String mostrarInfo();
	
	List<Operador> getOperadoresAplicables();
	
	boolean equals(Object e);
	
	int getHeuristica();
}
