package modelo.problema.cuadradoMagico;

import modelo.problema.Estado;
import modelo.problema.Operador;

public abstract class OperadorCuadradoMagico implements Operador{
	
	private EstadoCuadradoMagico estadoInicial;
	protected EstadoCuadradoMagico estadoFinal;

	public OperadorCuadradoMagico(EstadoCuadradoMagico e) {
		super();
		this.estadoInicial = e;
	}
	
	public void setEstadoInicial(EstadoCuadradoMagico estadoInicial) {
		this.estadoInicial = estadoInicial;
	}

	public Estado getInicial(){
		return estadoInicial;
	}
	public Estado getFinal(){
		transitar();
		return estadoFinal;
	}
	
	public int getCoste(){
		return 1;
	}
	
	public abstract Estado transitar();

}
