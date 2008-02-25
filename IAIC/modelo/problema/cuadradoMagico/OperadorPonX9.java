package modelo.problema.cuadradoMagico;

import modelo.problema.Estado;

public class OperadorPonX9 extends OperadorCuadradoMagico{
	
	public OperadorPonX9(EstadoCuadradoMagico inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoCuadradoMagico eFinal = (EstadoCuadradoMagico)getInicial();
		estadoFinal = new EstadoCuadradoMagico(9,eFinal.getY(),eFinal.getZ());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Poner 9 en X");
	}
	
	public int getCoste(){
		return 3;
	}

}
