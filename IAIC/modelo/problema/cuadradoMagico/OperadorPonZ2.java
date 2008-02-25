package modelo.problema.cuadradoMagico;

import modelo.problema.Estado;

public class OperadorPonZ2 extends OperadorCuadradoMagico{
	
	public OperadorPonZ2(EstadoCuadradoMagico inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoCuadradoMagico eFinal = (EstadoCuadradoMagico)getInicial();
		estadoFinal = new EstadoCuadradoMagico(eFinal.getX(),eFinal.getY(),2);
		return estadoFinal;
	}
	
	public String toString(){
		return ("Poner 2 en Z");
	}
	
	public int getCoste(){
		return 2;
	}

}
