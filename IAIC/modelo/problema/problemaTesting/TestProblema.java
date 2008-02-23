package modelo.problema.problemaTesting;

import modelo.problema.Estado;
import modelo.problema.Problema;

/**
 * @author  Diego
 */
public	class TestProblema implements Problema {
	
	private	TestEstado	i;
	private	TestEstado	a;
	private	TestEstado	b;
	private	TestEstado	c;
	private	TestEstado	d;
	private	TestEstado	o;
	
	

	public boolean esObjetivo(Estado e) {
		return e.equals(o);
	}

	public int evaluarHeuristica(Estado e) {
		return e.getHeuristica();
	}

	public Estado getInicial() {
		return i ;
	}

	public String getNombre() {
		return "Problema de testing";
	}
	
	public	TestProblema(boolean resoluble){
		super();
		i	=	new	TestEstado('i',45);
		a	=	new	TestEstado('a',30);
		b	=	new	TestEstado('b',10);
		c	=	new	TestEstado('c',35);
		d	=	new	TestEstado('d',40);
		o	=	new	TestEstado('o',0);
		
		creaOperador(i,a,200);
		creaOperador(i,b,60);
		creaOperador(i,c,40);
		
		creaOperador(a,d,40);
		creaOperador(a,o,30);
		creaOperador(b,a,150);
		creaOperador(b,o,200);
		creaOperador(c,b,5);
		creaOperador(c,o,200);
		creaOperador(d,o,50);
	}

	private void creaOperador(TestEstado in, TestEstado fi, int coste) {
		TestOperador ope	=	new	TestOperador(in,fi,coste);
		in.getOperadoresAplicables().add(ope);
	}

}
