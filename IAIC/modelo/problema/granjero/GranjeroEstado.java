package modelo.problema.granjero;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import java.util.LinkedList;
import java.util.List;
import modelo.problema.Estado;
import modelo.problema.Operador;

/**
 * @author  Diego
 */
class GranjeroEstado implements Estado{
	
	/**El estado lo podemos ver como una tupla de valores que 
	 * describen si se encuentra o no uno de los elementos del 
	 * problema en la orilla izda(0) o dcha(1).
	 * (GRANJERO/BOTE , LOBO , CABRA , COL)**/
	
	private int GB;
	private int LO;
	private int CA;
	private int CO;
	

	/**
	 * @param GB
	 * @param LO
	 * @param CA
	 * @param CO
	 */
	
	public GranjeroEstado(int GB,int LO,int CA,int CO) {
		super();
		this.CA = CA;
		this.CO = CO;
		this.GB = GB;
		this.LO = LO;
	}
	

	public boolean equals(Object e) {
      GranjeroEstado g = (GranjeroEstado) e;
      return (this.CA == g.CA) && (this.CO == g.CO) && (this.GB == g.GB) && (this.LO == g.LO);		
	}

	public Estado getCopia() {
		return new GranjeroEstado(GB,LO,CA,CO);
	}

	public List<Operador> getOperadoresAplicables() {
		List<Operador>	lista	=	new	LinkedList<Operador>();
		
		if (!esEstadoPeligroso()){
			lista.add(new GranjeroOperadorPasaGranjero(this));
			
			if (GB == CA){
				lista.add(new GranjeroOperadorPasaCabra(this));			
			}
			
			if (GB == LO){
				lista.add(new GranjeroOperadorPasaLobo(this));
			}
			
			if (GB == CO){
				lista.add(new GranjeroOperadorPasaCol(this));			
			}		
		}
		
		return lista;
	}

	/**ESTADOS PELIGROSOS: Aquellos estados en los que la cabra se 
	 * queda con la col o (OR) con el lobo sin el granjero.**/
	private boolean esEstadoPeligroso() {
		return (((CA == LO) || (CA == CO)) 
			&& (CA != GB));
	}


	public String mostrarInfo() {
		return "\nGranjero/Bote:" + GB + "\nLobo" + LO + "\nCabra" + CA + "\nCol" + CO + "\n";
	}

	/**
	 * @return  the cA
	 * @uml.property  name="cA"
	 */
	public int getCA() {
		return CA;
	}

	/**
	 * @param cA  the cA to set
	 * @uml.property  name="cA"
	 */
	public void setCA(int ca) {
		CA = ca;
	}

	/**
	 * @return  the cO
	 * @uml.property  name="cO"
	 */
	public int getCO() {
		return CO;
	}

	/**
	 * @param cO  the cO to set
	 * @uml.property  name="cO"
	 */
	public void setCO(int co) {
		CO = co;
	}

	/**
	 * @return  the gB
	 * @uml.property  name="gB"
	 */
	public int getGB() {
		return GB;
	}

	/**
	 * @param gB  the gB to set
	 * @uml.property  name="gB"
	 */
	public void setGB(int gb) {
		GB = gb;
	}

	/**
	 * @return  the lO
	 * @uml.property  name="lO"
	 */
	public int getLO() {
		return LO;
	}

	/**
	 * @param lO  the lO to set
	 * @uml.property  name="lO"
	 */
	public void setLO(int lo) {
		LO = lo;
	}


	public int getHeuristica() {
		return 0;
	}

	
	

}
