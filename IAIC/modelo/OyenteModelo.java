package modelo;


/**Un oyente del modelo es algo capaz de atender y escuchar
 * 
 * los eventos o cambios de estado del Modelo, en especial,
 * - que entre en una ejecución Local.
 * - que termine la ejecución Global
 * - que termine la ejecución Local*/
public interface OyenteModelo {
	public	void	empiezaLocal();
	public	void	terminaLocal();
	public	void	terminaGlobal();
	public	Object	escogeAlgoritmo();

}
