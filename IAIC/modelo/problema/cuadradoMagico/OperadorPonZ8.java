package modelo.problema.cuadradoMagico;

import modelo.problema.Estado;

public class OperadorPonZ8 extends OperadorCuadradoMagico{
	
	public OperadorPonZ8(EstadoCuadradoMagico inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoCuadradoMagico eFinal = (EstadoCuadradoMagico)getInicial();
		estadoFinal = new EstadoCuadradoMagico(eFinal.getX(),eFinal.getY(),8);
		return estadoFinal;
	}
	
	public String toString(){
		return ("Poner 8 en Z");
	}
}
