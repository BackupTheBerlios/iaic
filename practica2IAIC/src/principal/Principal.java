package principal;

import java.util.Vector;

import algoritmos.*;

public class Principal {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 2){
			CuantizacionVectorial clasificador = new CuantizacionVectorial(args[0],args[1]);
			int numClases = clasificador.getNumClases();
			Vector<Muestra> todasMuestras = addMuestras(clasificador.getVectorMuestras(),args[1]);
			KMedias kmedias = new KMedias(numClases,todasMuestras);
			//AlgoritmoLloyd aprende = new AlgoritmoLloyd(args[1],args[2]);
		}else{
			System.out.println("Argumentos mal");
		}
	}
	
	private static Vector<Muestra> addMuestras(Vector<Muestra> muestras,String fileAprender){
		return muestras;
	}

}