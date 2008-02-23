package modelo.problema.cubo;

public class Puerta {

	private int numeroPuerta;
	private int codigoProblema;
	private boolean estaClausurada;
	private boolean estaAbierta;
	
	Puerta(int num){
		numeroPuerta = num;
		estaAbierta = false;
	}
	
	Puerta(int num, boolean clausurada){
		numeroPuerta = num;
		estaClausurada = clausurada;
		estaAbierta = false;
	}
	/**
	 * @return the numeroPuerta
	 */
	public int getNumeroPuerta() {
		return numeroPuerta;
	}
	/**
	 * @param numeroPuerta the numeroPuerta to set
	 */
	public void setNumeroPuerta(int numeroPuerta) {
		this.numeroPuerta = numeroPuerta;
	}
	/**
	 * @return the codigoProblema
	 */
	public int getCodigoProblema() {
		return codigoProblema;
	}
	/**
	 * @param codigoProblema the codigoProblema to set
	 */
	public void setCodigoProblema(int codigoProblema) {
		this.codigoProblema = codigoProblema;
	}

	/**
	 * @return the estaClausurada
	 */
	public boolean isClausurada() {
		return estaClausurada;
	}

	/**
	 * @param estaClausurada the estaClausurada to set
	 */
	public void setClausurada(boolean estaClausurada) {
		this.estaClausurada = estaClausurada;
	}

	/**
	 * @return the estaAbierta
	 */
	public boolean isAbierta() {
		return estaAbierta;
	}

	/**
	 * @param estaAbierta the estaAbierta to set
	 */
	public void Abrir() {
		this.estaAbierta = true;
	}
	
	public boolean equals (Object e){
		return ((Puerta)e).getNumeroPuerta() == numeroPuerta;
	}
	
}
