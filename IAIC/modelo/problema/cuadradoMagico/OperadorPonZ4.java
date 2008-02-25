package modelo.problema.cuadradoMagico;

import modelo.problema.Estado;

public class OperadorPonZ4 extends OperadorCuadradoMagico{
	
	public OperadorPonZ4(EstadoCuadradoMagico inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoCuadradoMagico eFinal = (EstadoCuadradoMagico)getInicial();
		estadoFinal = new EstadoCuadradoMagico(eFinal.getX(),eFinal.getY(),4);
		return estadoFinal;
	}
	
	public String toString(){
		return ("Poner 4 en Z");
	}
}
