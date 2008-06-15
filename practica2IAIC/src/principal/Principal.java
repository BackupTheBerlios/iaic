package principal;

import algoritmos.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

public class Principal {

	/**
	 * @param args
	 */
	private static int muestras = 8;
	private static int atributos = 3;
	
	private static boolean lloyd = false;
	private static boolean kmedias = false;
	private static boolean som = false;
	
	private static String input = "";
	private static String training = "";
	private static String output = "";
	
	private static Vector<Muestra> vectorMuestrasEntrenamiento;
	private static Vector<Muestra> vectorMuestrasEntrada;
	
	
	public static void ayuda(){
		System.out.println(
	"Uso: java -jar IA.jar [algoritmos] [entrenamiento] [entrada] [salida]\n" +
	"\n" +
	"[algoritmos]:\n"+
	"\tDebe expresarse que algoritmos se desean probar,\n" +
	"\trequerido al menos uno de ellos\n" +
	"\n" +
	"\tSintaxis:\n" +
	"\t\tLloyd:    --lloyd, -l \n" +
	"\t\tK-Medias: --kmedias, -k\n" +
	"\t\tSOM:      --som, -s\n" +
	"\n" +
	"[entrenamiento]:\n" +
	"\tSe entrenara con el archivo indicado y \n" +
	"\tcon el algoritmo de Cuantizacion Vectorial, obligatorio\n" +
	"\n" +
	"\tSintaxis: --entrenamiento [archivo], -t [archivo]\n" +
	"\n" +
	"[entrada]:\n" +
	"\tArchivo con muestras de entrada que serán pasadas al algoritmo\n" +
	"\to los algoritmos elegidos en el apartado [algoritmo]\n" +
	"\n" +
	"\tSintaxis: --entrada [archivo], -i [archivo]\n" +
	"\n" +
	"[salida] (opcional):\n" +
	"\tArchivo de salida, si no se pasa esta opcion, la salida sera\n" +
	"\tpor pantalla\n" +
	"\n" +
	"\tSintaxis: --salida[archivo], -o [archivo]\n" +
	"\n"
		);
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//178x13
	
		int c;
		String arg;
		LongOpt[] longopts = new LongOpt[7];
		// 
		StringBuffer sb = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		StringBuffer sb3 = new StringBuffer();
		longopts[0] = new LongOpt("ayuda", LongOpt.NO_ARGUMENT, null, 'h');
		
		longopts[1] = new LongOpt("salida", LongOpt.REQUIRED_ARGUMENT, sb, 'o'); 
		longopts[2] = new LongOpt("entrenamiento", LongOpt.REQUIRED_ARGUMENT, sb2, 't');
		longopts[3] = new LongOpt("entrada", LongOpt.REQUIRED_ARGUMENT, sb3, 'i'); 
		
		longopts[4] = new LongOpt("lloyd", LongOpt.NO_ARGUMENT, null, 'l');
		longopts[5] = new LongOpt("kmedias", LongOpt.NO_ARGUMENT, null, 'k');
		longopts[6] = new LongOpt("som", LongOpt.NO_ARGUMENT, null, 's');
		
		// 
		Getopt g = new Getopt("testprog", args, "lkmho:t:i:", longopts);
		g.setOpterr(false); // We'll do our own error handling
		//
		
		if (args.length == 0)
			ayuda();
		else
		while ((c = g.getopt()) != -1)
		  switch (c)
		    {
		  
		  case 'l':
			  lloyd = true;
			  break;
			  //
		  case 'k':
			  kmedias = true;
			  break;
			  //
		  case 's':
			  som = true;
			  break;
			  //
		  case 'h':
			  System.out.println("Has pedido ayuda:");
			  ayuda();
			  break;
			  //
		  case 'o':
			  output = g.getOptarg();
			  break;
		  case 't':
			  training = g.getOptarg();
			  break;
		  case 'i':
			  input = g.getOptarg();
			  break;

		         //
		       case '?':
		         System.out.println("La opcion '" + (char)g.getOptopt() + 
		                          "' no es valida");
		         break;
		         //
		       default:
		    	   ayuda();
		         //System.out.println("getopt() returned " + c);
		         break;
		    }
		//
		
		if (training.length() > 0){
			leeFichero(training, vectorMuestrasEntrenamiento);
			CuantizacionVectorial clasificador = 
				new CuantizacionVectorial(muestras, atributos, 
						vectorMuestrasEntrenamiento, output);
			int numClases = clasificador.getNumClases();
			
			
			if (input.length() > 0){

				Vector<Muestra> resultado = clasificador.getVectorMuestras();
				
				leeFichero(input, vectorMuestrasEntrada);
				for (Iterator iter = vectorMuestrasEntrada.iterator();
														iter.hasNext();) {
					Muestra m = (Muestra) iter.next();
					resultado.add(m);
				}
					
				if (lloyd){
					Vector<Muestra> muestrasLloyd = new Vector<Muestra>();
					muestrasLloyd = (Vector<Muestra>) resultado.clone();
					AlgoritmoLloyd algLloyd = new AlgoritmoLloyd(numClases,
											muestrasLloyd);
				}
				if (kmedias){
					Vector<Muestra> muestrasKmedias = new Vector<Muestra>();
					muestrasKmedias = (Vector<Muestra>) resultado.clone();
					KMedias KMedias = new KMedias(numClases, muestrasKmedias);
				}
				if (som){ //FIXME: Sustituir por el constructor de SOM 
							//cuando este hecho
					Vector<Muestra> muestrasSOM = new Vector<Muestra>();
					muestrasSOM = (Vector<Muestra>) resultado.clone();
					KMedias SOM = new KMedias(numClases, muestrasSOM);
					
				}
			}
		}
		
		
			
		
		for (int i = g.getOptind(); i < args.length ; i++)
			     System.out.println(args[i] + " no es una opcion \n");

		
		
		/*
		
		if (args.length == 3){
			CuantizacionVectorial clasificador = new CuantizacionVectorial 
										(args[0],args[1],muestras,atributos);
			AlgoritmoLloyd aprende = new AlgoritmoLloyd(args[1],args[2]);
			//kMeans kmedias = new kMeans();
		}else{
			System.out.println("Argumentos mal");
		}
		*/
		
		if (args.length == 2){
			CuantizacionVectorial clasificador = new CuantizacionVectorial(args[0],args[1]);
			int numClases = clasificador.getNumClases();
			Vector<Muestra> todasMuestras = addMuestras(clasificador.getVectorMuestras(),args[1]);
			KMedias kmedias = new KMedias(numClases,todasMuestras);
			//AlgoritmoLloyd aprende = new AlgoritmoLloyd(args[1],args[2]);
		}else{
			System.out.println("Argumentos mal");
		}
	}
	
	

	private static void leeFichero(String ficheroEntrada, Vector<Muestra> vectorMuestras){
		try{
			File f = new File(ficheroEntrada);
			FileReader entrada = new FileReader(f);
			BufferedReader buffer = new BufferedReader(entrada);
			String line;
			line = buffer.readLine();
			StringTokenizer st = new StringTokenizer(line,",");
			atributos = st.countTokens()-1;
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
			muestras += vectorMuestras.size();
		}catch(Exception ex) {System.out.println(ex.toString());}
	}
	
	
	
	private static Vector<Muestra> addMuestras(Vector<Muestra> muestras,String fileAprender){
		return muestras;
	}
		
		
	

}
