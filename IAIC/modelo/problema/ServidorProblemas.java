package modelo.problema;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import modelo.problema.cuadradoMagico.ProblemaCuadradoMagico;
import modelo.problema.granjero.GranjeroProblema;
import modelo.problema.jarras.ProblemaJarras;
import modelo.problema.misionerosCanibales.ProblemaMisionerosCanibales;
import modelo.problema.mono.ProblemaMono;


public class ServidorProblemas implements IServidorProblemas {

	public Problema dameProblema(int i,boolean resoluble) {
		Problema	respuesta;
		Codigo[]  lista	=	Codigo.values();
		int	indice	=	Math.abs(i) % lista.length;
		Codigo	c	=	lista[indice];
		if (c == Codigo.Canibales){
			respuesta	=	new	 ProblemaMisionerosCanibales(resoluble);
		} else if (c == Codigo.Jarras){
			respuesta	=	new	ProblemaJarras(resoluble);
		} else if (c == Codigo.Granjero){
			respuesta	=	new	GranjeroProblema(resoluble);
		} else if (c == Codigo.CuadradoMagico){
			respuesta	=	new	ProblemaCuadradoMagico(resoluble);
		} else			{
			respuesta	=	new	ProblemaMono(resoluble);
		}
		return respuesta;
	}

	public int dameNumeroProblemas() {
		return Codigo.values().length;
	}
}
