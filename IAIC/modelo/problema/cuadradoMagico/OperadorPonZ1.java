package modelo.problema.cuadradoMagico;

import modelo.problema.Estado;

public class OperadorPonZ1 extends OperadorCuadradoMagico{
	
	public OperadorPonZ1(EstadoCuadradoMagico inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoCuadradoMagico eFinal = (EstadoCuadradoMagico)getInicial();
		estadoFinal = new EstadoCuadradoMagico(eFinal.getX(),eFinal.getY(),1);
		return estadoFinal;
	}
	
	public String toString(){
		return ("Poner 1 en Z");
	}
	
	public int getCoste(){
		return 2;
	}

}
