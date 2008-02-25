package modelo.problema.cuadradoMagico;

import modelo.problema.Estado;

public class OperadorPonX8 extends OperadorCuadradoMagico{
	
	public OperadorPonX8(EstadoCuadradoMagico inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoCuadradoMagico eFinal = (EstadoCuadradoMagico)getInicial();
		estadoFinal = new EstadoCuadradoMagico(8,eFinal.getY(),eFinal.getZ());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Poner 8 en X");
	}
	
	public int getCoste(){
		return 3;
	}

}
