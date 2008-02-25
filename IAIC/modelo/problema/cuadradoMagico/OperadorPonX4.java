package modelo.problema.cuadradoMagico;

import modelo.problema.Estado;

public class OperadorPonX4 extends OperadorCuadradoMagico{
	
	public OperadorPonX4(EstadoCuadradoMagico inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoCuadradoMagico eFinal = (EstadoCuadradoMagico)getInicial();
		estadoFinal = new EstadoCuadradoMagico(4,eFinal.getY(),eFinal.getZ());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Poner 4 en X");
	}
	
	public int getCoste(){
		return 3;
	}

}
