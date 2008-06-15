package principal;

import algoritmos.AlgoritmoLloyd;
import algoritmos.AlgoritmoSom;
import algoritmos.KMedias;
import algoritmos.CuantizacionVectorial;
import algoritmos.Muestra;

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
	public  float umbral;
	
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
		muestras = 3;
		atributos = 2;
		umbral = 20;
		
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
		longopts[2] = new LongOpt("entrenamiento", LongOpt.REQUIRED_ARGUMENT, sb, 't');
		longopts[3] = new LongOpt("entrada", LongOpt.REQUIRED_ARGUMENT, sb, 'i'); 
		
		longopts[4] = new LongOpt("lloyd", LongOpt.NO_ARGUMENT, null, 'l');
		longopts[5] = new LongOpt("kmedias", LongOpt.NO_ARGUMENT, null, 'k');
		longopts[6] = new LongOpt("som", LongOpt.NO_ARGUMENT, null, 's');
		
		// 
		Getopt g = new Getopt("testprog", args, "lksho:t:i:", longopts);
		g.setOpterr(false); // We'll do our own error handling
		//
		
		if (args.length == 0)
			ayuda();
		else
		while ((c = g.getopt()) != -1)
		  switch (c)
		    {
		    case 0:
		      //    arg = g.getOptarg();
		          char opt = (char)(new Integer(sb.toString())).intValue();
		          switch (opt){
		          case 'o':
					  princip.output = g.getOptarg();
					  break;
				  case 't':
					  princip.training = g.getOptarg();
					  break;
				  case 'i':
					  princip.input = g.getOptarg();
					  break;	
		          }
		          break;
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
				new CuantizacionVectorial(princip.umbral,princip.muestras, princip.atributos, 
						princip.vectorMuestrasEntrenamiento);
			int numClases = clasificador.getNumClases();
			
			Vector<Muestra> resultado = clasificador.getVectorMuestras();
			Vector<Muestra> centros = clasificador.getVectorCentros();
			
			vuelcaFichero(salida, centros, "Centros de CV");
			vuelcaFichero(salida, resultado, "Resultado de CV");
			
			if (princip.input.length() > 0){

				
				
				princip.leeFichero(princip.input, princip.vectorMuestrasEntrada);
				for (Iterator iter = princip.vectorMuestrasEntrada.iterator();
														iter.hasNext();) {
					Muestra m = (Muestra) iter.next();
					resultado.add(m);
				}
				if (princip.som){ //FIXME: Sustituir por el constructor de SOM 
					//cuando este hecho
					Vector<Muestra> muestrasSOM = new Vector<Muestra>();
					muestrasSOM = (Vector<Muestra>) resultado.clone();
					Vector<Muestra> centrosSOM = new Vector<Muestra>();
					centrosSOM = (Vector<Muestra>) centros.clone();
					AlgoritmoSom SOM = new AlgoritmoSom(numClases, centrosSOM, muestrasSOM);
					vuelcaFichero(salida, centrosSOM, "Centros de SOM");
					vuelcaFichero(salida, muestrasSOM, "Resultado de SOM");
			
				}	
				if (princip.lloyd){
					Vector<Muestra> muestrasLloyd = new Vector<Muestra>();
					muestrasLloyd = (Vector<Muestra>) resultado.clone();
					Vector<Muestra> centrosLloyd = new Vector<Muestra>();
					centrosLloyd = (Vector<Muestra>) centros.clone();
					AlgoritmoLloyd algLloyd = new AlgoritmoLloyd(numClases, centrosLloyd,
											muestrasLloyd);
					vuelcaFichero(salida, centrosLloyd, "Centros de Lloyd");
					vuelcaFichero(salida, muestrasLloyd, "Resultado de Lloyd");
				}
				if (princip.kmedias){
					Vector<Muestra> muestrasKmedias = new Vector<Muestra>();
					muestrasKmedias = (Vector<Muestra>) resultado.clone();
					Vector<Muestra> centrosKmedias = new Vector<Muestra>();
					centrosKmedias = (Vector<Muestra>) centros.clone();
					KMedias KMedias = new KMedias(numClases, centrosKmedias,
														muestrasKmedias);
					vuelcaFichero(salida, centrosKmedias, "Centros de Kmedias");
					vuelcaFichero(salida, muestrasKmedias, "Resultado de Kmedias");
				}
				

				
			}
		
		}
		if (salida != null)
			salida.close();
			
		
		for (int i = g.getOptind(); i < args.length ; i++)
			     System.out.println(args[i] + " no es una opcion \n");
	}
	
	

	private void leeFichero(String ficheroEntrada, Vector<Muestra> vectorMuestras){
		try{
			File f = new File(ficheroEntrada);
			FileReader entrada = new FileReader(f);
			BufferedReader buffer = new BufferedReader(entrada);
			String line;
			line = buffer.readLine();
			umbral = Float.valueOf(line).floatValue();
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
			muestras = vectorMuestras.size();
		}catch(Exception ex) {System.out.println(ex.toString());}
	}
	
	
	private static void vuelcaFichero(PrintWriter salida,
			Vector<Muestra> vector,	String info){
		try{
			if (salida == null)
				System.out.println("Inicio de: "+info);
			else
				salida.println("Inicio de: "+info);
			for (int i=0;i<vector.size();i++){
				if (salida == null)
					System.out.println(vector.elementAt(i).toString());
				else
				salida.println(vector.elementAt(i).toString());
			}
			if (salida == null)
				System.out.println("Fin de: "+info+"\n");
			else
				salida.println("Fin de: "+info+"\n");
		}catch (Exception ex){
			System.out.println(ex.toString());
			}

	}
	
	
	private static Vector<Muestra> addMuestras(Vector<Muestra> muestras,String fileAprender){
		return muestras;
	}
}
