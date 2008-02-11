package modelo.problema;

public interface IServidorProblemas {
	/**
	 * @author  Diego
	 */
	public	enum	Codigo{Jarras,Granjero,Caníbales,OchoPuzzle, Mono, Test}
	
	Problema	dameProblema(int i);

	int dameNumeroProblemas();
}
