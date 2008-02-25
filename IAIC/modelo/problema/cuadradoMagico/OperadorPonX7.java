package modelo.problema.cuadradoMagico;

import modelo.problema.Estado;

public class OperadorPonX7 extends OperadorCuadradoMagico{
	
	public OperadorPonX7(EstadoCuadradoMagico inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoCuadradoMagico eFinal = (EstadoCuadradoMagico)getInicial();
		estadoFinal = new EstadoCuadradoMagico(7,eFinal.getY(),eFinal.getZ());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Poner 7 en X");
	}
}