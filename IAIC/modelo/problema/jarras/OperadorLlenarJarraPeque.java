package modelo.problema.jarras;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import modelo.problema.Estado;

public class OperadorLlenarJarraPeque extends OperadorJarras{
	
	public OperadorLlenarJarraPeque(EstadoJarras inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoJarras eFinal = (EstadoJarras)getInicial();
		estadoFinal = new EstadoJarras(eFinal.getTamP(),eFinal.getJGrande(),eFinal.getTamP(),eFinal.getTamG());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Llenar jarra 3 litros");
	}
}
