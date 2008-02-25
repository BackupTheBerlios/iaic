package modelo.problema;

public interface IServidorProblemas {
	/**
	 * @author  Diego
	 */
	public	enum	Codigo{Jarras,Canibales,Mono,
		Granjero,CuadradoMagico}
	
	Problema	dameProblema(int i,boolean resoluble);

	int dameNumeroProblemas();
}
