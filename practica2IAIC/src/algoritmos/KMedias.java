package algoritmos;

import java.util.Iterator;
import java.util.Vector;

public class KMedias {

	//peso exponencial
	private final int b = 2;
	//error
	private final double epsilon = 0.05;
	
	//numero de muestras
	private int nMuestras;
	//numero de clases
	private int nClases;
	//numero de atributos
	private int nAtribs;
	//P para t-1
	private double[] PPrev;
	//m para t-1
	private float[][] mPrev;
	
	private Vector<Muestra> vectorCentros = new Vector<Muestra>();
	private Vector<Muestra> vectorMuestras = new Vector<Muestra>();
	
	
	public KMedias(int nClases, Vector<Muestra> centros, Vector<Muestra> muestras){
		this.nMuestras = muestras.size();
		this.nClases = nClases;
		this.nAtribs = muestras.elementAt(0).getContent().length;
		this.vectorMuestras = muestras;
		this.vectorCentros = centros;

		PPrev = new double[nMuestras*nClases];
		for (int i = 0; i < nMuestras*nClases; i++){
			PPrev[i] = 0.5;
		}
		mPrev = new float[nClases][nAtribs];
		for (int j=0;j<nClases;j++){
			for (int i=0;i<nAtribs;i++){
				mPrev[j][i] = 0;
			}
		}

		termina();
//		muestraSolucion();
	}
	
	private void muestraSolucion(){
		for (int i=0;i<vectorCentros.size();i++){
			Muestra c = (Muestra)vectorCentros.elementAt(i);
			System.out.println(c.toString());
		}
		for (int i=0;i<vectorMuestras.size();i++){
			Muestra c = (Muestra)vectorMuestras.elementAt(i);
			System.out.println(c.toString());
		}
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
		double arg0 = 0;
		double [] resultVector = new double[dp1.length];
		for (int i = 0; i < resultVector.length; i++){
			resultVector[i] = dp1[i] - dp2[i];
			arg0 = arg0 + (resultVector[i]*resultVector[i]);
		}
		result = Math.sqrt(arg0);
		return result;	
	} // end of distance()
	
	public static double distance(Muestra m1, Muestra m2){
		return distance(m1.getContent(), m2.getContent());
	}
	
	public double pertenencia (float[] vector, int clase){
		double result = 0;
		double sumat = 0;
		double resultadoParcial = 0;
		double distancia = 0;
		for (Iterator<Muestra> i = vectorCentros.iterator(); i.hasNext();) {
			Muestra centroAux = (Muestra) i.next();
			distancia = distance(vector,centroAux.getContent());
			resultadoParcial = Math.pow((1/distancia),(1/(b-1)));
			sumat = sumat + resultadoParcial;
		}
		double d = (distance(vectorCentros.get(clase).getContent(),vector));
		double numerador = 0;
		if (d != 0)
			numerador = 1/d;
		numerador = Math.pow((numerador),(1/(b-1)));
		result = (numerador/sumat);
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
		return muestraPorEscalar(m1.getContent(), esc);
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
	
	
	
	public boolean actualizaCentros(){
		boolean fin = false;
		float[] aux;
		int claseAux;
		for (int i=0;i<vectorCentros.size();i++){
			float[] nuevoCentro = eme(vectorCentros.elementAt(i).getClase());
			claseAux = vectorCentros.elementAt(i).getClase();
			aux = mPrev[claseAux];
			fin = convergenciaM(aux, nuevoCentro);
			mPrev[vectorCentros.elementAt(i).getClase()] = nuevoCentro;
			Muestra m = new Muestra(nuevoCentro);
			m.setClase(vectorCentros.elementAt(i).getClase());
			vectorCentros.remove(i);
			vectorCentros.add(i, m);
		}
		return fin;
	}
	
	
	public boolean termina (){
		double pertAux = 0;
		double pertMax = 0;//Mantiene la pertenencia maxima a una clase que
							//tiene determinada muestra
		int claseMax = 0; //Mantiene la clase a la que una muestra tiene
							//pertenencia maxima
		boolean termina = true; //en cuanto sea false terminamos el bucle
		while(termina){
			int j = 0; //contador total 
			   //(Para recorrer PPrev), es i*vectorMuestras.length	
			for (Iterator iter = vectorMuestras.iterator();	iter.hasNext();) {
				Muestra muestra = (Muestra) iter.next();
				pertMax = 0;
				for (int i = 0; i < this.nClases; i++) {
					//Calculamos la pertenencia de la muestra a la clase
					pertAux = pertenencia(muestra, i);
					termina = termina && !convergenciaP(PPrev[j],pertAux); 									
					//despues de comparar el error, metemos el pertAux en
					//PPrev, para las siguientes vueltas
					PPrev[j] = pertAux;j++;
					pertMax = Math.max(pertAux, pertMax);
					if (pertAux >= pertMax){//En pertAux se mantiene el max
						pertMax = pertAux;//de la pertenencia de la muestra
						claseMax = i;//a cada clase, de forma que al final
					}//se asigna a la clase a la que mas pertenencia tiene
				}
				muestra.setClase(claseMax);
				//System.out.println(muestra.toString());				
			}
			termina = termina && !actualizaCentros();
		}
		return termina;
	}
	
	private boolean convergenciaP(double tAnt, double t){
		double abs = Math.abs(tAnt - t);
		return (abs < epsilon);
	}
	
	private boolean convergenciaM(float[] mAnt, float[] m){
		boolean fin = false;
		for (int i=0;i<mAnt.length && !fin;i++){
			double abs = Math.abs(mAnt[i] - m[i]);
			fin = (abs < epsilon);
		}
		return fin;
	}
}
