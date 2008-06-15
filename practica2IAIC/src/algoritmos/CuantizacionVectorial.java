package algoritmos;

import java.util.Vector;
import java.util.StringTokenizer;
import java.io.*;

public class CuantizacionVectorial {
	private int muestras;
	private int atributos;
	private float umbral = 20;
	private int numClases = 0;
	private Vector<Muestra> vectorMuestras = new Vector<Muestra>();
	private Vector<Muestra> vectorCentros = new Vector<Muestra>();
	
	public CuantizacionVectorial(String ficheroEntrada,String ficheroSalida){
		System.out.println("inicio CV");
		leeFichero(ficheroEntrada);
		ejecuta();
		muestraSolucion();
		vuelcaFichero(ficheroSalida);
		System.out.println("fin CV");
	}

	public CuantizacionVectorial(int muest, int atrib, 
								Vector<Muestra> vectorM){
		System.out.println("inicio CV");
		this.vectorMuestras = vectorM;
		this.muestras = muest;
		this.atributos = atrib;
		//leeFichero(ficheroEntrada);
		ejecuta();
		muestraSolucion();
		//vuelcaFichero(ficheroSalida);
		//System.out.println("fin CV");
	}
	
	
	private void leeFichero(String ficheroEntrada){
		try{
			File f = new File(ficheroEntrada);
			FileReader entrada = new FileReader(f);
			BufferedReader buffer = new BufferedReader(entrada);
			String line;
			line = buffer.readLine();
			StringTokenizer st = new StringTokenizer(line,",");
			this.atributos = st.countTokens()-1;
			//lee linea por linea del fichero de texto:
			while (line != null){
				float[] m = new float[atributos];
				int i = 0;
				st = new StringTokenizer(line,",");
				st.nextToken();//Quita el primer valor ==> clase
				while (st.hasMoreTokens()){
					float valor = Float.valueOf(st.nextToken()).floatValue();
					m[i] = valor;
					i++;
				}
				Muestra muestraNueva = new Muestra(m);
				vectorMuestras.add(muestraNueva);
				line = buffer.readLine();
			}
			this.muestras = vectorMuestras.size();
		}catch(Exception ex) {System.out.println(ex.toString());}
	}
	
	private void vuelcaFichero(String ficheroSalida){
		try{
			File f = new File(ficheroSalida);
			FileWriter fw = new FileWriter(f);
			BufferedWriter buffer = new BufferedWriter(fw);
			PrintWriter salida = new PrintWriter(buffer);
			/** CENTROS **/
			for (int i=0;i<vectorCentros.size();i++){
				salida.println(vectorCentros.elementAt(i).toString());
			}
			/** MUESTRAS **/
			for (int i=0;i<vectorMuestras.size();i++){
				salida.println(vectorMuestras.elementAt(i).toString());
			}
			salida.close();
		}catch (Exception ex){
			System.out.println(ex.toString());
			}

	}
	
	private void ejecuta(){
		Muestra m0 = vectorMuestras.firstElement();
		m0.setClase(0);
		vectorCentros.add(m0);
		int muestrasProcesadas = 1;
		for (int i=1;i<vectorMuestras.size();i++){
			Muestra m = vectorMuestras.elementAt(i);
			float distMenor = java.lang.Integer.MAX_VALUE;
			int indice = -1;
			for(int j=0;j<vectorCentros.size();j++){
				Muestra c = vectorCentros.elementAt(j);
				float dist = distance(m.getContent(),c.getContent());
				if (dist < distMenor){
					distMenor = dist;
					indice = j;
				}
			}
			muestrasProcesadas++;
			if (distMenor < umbral){
				m.setClase(indice);
				actualizaCentro(indice,muestrasProcesadas);
			}else{
				numClases++;
				m.setClase(vectorCentros.size());
				vectorCentros.add(m);
			}
		}
	}
	
	public float distance(float[] dp1, float[] dp2) {
		
		float result = 0;
		long arg0 = 0;
		float [] resultVector = new float[dp1.length];
		for (int i = 0; i < resultVector.length; i++){
			resultVector[i] = dp1[i] - dp2[i];
			arg0 += (resultVector[i]*resultVector[i]);
		}
		result = (float)Math.sqrt(arg0);
		return result;
	}
	
	private void actualizaCentro(int indiceClase, int muestrasProcesadas){
		float[] nuevoCentro = new float[atributos];
		for (int j=0;j<atributos;j++){
			int muestrasClase = 0;
			float a = 0;
			for (int i=0;i<muestrasProcesadas;i++){
				Muestra m = vectorMuestras.elementAt(i);
				if (m.getClase() == indiceClase){
					muestrasClase++;
					a = a + m.getContent()[j];
				}
			}
			a = a / muestrasClase;
			nuevoCentro[j] = a;
		}
		Muestra centroClase = new Muestra(nuevoCentro);
		centroClase.setClase(indiceClase);
		vectorCentros.remove(indiceClase);
		vectorCentros.add(indiceClase, centroClase);
	}
		
	private void muestraSolucion(){
		for (int i=0;i<vectorMuestras.size();i++){
			Muestra c = (Muestra)vectorMuestras.elementAt(i);
			System.out.println(c.toString());
		}
	}

	public int getMuestras() {
		return muestras;
	}

	public void setMuestras(int muestras) {
		this.muestras = muestras;
	}

	public int getAtributos() {
		return atributos;
	}

	public void setAtributos(int atributos) {
		this.atributos = atributos;
	}

	public float getUmbral() {
		return umbral;
	}

	public void setUmbral(float umbral) {
		this.umbral = umbral;
	}

	public int getNumClases() {
		return numClases;
	}

	public void setNumClases(int numClases) {
		this.numClases = numClases;
	}

	public Vector<Muestra> getVectorMuestras() {
		return vectorMuestras;
	}

	public void setVectorMuestras(Vector<Muestra> vectorMuestras) {
		this.vectorMuestras = vectorMuestras;
	}

	public Vector<Muestra> getVectorCentros() {
		return vectorCentros;
	}

	public void setVectorCentros(Vector<Muestra> vectorCentros) {
		this.vectorCentros = vectorCentros;
	}
}
