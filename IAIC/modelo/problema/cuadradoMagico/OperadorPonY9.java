package modelo.problema.cuadradoMagico;

import modelo.problema.Estado;

public class OperadorPonY9 extends OperadorCuadradoMagico{
	
	public OperadorPonY9(EstadoCuadradoMagico inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoCuadradoMagico eFinal = (EstadoCuadradoMagico)getInicial();
		estadoFinal = new EstadoCuadradoMagico(eFinal.getX(),9,eFinal.getZ());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Poner 9 en Y");
	}
	
	public int getCoste(){
		return 2;
	}

}
