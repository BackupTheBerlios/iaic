package modelo.problema;

import modelo.problema.canibales.CanibalesProblema;
import modelo.problema.granjero.GranjeroProblema;
import modelo.problema.jarras.JarrasProblema;
import modelo.problema.mono.MonoProblema;
import modelo.problema.ochopuzzle.PuzzleProblema;
import modelo.problema.problemaTesting.TestProblema;


public class ServidorProblemas implements IServidorProblemas {

	public Problema dameProblema(int i) {
		Problema	respuesta;
		Codigo[]  lista	=	Codigo.values();
		int	indice	=	Math.abs(i) % lista.length;
		Codigo	c	=	lista[indice];
		if (c == Codigo.Canibales){
			respuesta	=	new	 CanibalesProblema();
		} else if (c == Codigo.Jarras){
			respuesta	=	new	JarrasProblema();
		} else if (c == Codigo.Granjero){
			respuesta	=	new	GranjeroProblema();
		} else if (c == Codigo.OchoPuzzle){
			respuesta	=	new	PuzzleProblema();
		} else if (c == Codigo.Mono){
			respuesta	=	new	MonoProblema();
		} else {
			respuesta	=	new	TestProblema();
		}
		
		return respuesta;
	}

	public int dameNumeroProblemas() {
		return Codigo.values().length;
	}
}
