package modelo.problema.cuadradoMagico;

import modelo.problema.Estado;

public class OperadorPonY6 extends OperadorCuadradoMagico{
	
	public OperadorPonY6(EstadoCuadradoMagico inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoCuadradoMagico eFinal = (EstadoCuadradoMagico)getInicial();
		estadoFinal = new EstadoCuadradoMagico(eFinal.getX(),6,eFinal.getZ());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Poner 6 en Y");
	}
	
	public int getCoste(){
		return 2;
	}

}
