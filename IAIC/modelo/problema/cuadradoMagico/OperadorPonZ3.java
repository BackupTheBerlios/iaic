package modelo.problema.cuadradoMagico;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import modelo.problema.Estado;

public class OperadorPonZ3 extends OperadorCuadradoMagico{
	
	public OperadorPonZ3(EstadoCuadradoMagico inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoCuadradoMagico eFinal = (EstadoCuadradoMagico)getInicial();
		estadoFinal = new EstadoCuadradoMagico(eFinal.getX(),eFinal.getY(),3);
		return estadoFinal;
	}
	
	public String toString(){
		return ("Poner 3 en Z");
	}
	
	public int getCoste(){
		return 2;
	}

}
