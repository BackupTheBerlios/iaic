package modelo.problema.cuadradoMagico;

import modelo.problema.Estado;

public class OperadorPonX2 extends OperadorCuadradoMagico{
	
	public OperadorPonX2(EstadoCuadradoMagico inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoCuadradoMagico eFinal = (EstadoCuadradoMagico)getInicial();
		estadoFinal = new EstadoCuadradoMagico(2,eFinal.getY(),eFinal.getZ());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Poner 2 en X");
	}
}
