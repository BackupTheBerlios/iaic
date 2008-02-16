package problema;

import java.util.*;


public interface Estado {
	
	//Muestra informacion de un estado
	String mostrarInfo();
	//Comprobacion de igualdad de dos estados
	boolean equals(Object e2);
	//Lista de operadores aplicables a un estado
	List<Operador> operadoresAplicables();
	//Calcula la heuristica de un estado
	int calculaHeuristica();
}
