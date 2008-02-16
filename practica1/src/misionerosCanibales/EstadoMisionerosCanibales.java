package misionerosCanibales;
import problema.Estado;
import problema.Operador;

import java.util.List;
import java.util.LinkedList;

public class EstadoMisionerosCanibales implements Estado{
	
	int numMisioneros,numCanibales,posicionBarca;
	
	public EstadoMisionerosCanibales(int nM,int nC,int pB) {
		super();
		this.numMisioneros = nM;
		this.numCanibales = nC;
		this.posicionBarca = pB;
	}
	
	public int getNumMisioneros() {
		return numMisioneros;
	}


	public void setNumMisioneros(int numMisioneros) {
		this.numMisioneros = numMisioneros;
	}


	public int getNumCanibales() {
		return numCanibales;
	}


	public void setNumCanibales(int numCanibales) {
		this.numCanibales = numCanibales;
	}


	public int getPosicionBarca() {
		return posicionBarca;
	}


	public void setPosicionBarca(int posicionBarca) {
		this.posicionBarca = posicionBarca;
	}


	//Muestra informacion de un estado
	public String mostrarInfo(){
		String s;
		s = "Posicion orilla izquierda: ";
		s = s + numMisioneros + " misioneros, ";
		s = s + numCanibales + " canibales. ";
		if (posicionBarca == 1)
			s = s + "La barca esta a la izquierda";
		else 
			s = s + "La barca esta a la derecha";
		return s;
	}
	//Comprobacion de igualdad de dos estados
	public boolean equals(Object e2){
		if ((numMisioneros == ((EstadoMisionerosCanibales)e2).getNumMisioneros()) &&
				(numCanibales == ((EstadoMisionerosCanibales)e2).getNumCanibales())&&
				(posicionBarca == ((EstadoMisionerosCanibales)e2).getPosicionBarca()))
			return true;
		else
			return false;
	}
	//Lista de operadores aplicables a un estado
	public List<Operador> operadoresAplicables(){
		List<Operador>	listaOperadores	=	new	LinkedList<Operador>();
		/** Mover 1 Misionero
		 *  Mover 2 Misioneros
		 *  Mover 1 Canibal
		 *  Mover 2 Canibales
		 *  Mover 1 Misionero y 1 Canibal
		 * */
		if (!peligro()){
			if (((numMisioneros > 0) && (posicionBarca == 1)) || ((numMisioneros < 3) && (posicionBarca == 0)))
				listaOperadores.add(new Mover1Misionero(this));
			if (((numMisioneros > 1) && (posicionBarca == 1)) || ((numMisioneros < 2) && (posicionBarca == 0)))
				listaOperadores.add(new Mover2Misioneros(this));
			if (((numCanibales > 0) && (posicionBarca == 1)) || ((numCanibales < 3) && (posicionBarca == 0)))
				listaOperadores.add(new Mover1Canibal(this));
			if (((numCanibales > 1) && (posicionBarca == 1)) || ((numCanibales < 2) && (posicionBarca == 0)))
				listaOperadores.add(new Mover2Canibales(this));
			if (((numMisioneros > 0) && (numCanibales > 0) && (posicionBarca == 1)) || 
					((numMisioneros < 3) && (numCanibales < 3) && (posicionBarca == 0)))
				listaOperadores.add(new MoverMisioneroCanibal(this));
		}
		return listaOperadores;
	}
	//Calcula la heuristica de un estado
	public int calculaHeuristica(){
		return 0;
	}

	private boolean peligro(){
		if (((numCanibales > numMisioneros) && (numMisioneros!=0) && (posicionBarca == 1)) || 
				((numCanibales < numMisioneros) && (numMisioneros!=3) && (posicionBarca == 0)))
			return true;
		else 
			return false;
	}
}
