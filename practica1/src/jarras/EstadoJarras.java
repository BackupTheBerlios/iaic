package jarras;

import java.util.LinkedList;
import java.util.List;

import problema.Estado;
import problema.Operador;

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
	public List<Operador> operadoresAplicables(){
		List<Operador>	listaOperadores	=	new	LinkedList<Operador>();
		/** Llenar J4
		 *  Llenar J3
		 *  Vaciar J4
		 *  Vaciar J3
		 *  Trasvase J3J4
		 *  Trasvase J4J3
		 * */
		if (this.jarra3 <= 0)
			listaOperadores.add(new LlenarJ3(this));
		if (this.jarra4 <= 0)
			listaOperadores.add(new LlenarJ4(this));
		if (this.jarra3 >= 0)
			listaOperadores.add(new VaciarJ3(this));
		if (this.jarra4 >= 0)
			listaOperadores.add(new VaciarJ4(this));
		if (this.jarra3 < 3 && this.jarra4 > 0)
			listaOperadores.add(new TrasvaseJ4J3(this));
		if (this.jarra4 < 4 && this.jarra3 > 0)
			listaOperadores.add(new TrasvaseJ3J4(this));
		return listaOperadores;
	}
	//Calcula la heuristica de un estado
	public int calculaHeuristica(){
		return 0;
	}
}
