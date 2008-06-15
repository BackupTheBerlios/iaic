package principal;

import algoritmos.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

public class Principal {

	/**
	 * @param args
	 */
	public  int muestras;
	public  int atributos;
	
	public  boolean lloyd ;
	public  boolean kmedias;
	public  boolean som;
	
	public  String input;
	public  String training;
	public  String output;
	
	public  Vector<Muestra> vectorMuestrasEntrenamiento;
	public  Vector<Muestra> vectorMuestrasEntrada;
	
	
	public Principal(){
		vectorMuestrasEntrada = new Vector<Muestra>();
		vectorMuestrasEntrenamiento = new Vector<Muestra>();
		muestras = 8;
		atributos = 3;
		
		lloyd = false;
		kmedias = false;
		som = false;
		
		 input = "";
		training = "";
		output = "";
	}
	
	
	
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
	
		Principal princip = new Principal();
		
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
			  princip.lloyd = true;
			  break;
			  //
		  case 'k':
			  princip.kmedias = true;
			  break;
			  //
		  case 's':
			  princip.som = true;
			  break;
			  //
		  case 'h':
			  System.out.println("Has pedido ayuda:");
			  Principal.ayuda();
			  break;
			  //
		  case 'o':
			  princip.output = g.getOptarg();
			  break;
		  case 't':
			  princip.training = g.getOptarg();
			  break;
		  case 'i':
			  princip.input = g.getOptarg();
			  break;

		         //
		       case '?':
		         System.out.println("La opcion '" + (char)g.getOptopt() + 
		                          "' no es valida");
		         break;
		         //
		       default:
		    	   Principal.ayuda();
		         //System.out.println("getopt() returned " + c);
		         break;
		    }
		//
		
		PrintWriter salida = null;
		
		if (princip.output.length() > 0){
			try {
				File f = new File(princip.output);
				FileWriter fw = new FileWriter(f);
				BufferedWriter buffer = new BufferedWriter(fw);
				salida = new PrintWriter(buffer);
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
		
		
		if (princip.training.length() > 0){
			princip.leeFichero(princip.training, princip.vectorMuestrasEntrenamiento);
			CuantizacionVectorial clasificador = 
				new CuantizacionVectorial(princip.muestras, princip.atributos, 
						princip.vectorMuestrasEntrenamiento);
			int numClases = clasificador.getNumClases();
			
			Vector<Muestra> resultado = clasificador.getVectorMuestras();
			Vector<Muestra> centros = clasificador.getVectorCentros();
			
			vuelcaFichero(salida, centros, "Centros de las clases");
			vuelcaFichero(salida, resultado, "Resultado de CV");
			
			if (princip.input.length() > 0){

				
				
				princip.leeFichero(princip.input, princip.vectorMuestrasEntrada);
				for (Iterator iter = princip.vectorMuestrasEntrada.iterator();
														iter.hasNext();) {
					Muestra m = (Muestra) iter.next();
					resultado.add(m);
				}
					
				if (princip.lloyd){
					Vector<Muestra> muestrasLloyd = new Vector<Muestra>();
					muestrasLloyd = (Vector<Muestra>) resultado.clone();
					AlgoritmoLloyd algLloyd = new AlgoritmoLloyd(numClases,
											muestrasLloyd);
					vuelcaFichero(salida, resultado, "Resultado de Lloyd");
				}
				if (princip.kmedias){
					Vector<Muestra> muestrasKmedias = new Vector<Muestra>();
					muestrasKmedias = (Vector<Muestra>) resultado.clone();
					KMedias KMedias = new KMedias(numClases, centros,
														muestrasKmedias);
					vuelcaFichero(salida, resultado, "Resultado de Kmedias");
				}
				if (princip.som){ //FIXME: Sustituir por el constructor de SOM 
							//cuando este hecho
					Vector<Muestra> muestrasSOM = new Vector<Muestra>();
					muestrasSOM = (Vector<Muestra>) resultado.clone();
					KMedias SOM = new KMedias(numClases, centros, muestrasSOM);
					vuelcaFichero(salida, resultado, "Resultado de SOM");
					
				}

				
			}
		
		}
		
		salida.close();
			
		
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
/*		
		if (args.length == 2){
			CuantizacionVectorial clasificador = new CuantizacionVectorial(args[0],args[1]);
			int numClases = clasificador.getNumClases();
			Vector<Muestra> todasMuestras = addMuestras(clasificador.getVectorMuestras(),args[1]);
		//	KMedias kmedias = new KMedias(numClases,todasMuestras);
			//AlgoritmoLloyd aprende = new AlgoritmoLloyd(args[1],args[2]);
		}else{
			System.out.println("Argumentos mal");
		}
*/
	}
	
	

	private void leeFichero(String ficheroEntrada, Vector<Muestra> vectorMuestras){
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
				System.out.println(line);
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
			muestras = vectorMuestras.size();
		}catch(Exception ex) {System.out.println(ex.toString());}
	}
	
	
	private static void vuelcaFichero(PrintWriter salida,
			Vector<Muestra> vector,	String info){
	//String ficheroSalida){
		if (salida == null)
			salida = new PrintWriter(System.out);
		try{
			salida.println("Inicio de: "+info);
			for (int i=0;i<vector.size();i++){
				salida.println(vector.elementAt(i).toString());
			}
			salida.println("Fin de: "+info);
			salida.println();
		//	salida.close();
		}catch (Exception ex){
			System.out.println(ex.toString());
			}

	}
	
	
	private static Vector<Muestra> addMuestras(Vector<Muestra> muestras,String fileAprender){
		return muestras;
	}
		
		
	

}
