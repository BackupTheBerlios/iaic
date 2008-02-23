package modelo.laberinto;

import java.util.LinkedList;
import java.util.List;
import modelo.IAvisoLocal;
import modelo.problema.Estado;
import modelo.problema.Problema;

/**
 * @author  Diego
 */
public	class LaberintoProblema implements Problema {

	private	Laberinto	milaberinto;
	
	private	IAvisoLocal	avisos;
	
	private	List<Habitacion> visitadas;
	
	public Estado getInicial() {
		return new	LaberintoEstado(milaberinto.getEntrada(), this);
	}

	public int evaluarHeuristica(Estado e) {
		return e.getHeuristica();
	}

	public boolean esObjetivo(Estado e) {
		LaberintoEstado	l	=	(LaberintoEstado) e;
		return milaberinto.isSalida(l.getMihabitacion());
	}

	public String toString() {
		return "PROBLEMA GLOBAL: el Laberinto";
	}


	public LaberintoProblema(IAvisoLocal avisos, Laberinto milaberinto) {
		super();
		this.avisos = avisos;
		this.milaberinto = milaberinto;
		visitadas	=	new	LinkedList<Habitacion>();
	}
	
	public	void	visitar(Habitacion h){
		if (!visitadas.contains(h)){
			visitadas.add(h);
			avisos.iniciarEjecucionLocal(h.getCodigoProblema());
		}
	}

}
