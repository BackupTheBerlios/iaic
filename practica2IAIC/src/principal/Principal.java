package principal;

import algoritmos.*;

public class Principal {

	/**
	 * @param args
	 */
	private static int muestras = 8;
	private static int atributos = 3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//178x13
		if (args.length == 3){
			CuantizacionVectorial clasificador = new CuantizacionVectorial 
										(args[0],args[1],muestras,atributos);
			AlgoritmoLloyd aprende = new AlgoritmoLloyd(args[1],args[2]);
			//kMeans kmedias = new kMeans();
		}else{
			System.out.println("Argumentos mal");
		}
	}

}