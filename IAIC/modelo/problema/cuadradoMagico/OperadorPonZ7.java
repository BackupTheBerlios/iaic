package modelo.problema.cuadradoMagico;

import modelo.problema.Estado;

public class OperadorPonZ7 extends OperadorCuadradoMagico{
	
	public OperadorPonZ7(EstadoCuadradoMagico inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoCuadradoMagico eFinal = (EstadoCuadradoMagico)getInicial();
		estadoFinal = new EstadoCuadradoMagico(eFinal.getX(),eFinal.getY(),7);
		return estadoFinal;
	}
	
	public String toString(){
		return ("Poner 7 en Z");
	}
	
	public int getCoste(){
		return 2;
	}

}
