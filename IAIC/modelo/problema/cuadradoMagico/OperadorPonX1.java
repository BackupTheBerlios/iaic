package modelo.problema.cuadradoMagico;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import modelo.problema.Estado;

public class OperadorPonX1 extends OperadorCuadradoMagico{
	
	public OperadorPonX1(EstadoCuadradoMagico inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoCuadradoMagico eFinal = (EstadoCuadradoMagico)getInicial();
		estadoFinal = new EstadoCuadradoMagico(1,eFinal.getY(),eFinal.getZ());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Poner 1 en X");
	}
	
	public int getCoste(){
		return 3;
	}

}
