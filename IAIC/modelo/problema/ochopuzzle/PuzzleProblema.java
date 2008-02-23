package modelo.problema.ochopuzzle;

import modelo.problema.Estado;
import modelo.problema.Problema;

public class PuzzleProblema implements Problema {
	
	public PuzzleProblema(boolean resoluble){
		super();
	}
	
	public Estado getInicial() {
		int[][] tabla = new int[3][3];
		for (int fila = 0; fila < tabla.length; fila++) {			
			switch (fila) {
			case 0:
				tabla[fila][0] = 3;
				tabla[fila][1] = 2;
				tabla[fila][2] = 5;
				break;
			case 1:
				tabla[fila][0] = 6;
				tabla[fila][1] = 8;
				tabla[fila][2] = 1;
				break;
			case 2:
				tabla[fila][0] = 0;
				tabla[fila][1] = 4;
				tabla[fila][2] = 7;			
				break;
			default:
				break;
			} 
		}		
		return new PuzzleEstado(tabla);
	}

	public int evaluarHeuristica(Estado e) {
		PuzzleEstado p = (PuzzleEstado) e;
		return p.getHeuristica();		
	}

	public boolean esObjetivo(Estado e) {
		PuzzleEstado p= (PuzzleEstado)e;
		int[][] tablaux = p.getTabla();
		boolean estaresuelto = true;
		for (int fila = 0; fila < tablaux.length; fila++) {
			for (int col = 0; col < tablaux[fila].length; col++) {
				estaresuelto = estaresuelto &&
				   ((tablaux[fila][col] == 3*fila + (col+1))||
				    ((tablaux[fila][col]==0)&&(fila==2)&&(col==2)));
			}
		}
		return estaresuelto;
	}

	public String toString() {
		return "Problema del 8-puzzle \n\n";
	}

	public Estado getEstado() {
		return getInicial();
	}
}
