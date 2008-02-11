package modelo.problema.ochopuzzle;

import java.util.LinkedList;
import java.util.List;
import modelo.problema.Estado;
import modelo.problema.Operador;

/**
 * @author  Diego
 */
public class PuzzleEstado implements Estado {

	/** Este es el numero de litros en la jarra de 5 litros */
	private int[][] tabla;
		
	public String mostrarInfo() {
		StringBuffer aux = new StringBuffer();
		for (int fila = 0; fila < tabla.length; fila++) {
			for (int col = 0; col < tabla[fila].length; col++) {
				if (tabla[fila][col]>0){
					aux.append(tabla[fila][col]);
				} else{
					aux.append(" ");					
				}
				if (col==2){
					aux.append("\n");
				} else{
					aux.append(" ");
				}
			}
		}				
		return aux.toString();		
	}

	public List<Operador> getOperadoresAplicables() {
		List<Operador>	lista	=	new	LinkedList<Operador>();
		// Buscamos el hueco
		int huecoFil = 0;		
		int huecoCol = 0;
		boolean encontrado = (tabla[huecoFil][huecoCol] == 0);
		while ((huecoFil < 3)&&(huecoCol<3)&&!encontrado){
			encontrado = (tabla[huecoFil][huecoCol] == 0);
			if (!encontrado){

			huecoCol++;			
			if (huecoCol==3){
				huecoCol=0;
				huecoFil++;
			}	
			}
		}		
		if ((huecoFil == 0)||(huecoFil == 1)){
			lista.add(new PuzzleOperadorArriba(this));
		}
		if ((huecoFil == 1)||(huecoFil == 2)){
			lista.add(new PuzzleOperadorAbajo(this));
		}
		if ((huecoCol == 1)||(huecoCol == 2)){
			lista.add(new PuzzleOperadorDerecha(this));
		}
		if ((huecoCol == 0)||(huecoCol == 1)){
			lista.add(new PuzzleOperadorIzquierda(this));
		}		
		return lista;
	}

	public boolean equals(Object e) {
		PuzzleEstado p = (PuzzleEstado) e;
		int[][] t = p.getTabla();
		boolean esigual = true;
		int f = 0;
		int c = 0;
		while ((f<3)&&(c<3)&&esigual){
			if (tabla[f][c] != t[f][c]){
				esigual = false;
			}
			c++;
			if (c == 3){
				c = 0;
				f++;
			}
		}
		return esigual;
	}

	public Estado getCopia() {
		PuzzleEstado p = new PuzzleEstado(new int[3][3]);
		for (int fila = 0; fila < tabla.length; fila++) {
			for (int col = 0; col < tabla[fila].length; col++) {
				p.tabla[fila][col] = this.tabla[fila][col];
			}
		}
		return p;
	}

	public PuzzleEstado(int[][] tabla) {
		super();
		this.tabla = tabla;
	}

	/**
	 * @return  the tabla
	 * @uml.property  name="tabla"
	 */
	public int[][] getTabla() {
		return tabla;
	}

	/**
	 * @param tabla  the tabla to set
	 * @uml.property  name="tabla"
	 */
	public void setTabla(int[][] tabla) {
		this.tabla = tabla;
	}

	public int getHeuristica() {
		int[][] t = this.getTabla();
		int h = 0;
		for (int f = 0; f < t.length; f++) {
			for (int c = 0; c < t[f].length; c++) {
				if (t[f][c]>0){					
					h += Math.abs(((t[f][c]-1)/3) - f); // distancia filas
					h += Math.abs(((t[f][c]-1)%3) - c); // distancia columnas
				}
			}
		}	
		return h;
	}

}
