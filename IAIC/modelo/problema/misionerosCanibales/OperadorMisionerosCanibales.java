package modelo.problema.misionerosCanibales;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import modelo.problema.Estado;
import modelo.problema.Operador;

public abstract class OperadorMisionerosCanibales implements Operador{
	
	private EstadoMisionerosCanibales estadoInicial;
	protected EstadoMisionerosCanibales estadoFinal;

	public OperadorMisionerosCanibales(EstadoMisionerosCanibales e) {
		super();
		this.estadoInicial = e;
	}
	
	public void setEstadoInicial(EstadoMisionerosCanibales estadoInicial) {
		this.estadoInicial = estadoInicial;
	}

	public Estado getInicial(){
		return estadoInicial;
	}
	public Estado getFinal(){
		transitar();
		return estadoFinal;
	}
	
	public abstract Estado transitar();
}
