package algoritmos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

public class AlgoritmoLloyd {
	private int muestras;
	private int atributos;
	private int clases;
	private Vector<Muestra> vectorCentros = new Vector<Muestra>();
	private Vector<Muestra> vectorMuestras = new Vector<Muestra>();

	private double razon = 0.01;
	private final double epsilon = 0.05;
	private float[][] cPrev;
	
	public AlgoritmoLloyd(int numMuestras,Vector<Muestra> centros,Vector<Muestra> vectorMuestras){
		this.muestras = numMuestras;
		this.vectorCentros = centros;
		this.vectorMuestras = vectorMuestras;
		this.clases = vectorCentros.size();
		this.atributos = vectorMuestras.elementAt(0).getContent().length;
		
		cPrev = new float[clases][atributos];
		for (int j=0;j<clases;j++){
			for (int i=0;i<atributos;i++){
				cPrev[j][i] = 0;
			}
		}
		ejecuta();
	}
	
	private void ejecuta(){
		boolean termina = true;
		while (termina){
			for (Iterator iter = vectorMuestras.iterator();iter.hasNext();) {
				Muestra muestra = (Muestra) iter.next();
				int jMin = 0;
				double distanciaMin = java.lang.Integer.MAX_VALUE;
				for (int i = 0; i < this.clases; i++) {
					double distancia = distance(muestra,vectorCentros.elementAt(i));
					if (distancia < distanciaMin){
						distanciaMin = distancia;
						jMin = i;
					}
				}
				muestra.setClase(jMin);
				termina = termina && !actualizaCentros(jMin,muestra);
			}
		}
	}
	
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

	public boolean actualizaCentros(int indice,Muestra m){
		boolean converge = false;
		float[] aux;
		int claseAux;
		float[] nuevoCentro = new float[this.atributos];
		float[] antCentro = vectorCentros.elementAt(indice).getContent();
		for (int i=0;i<atributos;i++){
			double r = Math.abs(m.getContent()[i]-antCentro[i]);
			r = r * razon;
			nuevoCentro[i] = antCentro[i] + (float)r;
		}
		claseAux = vectorCentros.elementAt(indice).getClase();
		aux = cPrev[claseAux];
		//Convergencia
		for (int i=0;i<atributos && !converge;i++){
			double abs = Math.abs(antCentro[i] - nuevoCentro[i]);
			converge = (abs < epsilon);
		}
		cPrev[vectorCentros.elementAt(indice).getClase()] = nuevoCentro;
		Muestra m2 = new Muestra(nuevoCentro);
		m2.setClase(vectorCentros.elementAt(indice).getClase());
		vectorCentros.remove(indice);
		vectorCentros.add(indice, m2);
		return converge;
	}
}
