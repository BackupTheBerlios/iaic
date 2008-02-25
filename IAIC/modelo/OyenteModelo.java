package modelo;

/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */

/**Un oyente del modelo es algo capaz de atender y escuchar
 * 
 * los eventos o cambios de estado del Modelo, en especial,
 * - que entre en una ejecuci�n Local.
 * - que termine la ejecuci�n Global
 * - que termine la ejecuci�n Local*/
public interface OyenteModelo {
	public	void	empiezaLocal();
	public	void	terminaLocal();
	public	void	terminaGlobal();
	public	Object	escogeAlgoritmo();

}
