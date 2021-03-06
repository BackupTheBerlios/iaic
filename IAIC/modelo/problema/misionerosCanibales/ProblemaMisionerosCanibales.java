package modelo.problema.misionerosCanibales;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import modelo.problema.Estado;
import modelo.problema.Problema;

public class ProblemaMisionerosCanibales implements Problema {
	
	private int tamMaxMisioneros = 3;
	private int tamMaxCanibales = 3;
	
	public ProblemaMisionerosCanibales(boolean resoluble){
		super();
		if (!resoluble)
			this.tamMaxCanibales = 4;
		System.out.println("Canibales: " + tamMaxCanibales);
	}
	
	public int evaluarHeuristica(Estado e){
		return 0;		
	}
	
	public Estado getInicial(){
		return (new EstadoMisionerosCanibales(tamMaxMisioneros,tamMaxCanibales,1,tamMaxMisioneros,tamMaxCanibales));
	}
	
	public boolean esObjetivo(Estado e){
		EstadoMisionerosCanibales estadoObjetivo = new EstadoMisionerosCanibales(0,0,0,tamMaxMisioneros,tamMaxCanibales);
		if (e.equals(estadoObjetivo))
			return true;
		else 
			return false;
	}
	
	public String toString(){
		return "Problema de los Misioneros y los Canibales";
	}

	public int getTamMaxCanibales() {
		return tamMaxCanibales;
	}

	public void setTamMaxCanibales(int tamMaxCanibales) {
		this.tamMaxCanibales = tamMaxCanibales;
	}

	public int getTamMaxMisioneros() {
		return tamMaxMisioneros;
	}

	public void setTamMaxMisioneros(int tamMaxMisioneros) {
		this.tamMaxMisioneros = tamMaxMisioneros;
	}
	public Estado getEstado() {
		return getInicial();
	}
}
