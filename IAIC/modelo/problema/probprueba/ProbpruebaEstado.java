package modelo.problema.probprueba;

import java.util.LinkedList;
import java.util.List;
import modelo.problema.Estado;
import modelo.problema.Operador;

/**
 * @author  Diego
 */
public class ProbpruebaEstado implements Estado {
	
	private int ID; 
	private int [] ady; 
	
	
	public ProbpruebaEstado(int ID) {
		super();
		this.ID = ID;
		switch (ID){
		case 1: 
			this.ady = new int[2];
			ady[0] = 2;
			ady[1] = 3;
			break;
		case 2: 
			this.ady = new int[1];
			ady[0] = 3;
			break;
		case 3: 
			this.ady = new int[2];
			ady[0] = 2;
			ady[1] = 1;
			break;
		}		
	}
	
	/**
	 * @return  the iD
	 * @uml.property  name="iD"
	 */
	public int getID() {
		return ID;
	}
	
	/**
	 * @param iD  the iD to set
	 * @uml.property  name="iD"
	 */
	public void setID(int id) {
		this.ID = id;
	}
	
	public int[] getady() {
		return ady;
	}
	
	public void setady(int[] ady) {
		this.ady = new int[ady.length];
		for (int i = 0; i < ady.length; i++) {
			this.ady[i] = ady[i];
		}		
	}
	
	public List<Operador> getOperadoresAplicables() {
		List<Operador>	lista	=	new	LinkedList<Operador>();
		for (int i = 0; i < ady.length; i++) {
			lista.add(new ProbpruebaOperadorDeUnoAOtro(this,ady[i]));			
		}	
		return lista;		
	}
	
	public boolean equals(Object e) {
		ProbpruebaEstado c = (ProbpruebaEstado) e;
		return (c.ID == this.ID);
	}
	
	public int getHeuristica() {
		int h;
		switch (ID) {
		case 1:
			h = 1;			
			break;
		case 2:
			h = 1;			
			break;
		case 3:
			h = 0;			
			break;
		default:
			h = 0;
			break;
		}
		return h;
	}
	

	public String mostrarInfo() {
		return "\nID del Estado:\n"+ID+"\n";
	}

	public Estado getCopia() {
		return new ProbpruebaEstado(this.ID);
	}
}