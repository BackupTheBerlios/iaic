package modelo.problema.cuadradoMagico;

import modelo.problema.Estado;

public class OperadorPonZ6 extends OperadorCuadradoMagico{
	
	public OperadorPonZ6(EstadoCuadradoMagico inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoCuadradoMagico eFinal = (EstadoCuadradoMagico)getInicial();
		estadoFinal = new EstadoCuadradoMagico(eFinal.getX(),eFinal.getY(),6);
		return estadoFinal;
	}
	
	public String toString(){
		return ("Poner 6 en Z");
	}
}