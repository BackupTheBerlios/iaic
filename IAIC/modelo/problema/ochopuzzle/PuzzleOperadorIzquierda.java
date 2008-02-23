package modelo.problema.ochopuzzle;


public class PuzzleOperadorIzquierda extends PuzzleOperador {

	protected void calculaFinal() {
		PuzzleEstado p = (PuzzleEstado) getInicial();
		int[][] tablaux = new int[3][3];
		int[][] t = p.getTabla();

		int f = 0;
		int c = 0;
		
		/*Posicion donde se encuentra el hueco en la tabla*/
		int huecoFil = 0;
		int huecoCol = 0;
		while ((f < 3)&&(c<3)){
			tablaux[f][c] = t[f][c];
//			 Miramos si es el hueco:
			if (tablaux[f][c] == 0){
				huecoFil = f;
				huecoCol = c;				
			}
			c++;
			if (c==3){
				c = 0;
				f++;
			}
		}
		tablaux[huecoFil][huecoCol] = tablaux[huecoFil][huecoCol+1];
		tablaux[huecoFil][huecoCol+1] = 0;
		EstadoFinal	= new PuzzleEstado(tablaux);	
	}

	public String toString() {
		return "Mover ficha hacia la izquierda.\n";
	}

	/**
	 * @param inicial
	 */
	public PuzzleOperadorIzquierda(PuzzleEstado inicial) {
		super(inicial);
	}

}
