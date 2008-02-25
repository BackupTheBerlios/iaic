package modelo.problema.cuadradoMagico;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import modelo.problema.Estado;

public class OperadorPonY1 extends OperadorCuadradoMagico{
	
	public OperadorPonY1(EstadoCuadradoMagico inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoCuadradoMagico eFinal = (EstadoCuadradoMagico)getInicial();
		estadoFinal = new EstadoCuadradoMagico(eFinal.getX(),1,eFinal.getZ());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Poner 1 en Y");
	}
	
	public int getCoste(){
		return 2;
	}

}
