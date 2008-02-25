package modelo.problema.cuadradoMagico;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import modelo.problema.Estado;
import modelo.problema.Problema;

public class ProblemaCuadradoMagico implements Problema{
	
	public ProblemaCuadradoMagico(boolean resoluble){
		super();
	}
	
	public int evaluarHeuristica(Estado e){
		return (e.getHeuristica());	
	}
	
	public Estado getInicial(){
		return (new EstadoCuadradoMagico(0,0,0));
	}
	
	public boolean esObjetivo(Estado e){
		EstadoCuadradoMagico aux = (EstadoCuadradoMagico) e;
		int x = aux.getX();
		int y = aux.getY();
		int z = aux.getZ();
		
		if ((x != y) && (y != z) && (x != z)
				&& (x != 5) && (y != 5) && (z != 5) 
				&& ((x+y)<15) && ((x+z)<15) &&
				(20-(2*x)-y-z == 0) &&
				(x != 0) && (y != 0) && (z != 0))
			return true;
		else return false;
	}
	
	public String	toString(){
		return ("Problema del cuadrado magico");
	}

	public Estado getEstado() {
		return getInicial();
	}
}
