package modelo.problema;

public interface IServidorProblemas {
	/**
	 * @author  Diego
	 */
	public	enum	Codigo{Jarras,Granjero,Canibales,OchoPuzzle, Mono, Test}
	
	Problema	dameProblema(int i,boolean resoluble);

	int dameNumeroProblemas();
}
