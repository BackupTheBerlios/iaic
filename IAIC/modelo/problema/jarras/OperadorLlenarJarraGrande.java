package modelo.problema.jarras;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import modelo.problema.Estado;

public class OperadorLlenarJarraGrande extends OperadorJarras{
	
	public OperadorLlenarJarraGrande(EstadoJarras inicial){
		super(inicial);
	}
	
	public Estado transitar(){
		EstadoJarras eFinal = (EstadoJarras)getInicial();
		estadoFinal = new EstadoJarras(eFinal.getJPeque(),eFinal.getTamG(),eFinal.getTamP(),eFinal.getTamG());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Llenar jarra 4 litros");
	}
}
