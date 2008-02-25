package modelo.problema.cuadradoMagico;

import modelo.problema.Estado;

public class OperadorPonY3 extends OperadorCuadradoMagico{
	
	public OperadorPonY3(EstadoCuadradoMagico inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoCuadradoMagico eFinal = (EstadoCuadradoMagico)getInicial();
		estadoFinal = new EstadoCuadradoMagico(eFinal.getX(),3,eFinal.getZ());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Poner 3 en Y");
	}
}
