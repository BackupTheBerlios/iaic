package algoritmos;

import java.util.Iterator;
import java.util.Vector;

public class KMedias {

	//peso exponencial
	private final int b = 2;
	//error
	private final double epsilon = 0.3;
	
	//numero de muestras
	private int nMuestras;
	//numero de clases
	private int nClases;
	//numero de atributos
	private int nAtribs;
	//P para t-1
	private double[] PPrev;
//	//m para t-1
//	private float[] mPrev;
	
	private Vector<Clase> vectorClases = new Vector<Clase>();
	private Vector<Muestra> vectorMuestras = new Vector<Muestra>();
	
	
	public KMedias(int nClases, float[][] centros, float[][] muestras){
		this.nMuestras = muestras.length;
		this.nClases = nClases;
		this.nAtribs = muestras[0].length;
		vectorMuestras = new Vector<Muestra>(nMuestras);
		vectorClases = new Vector<Clase>(nClases);
		Clase claseAux;
		for (int i = 0; i < nClases; i++) {
			claseAux = new Clase(i);
			claseAux.setCentro(centros[i]);
			vectorClases.add(claseAux);
		}
		for (int i = 0; i < nMuestras; i++)
			vectorMuestras.add(new Muestra(muestras[i]));
		
		PPrev = new double[nMuestras*nClases];
		for (int i = 0; i < nMuestras*nClases; i++)
			PPrev[i] = 0;
	}
	
	
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
	
	public static double distance(Muestra m1, Muestra m2){
		return distance(m1.getContent(), m2.getContent());
	}
	
	
	public double convergencia (float[] muestra, int clase, int t){
		return Math.abs(Math.pow(pertenencia(muestra, clase), t) -
						Math.pow(pertenencia(muestra, clase), (t-1) ));
	}
	
	public double convergencia (Muestra m1, int clase, int t){
		return convergencia (m1.getContent(), clase, t);	
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
		double numerador = (1/(distance(vectorClases.get(clase).getCentro(),
																	vector)));	
		numerador = Math.pow((numerador),(1/(b-1)));
		result = (numerador/resultadoParcial);
		return result;
	}
	
	public double pertenencia (Muestra m1, int clase){
		return pertenencia (m1.getContent(), clase);
	}
	
	public float[] muestraPorEscalar (float[] muestra, double esc){
		float [] resultado = new float[muestra.length];
		for (int i = 0; i < muestra.length; i++){
			resultado[i] = (float)(muestra[i]*esc);
		}
		return resultado;
	}
	
	public float[] muestraPorEscalar (Muestra m1, double esc){
		return muestraPorEscalar(m1, esc);
	}
		
	public float[] divPorEscalar (float[] muestra, double esc){
		float [] resultado = new float[muestra.length];
		for (int i = 0; i < muestra.length; i++){
			resultado[i] = (float)(muestra[i]/esc);
		}
		return resultado;
	}
	
	public float[] divPorEscalar (Muestra m1, double esc){
		return divPorEscalar(m1.getContent(), esc);
	}
	
	public float[] sumaVect (float[] muestra, float[] acum){
		float[] result = new float[muestra.length];
		for (int i = 0; i < muestra.length; i++)
			result[i] = muestra[i] + acum[i];
		return result;
	}
	
	public float[] sumaVect (Muestra m1, float[] acum){
		return sumaVect(m1.getContent(), acum);
	}
	
	public float[] eme (int clase){
		float [] result = new float[nAtribs];
		float [] numerador = new float[nAtribs];
		double pesoActual, denominador = 0;
		Muestra muestraAux;
		for (int i = 0; i < nMuestras; i++){
			muestraAux = vectorMuestras.get(i);
			pesoActual = Math.pow((pertenencia(muestraAux,clase)),b);
			numerador = sumaVect(muestraPorEscalar(muestraAux, pesoActual),
								numerador);
			denominador += pesoActual;
			}
		result = divPorEscalar(numerador, denominador);
		return result;
	}
	
	
	
	public void actualizaCentros(){
		
		
	}
	
	
	public boolean termina (){
		double pertAux = 0;
		double pertMax = 0;//Mantiene la pertenencia maxima a una clase que
							//tiene determinada muestra
		int claseMax = 0; //Mantiene la clase a la que una muestra tiene
							//pertenencia maxima
		boolean termina = true; //en cuanto sea false terminamos el bucle
		int j = 0; //contador total 
				   //(Para recorrer PPrev), es i*vectorMuestras.length
		while(termina){
			for (Iterator iter = vectorMuestras.iterator();	iter.hasNext();) {
					Muestra muestra = (Muestra) iter.next();
					for (int i = 0; termina && i < this.nClases; i++, j++) {
						//Calculamos la pertenencia de la muestra a la clase
						pertAux = pertenencia(muestra, i);
						termina = termina &&
								  !(Math.abs(pertAux - PPrev[j]) < epsilon);
						//despues de comparar el error, metemos el pertAux en
						//PPrev, para las siguientes vueltas
						PPrev[j] = pertAux;
						pertMax = Math.max(pertAux, pertMax);
						if (pertAux > pertMax){//En pertAux se mantiene el max
							pertMax = pertAux;//de la pertenencia de la muestra
							claseMax = i;//a cada clase, de forma que al final
						}//se asigna a la clase a la que más pertenencia tiene
					}
					muestra.setClase(claseMax);
					j++;
			}
			 actualizaCentros();
		}
		return termina;
	}
	
	
}
