package modelo.problema.jarras;

import java.util.LinkedList;
import java.util.List;
import modelo.problema.*;

public class EstadoJarras implements Estado{
	int jPeque,jGrande;
	int tamP,tamG;
	
	public EstadoJarras(int jP,int jG,int tamP,int tamG) {
		super();
		this.jPeque = jP;
		this.jGrande = jG;
		this.tamP = tamP;
		this.tamG = tamG;
	}
	
	public EstadoJarras(int jP,int jG) {
		super();
		this.jPeque = jP;
		this.jGrande = jG;
	}

	public int getJGrande() {
		return jGrande;
	}

	public void setJGrande(int grande) {
		jGrande = grande;
	}

	public int getJPeque() {
		return jPeque;
	}

	public void setJPeque(int peque) {
		jPeque = peque;
	}


	//Muestra informacion de un estado
	public String mostrarInfo(){
		String s = "Contenido Jarra pequeña: " + jPeque + " litros;";
		s = s + "\n" + "Contenido Jarra grande: " + jGrande + " litros;";
		return s;
	}
	//Comprobacion de igualdad de dos estados
	public boolean equals(Object e2){
		if ((jPeque == ((EstadoJarras)e2).getJPeque()) &&
				(jGrande == ((EstadoJarras)e2).getJGrande()))
			return true;
		else
			return false;
	}
	//Lista de operadores aplicables a un estado
	public List<Operador> getOperadoresAplicables(){
		List<Operador>	listaOperadores	=	new	LinkedList<Operador>();
		/** Llenar J4
		 *  Llenar J3
		 *  Vaciar J4
		 *  Vaciar J3
		 *  Trasvase J3J4
		 *  Trasvase J4J3
		 * */
		if (this.jPeque < tamP)
			listaOperadores.add(new OperadorLlenarJarraPeque(this));
		if (this.jGrande < tamG)
			listaOperadores.add(new OperadorLlenarJarraGrande(this));
		if (this.jPeque > 0)
			listaOperadores.add(new OperadorVaciarJarraPeque(this));
		if (this.jGrande > 0)
			listaOperadores.add(new OperadorVaciarJarraGrande(this));
		if (this.jPeque < tamP && this.jGrande > 0)
			listaOperadores.add(new OperadorTrasvaseGrandePeque(this));
		if (this.jGrande < tamG && this.jPeque > 0)
			listaOperadores.add(new OperadorTrasvasePequeGrande(this));
		

//		System.out.println("Estado jarra3 = " + this.getJarra3() + "\n");
//		System.out.println("Estado jarra4 = " + this.getJarra4() + "\n");
//		System.out.println("Lista de operadores aplicables:" + "\n");
//		if (listaOperadores != null){
//			Object[] opers = listaOperadores.toArray();
//			for(int i=0;i<opers.length;i++){
//				System.out.println(((Operador)opers[i]).getNombre() + "\n");
//			}
//		}
		
		
		return listaOperadores;
	}
	//Calcula la heuristica de un estado
	public int getHeuristica(){
		return 0;
	}

	public int getTamG() {
		return tamG;
	}

	public void setTamG(int tamG) {
		this.tamG = tamG;
	}

	public int getTamP() {
		return tamP;
	}

	public void setTamP(int tamP) {
		this.tamP = tamP;
	}
}
