package modelo.problema.jarras;

import java.util.LinkedList;
import java.util.List;
import modelo.problema.*;

public class EstadoJarras implements Estado{
	int jarra3,jarra4;
	
	public EstadoJarras(int j3,int j4) {
		super();
		this.jarra3 = j3;
		this.jarra4 = j4;
	}
	public int getJarra3() {
		return this.jarra3;
	}
	public void setJarra3(int jarra3) {
		this.jarra3 = jarra3;
	}
	public int getJarra4() {
		return this.jarra4;
	}
	public void setJarra4(int jarra4) {
		this.jarra4 = jarra4;
	}
	//Muestra informacion de un estado
	public String mostrarInfo(){
		String s = "Contenido Jarra pequeña: " + jarra3 + " litros;";
		s = s + "\n" + "Contenido Jarra grande: " + jarra4 + " litros;";
		return s;
	}
	//Comprobacion de igualdad de dos estados
	public boolean equals(Object e2){
		if ((jarra3 == ((EstadoJarras)e2).getJarra3()) &&
				(jarra4 == ((EstadoJarras)e2).getJarra4()))
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
		if (this.jarra3 < 3)
			listaOperadores.add(new OperadorLlenarJ3(this));
		if (this.jarra4 < 4)
			listaOperadores.add(new OperadorLlenarJ4(this));
		if (this.jarra3 > 0)
			listaOperadores.add(new OperadorVaciarJ3(this));
		if (this.jarra4 > 0)
			listaOperadores.add(new OperadorVaciarJ4(this));
		if (this.jarra3 < 3 && this.jarra4 > 0)
			listaOperadores.add(new OperadorTrasvaseJ4J3(this));
		if (this.jarra4 < 4 && this.jarra3 > 0)
			listaOperadores.add(new OperadorTrasvaseJ3J4(this));
		

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
}
