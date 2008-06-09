package algoritmos;

import java.util.Vector;
import java.util.StringTokenizer;
import java.io.*;

public class CuantizacionVectorial {
	private int muestras;
	private int atributos;
	private float umbral = 20;
	private float[][] vectorMuestras;
	private Vector<Clase> vectorClases = new Vector<Clase>();
	
	public CuantizacionVectorial(String ficheroEntrada,String ficheroSalida,
								int muestras,int atributos){
		System.out.println("inicio CV");
		this.muestras = muestras;
		this.atributos = atributos;
		vectorMuestras = new float[this.muestras][this.atributos];
		leeFichero(ficheroEntrada);
		ejecuta();
		muestraSolucion();
		vuelcaFichero(ficheroSalida);
		System.out.println("fin CV");
	}

	private void leeFichero(String ficheroEntrada){
		int row = 0;
		int col = 0;
		try{
			File f = new File(ficheroEntrada);
			FileReader entrada = new FileReader(f);
			BufferedReader buffer = new BufferedReader(entrada);
			String line;
			//lee linea por linea del fichero de texto:
			while((line = buffer.readLine()) != null){	
				StringTokenizer st = new StringTokenizer(line,",");
				st.nextToken();
				while (st.hasMoreTokens()){
					float valor = Float.valueOf(st.nextToken()).floatValue();
					vectorMuestras[row][col] = valor;
				col++;
				}
				if (getAtributos()==0)
					setAtributos(col);
				col = 0;
				row++;
			}
			setMuestras(row);
		}catch(Exception ex) {System.out.println(ex.toString());}
	}
	
	private void vuelcaFichero(String ficheroSalida){
		try{
			File f = new File(ficheroSalida);
			FileWriter fw = new FileWriter(f);
			BufferedWriter buffer = new BufferedWriter(fw);
			PrintWriter salida = new PrintWriter(buffer);
			salida.println(this.vectorMuestras.length);
			salida.println(this.vectorClases.size());
			for(int i=0;i<vectorClases.size();i++){
				Clase c = (Clase)vectorClases.elementAt(i);
				float[] centro = c.getCentro();
				salida.print(centro[0]);
				for (int j=1;j<atributos;j++){
					salida.print(",");
					salida.print(centro[j]);
				}
				salida.println();
			}
			for (int i=0;i<vectorClases.size();i++){
				Clase c = (Clase)vectorClases.elementAt(i);
				for (int k=0;k<c.getNumMuestras();k++){
					salida.print(i);					
					for(int j=0;j<atributos;j++){
						salida.print(",");
						salida.print(c.getMuestras()[k][j]);
					}
					salida.println();
				}
			}
			salida.close();
		}catch (Exception ex){
			System.out.println(ex.toString());
			}

	}
	
	private void ejecuta(){
		Clase c1 = new Clase(0, this.muestras,this.atributos);
		c1.setCentro(vectorMuestras[0]);
		c1.addMuestra(vectorMuestras[0]);
		vectorClases.addElement(c1);
		float[] distancias = new float[vectorClases.size()];
		float d = 0;
		int dmenor = java.lang.Integer.MAX_VALUE;
		for (int i=1;i<muestras;i++){
			for (int j=0;j<vectorClases.size();j++){
				d = distanciaEuclidea(i,j);
				distancias[j] = d;
			}
			/* dmenor es el indice del vectorClases con menor distancia 
			 * del centro a la muestra*/
			dmenor = menorDistancia(distancias);
			if (distancias[dmenor] < umbral){
				aadirMuestra(dmenor,i);
				actualizaCentro(dmenor);
			}else{
				c1 = new Clase(i, this.muestras,this.atributos);
				c1.setCentro(vectorMuestras[i]);
				c1.addMuestra(vectorMuestras[i]);
				vectorClases.addElement(c1);
				distancias = new float[vectorClases.size()]; 
			}
		}
	}
	
	private float distanciaEuclidea(int m,int c){
		float distancia = 0;
		float[] centro = ((Clase)vectorClases.elementAt(c)).getCentro();
		float a;
		float b = 0;
		for (int i=0;i<atributos;i++){
			a = vectorMuestras[m][i] - centro[i];
			a = a*a;
			b = b + a;
		}
		distancia = (float)Math.sqrt(b);
		return distancia;
	}
	
	private int menorDistancia(float[] vector){
		int menor = 0;
		for (int i=1;i<vector.length;i++){
			if (vector[i]<vector[menor])
				menor = i;
		}
		return menor;
	}
	
	private void aadirMuestra(int indiceClase,int indiceMuestra){
		Clase c = (Clase)vectorClases.elementAt(indiceClase);
		c.addMuestra(vectorMuestras[indiceMuestra]);
		vectorClases.set(indiceClase,c);
	}
	
	private void actualizaCentro(int indiceClase){
		Clase c = (Clase)vectorClases.elementAt(indiceClase);
		float[] nuevoCentro = new float[atributos];
		for (int i=0;i<atributos;i++){
			float a = 0;
			for (int j=0;j<c.getNumMuestras();j++){
				float[] muestraC = (c.getMuestras())[j];
				a = a + muestraC[i];
			}
			a = a / c.getNumMuestras();
			nuevoCentro[i] = a;
		}
		c.setCentro(nuevoCentro);
	}
	
	private void muestraSolucion(){
		for (int i=0;i<vectorClases.size();i++){
			Clase c = (Clase)vectorClases.elementAt(i);
			System.out.println("CENTRO CLASE " + (i));
			String sol = "(" + c.getCentro()[0];
			for(int j=1;j<atributos;j++){
				sol = sol + "," + c.getCentro()[j];
			}
			sol = sol + ")";
			System.out.println(sol);
			System.out.print("NUMERO MUESTRAS CLASE " + (i) + " ");
			System.out.println(c.getNumMuestras());
			System.out.println("MUESTRAS CLASE " + (i));
			for (int k=0;k<c.getNumMuestras();k++){
				sol = "(" + c.getMuestras()[k][0];
				for(int j=1;j<atributos;j++){
					sol = sol + "," + c.getMuestras()[k][j];
				}
				sol = sol + ")";
				System.out.println(sol);		
			}
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
}
