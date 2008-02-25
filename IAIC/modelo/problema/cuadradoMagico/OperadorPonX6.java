package modelo.problema.cuadradoMagico;

import modelo.problema.Estado;

public class OperadorPonX6 extends OperadorCuadradoMagico{
	
	public OperadorPonX6(EstadoCuadradoMagico inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoCuadradoMagico eFinal = (EstadoCuadradoMagico)getInicial();
		estadoFinal = new EstadoCuadradoMagico(6,eFinal.getY(),eFinal.getZ());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Poner 6 en X");
	}
	
	public int getCoste(){
		return 3;
	}

}
