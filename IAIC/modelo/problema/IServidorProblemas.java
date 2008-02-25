package modelo.problema;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
public interface IServidorProblemas {

	public	enum	Codigo{Jarras,Canibales,Mono,
		Granjero,CuadradoMagico}
	
	Problema	dameProblema(int i,boolean resoluble);

	int dameNumeroProblemas();
}
