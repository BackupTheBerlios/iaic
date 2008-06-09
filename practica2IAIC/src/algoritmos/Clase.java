package algoritmos;

import java.util.ArrayList;

public class Clase {
	int claseID; //TODO: falta por hacer getters y setters e
				//inicializarlo al principio
	float[] centro;
	float[][] muestras;
	
	
	int numMuestras = 0;

	public Clase(int id) {
		this.claseID = id;
	}
	
	public Clase(int id, int muestras, int atributos) {
		this.claseID = id;
		this.centro = new float[atributos];
		this.muestras = new float[muestras][atributos];
	}
	
	public Clase(int id, float[] centro, float[][] muestras) {
		super();
		this.claseID = id;
		this.centro = centro;
		this.muestras = muestras;
	}
	
	public float[] getCentro() {
		return centro;
	}
	
	public void setCentro(float[] centro) {
		this.centro = centro;
	}
	public void setCentro(Float[] centro) {
		this.centro = new float[centro.length];
		for (int i = 0; i < centro.length; i++)
			this.centro[i] = centro[i].floatValue();
			
	}
	

	/**
	 * Sets the mean data point of this Clase
	 *
	 * @param	meanDataPoint	the new mean data point for this Clase
	 */
	public void setCentro(kMeansPoint meanDataPoint) {
	
		this.centro = meanDataPoint.toFloatArray();
	
	} // end of setMean()
	
	
	public float[][] getMuestras() {
		return muestras;
	}
	public void setMuestras(float[][] muestras) {
		this.muestras = muestras;
	}
	
	public void addMuestra(float[] muestraNueva){
		this.muestras[numMuestras] = muestraNueva;
		this.numMuestras = this.numMuestras + 1;
	}

	public int getNumMuestras() {
		return numMuestras;
	}

	public void setNumMuestras(int numMuestras) {
		this.numMuestras = numMuestras;
	}

	public int getClaseID() {
		return claseID;
	}

	public void setClaseID(int claseID) {
		this.claseID = claseID;
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
	
	
	
	
}
