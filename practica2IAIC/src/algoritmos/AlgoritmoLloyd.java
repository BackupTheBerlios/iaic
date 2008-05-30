package algoritmos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class AlgoritmoLloyd {
	private int muestras;
	private int atributos;
	private int clases;
	private Float[][] vectorMuestras;
	private Vector<Clase> vectorClases = new Vector<Clase>();

	public AlgoritmoLloyd(String ficheroTraining,String ficheroAprende){
		leerFicheroTraining(ficheroTraining);
	}
	
	private void leerFicheroTraining(String ficheroTraining){
		try{
			File f = new File(ficheroTraining);
			FileReader entrada = new FileReader(f);
			BufferedReader buffer = new BufferedReader(entrada);
			String line;
			//lee linea por linea del fichero de texto:
			if ((line = buffer.readLine())!= null)
				this.muestras = new Integer(line);
			if ((line = buffer.readLine())!= null)
				this.clases = new Integer(line);
			Vector<Float> v_atributos = new Vector<Float>();
			if ((line = buffer.readLine())!= null){
				StringTokenizer st = new StringTokenizer(line,",");
				while (st.hasMoreTokens()){
					Float valor = Float.valueOf(st.nextToken()).floatValue();
					v_atributos.addElement(valor);
					this.atributos++;
				}
			}
			Clase c = new Clase(muestras,atributos);
			Float[] centro = new Float[atributos];
			centro = v_atributos.toArray(centro);
			c.setCentro(centro);
			vectorClases.addElement(c);
			for (int i=1;i<clases;i++){
				c = new Clase(muestras,atributos);
				if ((line = buffer.readLine())!= null){
					StringTokenizer st = new StringTokenizer(line,",");
					centro = new Float[atributos];
					int j = 0;
					while (st.hasMoreTokens()){
						Float valor = Float.valueOf(st.nextToken()).floatValue();
						centro[j] = valor;
						j++;
					}
					c.setCentro(centro);
					vectorClases.addElement(c);
				}
			}
			/* Ya tengo el numero de Muestras, el numero de clases y los centro de cada clase 
			 * Queda repartir cada muestra en su clase 
			 */
			vectorMuestras = new Float[muestras][atributos];
			int k=0;
			while ((line = buffer.readLine())!= null){
				StringTokenizer st = new StringTokenizer(line,",");
				int numClase = Integer.parseInt(st.nextToken());//class number
				Float[] m = new Float[atributos];//creo una muestra nueva
				int j=0;
				while (st.hasMoreTokens()){
					Float valor = Float.valueOf(st.nextToken()).floatValue();
					m[j] = valor;
					j++;
				}// Ya tengo la muestra leida
				c = (Clase)vectorClases.elementAt(numClase);
				c.addMuestra(m);
				vectorMuestras[k] = m;
				k++;
			}
		}catch(Exception ex) {System.out.println(ex.toString());}
		System.out.println("Fin Lloyd");
	}

}
