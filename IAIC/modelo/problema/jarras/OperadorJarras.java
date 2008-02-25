package modelo.problema.jarras;

import modelo.problema.Estado;
import modelo.problema.Operador;

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
	
	public boolean isEstadoEstable() {
		return true;
	}
	
	public abstract Estado transitar();

}
