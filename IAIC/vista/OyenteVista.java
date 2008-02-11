package vista;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface OyenteVista {

	/** Da la orden de crear un nuevo laberinto, del que da 
	 * algunos parámetros básicos. 
	 * El Modelo es luego responsable de avisar al resto de módulos
	 * de que ha cambiado su estado.
	 * @param habitaciones es el número de habitaciones de un laberinto.
	 * @param puertas es el número de puertas -conexiones entre habitaciones- en el laberinto.
	 * @param ventanas es el número de ventanas que hay en el laberinto. */
	public abstract void nuevoLaberinto(int habitaciones, int puertas,
			int ventanas, int salidas);

	/** Ordena guardar un objeto de laberinto en un archivo binario.	 */
	public abstract void guardarBinario(ObjectOutputStream output)
			throws Exception;

	/** Ordena cargar un objeto de tipo laberinto desde un archivo binario
	 * 	 * El Modelo es luego responsable de avisar al resto de módulos
	 * de que ha cambiado su estado. */
	public abstract void cargarBinario(ObjectInputStream input)
			throws Exception;

	/** Ordena guardar la información del laberinto en un archivo de texto, al que se accede 
	 * con el FileWriter.*/
	public abstract void guardarTexto(FileWriter fil) throws Exception;

	/** Ordena leer la información de un laberinto desde un archivo de texto, 
	 * al que se accede con un FileReader*/
	public abstract void cargarTexto(FileReader input) throws Exception;

	/** Manda cerrar un laberinto*/
	public abstract void cerrarLaberinto();

	/**Da la orden para que comience la ejecución de la búsqueda de nivel global.
	 * El modelo luego debe avisar de que su estado ha cambiado*/
	public abstract void iniciarEjecucionGlobal();

	/** Solicita un array con los algoritmos de búsqueda del modelo.
	 * Los objetos pueden ser de cualquier clase
	 * siempre que la respuesta al método toString() 
	 * sea el nombre del algoritmo que representa*/
	public abstract Object[] getListaAlgoritmos();

	/** Ordena al modelo que se ejecute un paso en el nivel local.
	 * El Modelo es luego responsable de avisar al resto de módulos
	 * de que ha cambiado su estado.*/
	public abstract void ejecutaPasoLocal();

	/** Ordena al modelo que ejecute un paso en la búsqueda de nivel locaal.
	 * El Modelo es luego responsable de avisar sobre su cambio de estado.*/
	public abstract void ejecutaPasoGlobal();

	/** Ordena al modelo que cierre la búsqueda global que se hubiera iniciado */
	public abstract void cierraGlobal();

	/** Ordena al modelo que cierre la búsqueda local que se hubiera iniciado.*/
	public abstract void cierraLocal();

}