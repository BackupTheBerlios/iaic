package modelo.problema.canibales;

import java.util.LinkedList;
import java.util.List;
import modelo.problema.Estado;
import modelo.problema.Operador;

/**
 * @author  Diego
 */
class CanibalesEstado implements Estado {
	
	/**El estado lo podemos ver como una tupla de 3 valores
	 * (NM,NC,B) que representan el numero de misioneros, el
	 * numero de canibales y la posicion del barco con respecto
	 * a la orilla de partida.0->ORILLA PARTIDA; 1-> ORILLA OBJETIVO**/	
	private int NM; 
	private int NC; 
	private int B; 
	
	/**
	 * @param NM
	 * @param NC
	 * @param B
	 */
	
	
	public CanibalesEstado(int NM,int NC,int B) {
		super();
		this.B = B;
		this.NM = NM;
		this.NC = NC;
	}
	
	/**
	 * @return  the b
	 * @uml.property  name="b"
	 */
	public int getB() {
		return B;
	}
	
	/**
	 * @param b  the b to set
	 * @uml.property  name="b"
	 */
	public void setB(int b) {
		B = b;
	}
	
	/**
	 * @return  the nC
	 * @uml.property  name="nC"
	 */
	public int getNC() {
		return NC;
	}
	
	/**
	 * @param nC  the nC to set
	 * @uml.property  name="nC"
	 */
	public void setNC(int nc) {
		NC = nc;
	}
	
	/**
	 * @return  the nM
	 * @uml.property  name="nM"
	 */
	public int getNM() {
		return NM;
	}
	
	/**
	 * @param nM  the nM to set
	 * @uml.property  name="nM"
	 */
	public void setNM(int nm) {
		NM = nm;
	}
	
	public List<Operador> getOperadoresAplicables() {
		List<Operador>	lista	=	new	LinkedList<Operador>();
		if (!estadoPeligrosidad()){
			
			if ( ((getNM() > 0)&&(getB() == 0)) || ((getNM() < 3)&&(getB() == 1)) ){
				lista.add(new CanibalesOperadorCruzaM(this));
			}

			if ( ((getNM() > 1)&&(getB() == 0)) || ((getNM() < 2)&&(getB() == 1)) ){		
				lista.add(new CanibalesOperadorCruzaMM(this));
			}
			
			if ( ((getNC() > 0)&&(getB() == 0)) || ((getNC() < 3)&&(getB() == 1)) ){
				lista.add(new CanibalesOperadorCruzaC(this));
			}
			
			if ( ((getNC() > 1)&&(getB() == 0)) || ((getNC() < 2)&&(getB() == 1)) ){
				lista.add(new CanibalesOperadorCruzaCC(this));
			}
			
			if ( ((getNM() > 0)&&(getNC() > 0)&&(getB() == 0)) || ((getNM() < 3)&&(getNC() < 3)&&(getB() == 1)) ){
				lista.add(new CanibalesOperadorCruzaMC(this));
			}
			
			
		}		
		return lista;
		
	}
	
	private boolean estadoPeligrosidad() {
		return ((getNM() < getNC())&&(getNM() != 0))
		|| ((getNM() > getNC())&&(getNM() != 3));
	}
	
	
	public boolean equals(Object e) {
		CanibalesEstado c = (CanibalesEstado) e;
		return (c.getNM() == this.getNM())&&(c.getNC() == this.getNC())&&(c.getB() == this.getB());
	}
	
	public int getHeuristica() {
		return 0;
	}
	

	public String mostrarInfo() {
		return "\nNumero de Misioneros\n:"+NM+"\nNumero de Canibales\n:"+NC+"Bote en la orilla:\n"+B+"\n";
	}

	public Estado getCopia() {
		return new CanibalesEstado(NM,NC,B);
	}
}