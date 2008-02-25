package modelo.problema.jarras;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import modelo.problema.*;

public class OperadorTrasvaseGrandePeque extends OperadorJarras{
	
	public OperadorTrasvaseGrandePeque(EstadoJarras inicial){
		super(inicial);
	}
	int big = 0;
	int little = 0;
	public Estado transitar(){
		EstadoJarras eFinal = (EstadoJarras)getInicial();
		big = eFinal.getJGrande() - (eFinal.getTamP() - eFinal.getJPeque());
		if (big < 0)
			big = 0;
		little = eFinal.getJPeque() + (eFinal.getJGrande()-big);
		if (big > 3)
			big = 3;
		estadoFinal = new EstadoJarras(little,big,eFinal.getTamP(),eFinal.getTamG());
		return estadoFinal;
	}
	
	public String toString(){
		return ("Trasvase jarra de 4 litros a jarra de 3 litros");
	}
}