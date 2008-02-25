package modelo.problema;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import java.util.List;
/** Un estado es una situación en un problema.*/
public interface Estado {
	
	String mostrarInfo();
	
	List<Operador> getOperadoresAplicables();
	
	boolean equals(Object e);
	
	int getHeuristica();
}
