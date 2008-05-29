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

	public AlgoritmoLloyd(String ficheroTraining,String ficheroMuesrasNuevas,String ficheroAprende){
		leerFicheroTraining(ficheroTraining);
	}
	
	private void leerFicheroTraining(String ficheroTraining){
		int row = 0;
		int col = 0;
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
				}
				this.atributos = v_atributos.size();
			}
			for (int i=0;i<clases;i++){
				Clase c = new Clase(muestras,atributos);
				if ((line = buffer.readLine())!= null){
					StringTokenizer st = new StringTokenizer(line,",");
					Float[] centro = new Float[atributos];
					int j = 0;
					while (st.hasMoreTokens()){
						Float valor = Float.valueOf(st.nextToken()).floatValue();
						centro[j] = valor;
						j++;
					}
					c.setCentro(centro);
				}
			}
			/* Ya tengo el numero de Muestras, el numero de clases y los centro de cada clase 
			 * Queda repartir cada muestra en su clase 
			 */
			for (int i=0;i<muestras;i++){
				if ((line = buffer.readLine()) != null){
					StringTokenizer st = new StringTokenizer(line,",");
					//int numClase = new Integer(st.nextToken());
					Float[] muestra = new Float[atributos];
					int j=1;
					while (st.hasMoreTokens()){
						Float valor = Float.valueOf(st.nextToken()).floatValue();
						muestra[j-1] = valor;
						vectorMuestras[i][j-1] = valor;
						j++;
					}
				}
			}
		}catch(Exception ex) {System.out.println(ex.toString());}
	}

}
