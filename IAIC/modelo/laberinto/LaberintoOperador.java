package modelo.laberinto;

import modelo.problema.Estado;
import modelo.problema.Operador;

/**
 * @author  Diego
 */
class LaberintoOperador implements Operador {
	private	Puerta	mipuerta;
	private LaberintoEstado inicial;
	private	LaberintoEstado fin;

	/**
	 * @return  the inicial
	 * @uml.property  name="inicial"
	 */
	public Estado getInicial() {
		return inicial;
	}

	public Estado getFinal() {
		if (fin == null){
			fin = new LaberintoEstado(mipuerta.cruzar(
				inicial.getMihabitacion()), 
				inicial.getProblema()
			);
		}
		return fin;
	}

	public void setInicial(Estado e) {
		inicial	=	(LaberintoEstado) e;		
	}

	public int getCoste() {
		return 1;
	}

	public String getNombre() {
		return mipuerta.muestra();
	}


	public LaberintoOperador(LaberintoEstado inicial, Puerta mipuerta) {
		super();
		this.inicial = inicial;
		this.mipuerta = mipuerta;
	}
	
}
