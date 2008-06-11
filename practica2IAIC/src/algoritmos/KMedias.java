package algoritmos;

import java.util.Iterator;
import java.util.Vector;

public class KMedias {

	//peso exponencial
	private final int b = 2;
	private int n; 
	private int epsilon;
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
	
	
	public double convergencia (float[] muestra, int clase, int t){
		return Math.abs(Math.pow(pertenencia(muestra, clase), t) -
						Math.pow(pertenencia(muestra, clase), (t-1) ));
	}
	
	public double pertenencia (float[] vector, int clase){
		double result = 0;
		int sumat = 0;
		double resultadoParcial = 0;
		double distancia = 0;
		for (Iterator<Clase> i = vectorClases.iterator(); i.hasNext();) {
			Clase claseAux = (Clase) i.next();
			distancia = distance(vector,claseAux.getCentro());
			resultadoParcial = Math.pow((1/distancia),(1/(b-1)));
			sumat += resultadoParcial;
		}
		double numerador = (1/(distance(vectorClases.get(clase).getCentro(), vector)));	
		numerador = Math.pow((numerador),(1/(b-1)));
		result = (numerador/resultadoParcial);
		return result;
	}
	
	
	public float[] muestraPorEscalar (float[] muestra, double esc){
		float [] resultado = new float[muestra.length];
		for (int i = 0; i < muestra.length; i++){
			resultado[i] = (float)(muestra[i]*esc);
		}
		return resultado;
	}
	
	public float[] divPorEscalar (float[] muestra, double esc){
		float [] resultado = new float[muestra.length];
		for (int i = 0; i < muestra.length; i++){
			resultado[i] = (float)(muestra[i]/esc);
		}
		return resultado;
	}
	
	public float[] sumaVect (float[] muestra, float[] acum){
		float[] result = new float[muestra.length];
		for (int i = 0; i < muestra.length; i++)
			result[i] = muestra[i] + acum[i];
		return result;
	}
	
	
	
	public float[] eme (float[] muestra){
		float [] result = new float[muestra.length];
		float [] numerador = new float[muestra.length];
		double pesoActual, denominador = 0;
		for (int i = 0; i < n; i++){
			pesoActual = Math.pow((pertenencia (muestra, i)),b);
			numerador = sumaVect(muestraPorEscalar(muestra, pesoActual),
								numerador);
			denominador += pesoActual;
			}
		result = divPorEscalar(numerador, denominador);
		return result;
	}
	
	
	
	
	
	
}
