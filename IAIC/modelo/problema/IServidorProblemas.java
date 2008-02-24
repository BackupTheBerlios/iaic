package modelo.problema;

public interface IServidorProblemas {
	/**
	 * @author  Diego
	 */
	public	enum	Codigo{Mono,Jarras,Canibales,
		Granjero,OchoPuzzle,  Test}
	
	Problema	dameProblema(int i,boolean resoluble);

	int dameNumeroProblemas();
}
