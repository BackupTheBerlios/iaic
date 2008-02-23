package modelo.problema;

import modelo.problema.granjero.GranjeroProblema;
import modelo.problema.jarras.ProblemaJarras;
import modelo.problema.misionerosCanibales.ProblemaMisionerosCanibales;
import modelo.problema.mono.MonoProblema;
import modelo.problema.ochopuzzle.PuzzleProblema;
import modelo.problema.problemaTesting.TestProblema;


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
//		} else if (c == Codigo.Granjero){
//			respuesta	=	new	GranjeroProblema(resoluble);
//		} else if (c == Codigo.OchoPuzzle){
//			respuesta	=	new	PuzzleProblema(resoluble);
//		} else if (c == Codigo.Mono){
//			respuesta	=	new	MonoProblema(resoluble);
		} else {
			respuesta	=	new	TestProblema(resoluble);
		}
		
		return respuesta;
	}

	public int dameNumeroProblemas() {
		return Codigo.values().length;
	}
}
