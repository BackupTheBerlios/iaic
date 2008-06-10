package algoritmos;

import java.util.Iterator;
import java.util.Vector;

public class KMedias {

	//peso exponencial
	private final int b = 2;
	private Vector<Clase> vectorClases = new Vector<Clase>();
	
	/**
	 * Returns the distance between two data points
	 *
	 * @param	dp1 	the first data point
	 * @param	dp2 	the second data point
	 * @return	the distance between the two data points
	 */
	public static double distance(float[] dp1, float[] dp2) {
	
		double result = 0;
		long arg0 = 0;
		double [] resultVector = new double[dp1.length];
		for (int i = 0; i < resultVector.length; i++){
			resultVector[i] = dp1[i] - dp2[i];
			arg0 += (resultVector[i]*resultVector[i]);
		}
		result = Math.sqrt(arg0);
		return result;	
	} // end of distance()
	
	
	public float pertenencia (float[] vector, int clase){
		float[] result = null;
		int sumat = 0;
		int resultadoParcial = 0;
		double distancia = 0;
		for (Iterator i = vectorClases.iterator(); i.hasNext();) {
			Clase claseAux = (Clase) i.next();
			distancia = distance(vector,claseAux.getCentro());
			resultadoParcial = Math.pow((1/distancia),(1/d-1));
			sumat += resultadoParcial;
		}
			
		
		return result;
	}
	
	
	public float[] eme (int i){
		float result = null;
		
		return result;
	}
	
	
	
	
	
	
}
