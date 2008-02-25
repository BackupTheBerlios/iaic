package modelo.problema.cuadradoMagico;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import modelo.problema.Estado;

public class OperadorPonY7 extends OperadorCuadradoMagico{
	
	public OperadorPonY7(EstadoCuadradoMagico inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoCuadradoMagico eFinal = (EstadoCuadradoMagico)getInicial();
		estadoFinal = new EstadoCuadradoMagico(eFinal.getX(),7,eFinal.getZ());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Poner 7 en Y");
	}
	
	public int getCoste(){
		return 2;
	}

}
