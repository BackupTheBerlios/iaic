package misionerosCanibales;

import problema.Estado;
import problema.Operador;

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

	public Estado getEstadoInicial(){
		return estadoInicial;
	}
	public Estado getEstadoFinal(){
		transitar();
		return estadoFinal;
	}
	
	public abstract Estado transitar();
}
