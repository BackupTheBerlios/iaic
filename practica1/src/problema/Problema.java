package problema;



import java.util.Collection;
import java.util.Iterator;

/**
 * @author gnufede
 *
 */
public interface Problema {

 //Collection<Busqueda> busqueda = null;
	
	Estado getEstadoInicial();
	int evaluaHeuristica(Estado e);
	boolean esObjetivo(Estado e);
}
