package modelo.problema.cuadradoMagico;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import modelo.problema.Estado;

public class OperadorPonY4 extends OperadorCuadradoMagico{
	
	public OperadorPonY4(EstadoCuadradoMagico inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoCuadradoMagico eFinal = (EstadoCuadradoMagico)getInicial();
		estadoFinal = new EstadoCuadradoMagico(eFinal.getX(),4,eFinal.getZ());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Poner 4 en Y");
	}
	public int getCoste(){
		return 2;
	}

}
