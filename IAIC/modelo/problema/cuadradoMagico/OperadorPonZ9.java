package modelo.problema.cuadradoMagico;

import modelo.problema.Estado;

public class OperadorPonZ9 extends OperadorCuadradoMagico{
	
	public OperadorPonZ9(EstadoCuadradoMagico inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoCuadradoMagico eFinal = (EstadoCuadradoMagico)getInicial();
		estadoFinal = new EstadoCuadradoMagico(eFinal.getX(),eFinal.getY(),9);
		return estadoFinal;
	}
	
	public String toString(){
		return ("Poner 9 en Z");
	}
	
	public int getCoste(){
		return 2;
	}

}
