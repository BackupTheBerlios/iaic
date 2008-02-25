package modelo.problema.cuadradoMagico;

import modelo.problema.Estado;

public class OperadorPonX3 extends OperadorCuadradoMagico{
	
	public OperadorPonX3(EstadoCuadradoMagico inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoCuadradoMagico eFinal = (EstadoCuadradoMagico)getInicial();
		estadoFinal = new EstadoCuadradoMagico(3,eFinal.getY(),eFinal.getZ());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Poner 3 en X");
	}
	
	public int getCoste(){
		return 3;
	}

}
