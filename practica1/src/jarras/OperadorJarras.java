package jarras;

import problema.Estado;
import problema.Operador;

public abstract class OperadorJarras implements Operador{
	
	private EstadoJarras estadoInicial;
	protected EstadoJarras estadoFinal;

	public OperadorJarras(EstadoJarras e) {
		super();
		this.estadoInicial = e;
	}
	
	public void setEstadoInicial(EstadoJarras estadoInicial) {
		this.estadoInicial = estadoInicial;
	}

	public Estado getEstadoInicial(){
		return estadoInicial;
	}
	public Estado getEstadoFinal(){
		transitar();
		return estadoFinal;
	}
	
	public abstract Estado transitar();

}
