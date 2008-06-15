/**
 * 
 */
package algoritmos;

import java.util.Vector;

/**
 * @author paloma
 *
 */
public class AlgoritmoSom {

	private int muestras;
	final int maxIter = 100;
	private int clases;
	private float aprendizaje; //alfa
	private double gamma;
	private Vector <Boolean> conver = new Vector<Boolean>();
	private Vector <Float> K = new Vector<Float>();
	
	final float ainicial = (float)1.0;
	final float afinal = (float)0.8;
	final double T = 0.2;
	final float Error = (float)0.0001;
	
	private Vector<Muestra> vectorCentros = new Vector<Muestra>();
	private Vector<Muestra> vectorMuestras = new Vector<Muestra>();
	private Vector<Muestra> vCentrosMasUno = new Vector<Muestra>();
	
	
	public AlgoritmoSom (){
//		 TODO Auto-generated constructor stub
		super();
	}
	
	/**
	 * 
	 */
	public AlgoritmoSom(int c, Vector<Muestra> centros, Vector<Muestra> m) {
		clases = c;
		vectorMuestras = m;
		vectorCentros = centros;
		vCentrosMasUno = centros;
		muestras = vectorMuestras.size();
		int i = 1;
		int eleva;
		for (int j=0; j<muestras;j++){
			conver.add(j, Boolean.FALSE);
		}
		for (int j=0; j<clases;j++){
			K.add(j, new Float(Float.MIN_VALUE));
		}
		while((i < maxIter) && !convergencia()){
			eleva = i / maxIter;
			aprendizaje = ainicial * (float) Math.pow((ainicial/afinal), eleva);
			gamma = 1 / (10 + i);
			itera();
			compara();
			vectorCentros = vCentrosMasUno;
		}
		//clasifica();
	}

	private void itera() {
		// TODO Auto-generated method stub
		float distancia;
		float potencia;
		float Kaux;
		
		for (int j=0; j<muestras;j++){ //bucle que recorre muestras
			for (int k=0; k< clases;k++){
				float [] m =vectorMuestras.elementAt(j).getContent();
				float [] c = vectorCentros.elementAt(k).getContent();
				distancia = distance(m,c);
				potencia = -(distancia/(2 * (aprendizaje*aprendizaje)));
				Kaux = (float)Math.pow(Math.E, potencia);
				K.set(k, Kaux);
				if (Kaux > T){
					float [] resta = restaVect(m,c);
					resta = muestraPorEscalar(resta,Kaux*gamma);
					float [] suma = sumaVect(c,resta);
					//Ahora tengo que almacenar el resultado en algo para poder comparar con el anterior
					Muestra centro = new Muestra(suma);
					vectorMuestras.elementAt(j).setClase(k);
					vCentrosMasUno.set(k, centro);
				}
			}
		}
	}
	
	private void compara(){
		for (int i=0; i<clases;i++){
			Muestra cj = vectorCentros.elementAt(i);
			Muestra cj1 = vCentrosMasUno.elementAt(i);
			float resta = distance(cj.getContent(),cj1.getContent());
			if (resta < Error){
				conver.set(i, Boolean.TRUE);
			}
		}
	}
	
//	private void clasifica(){
//		//boolean encontrado=false;
//		Vector <Float> d = new Vector<Float>();
//		for (int i=0; i<muestras;i++){
//			Muestra mi= vectorMuestras.elementAt(i);
//			for (int j=0;j<vectorCentros.size();j++){
//				Muestra ci = vectorCentros.elementAt(j);
//				float distancia = distance(mi.getContent(),ci.getContent());
//				d.add(j, distancia);
//			}
//			int k = menorDist(d);
//			vectorMuestras.elementAt(i).setClase(k);
//		}
//	}

	private boolean convergencia(){
		for (int i=0; i< conver.size();i++){
			if (conver.get(i).booleanValue()) return true;
		}
		return false;
	}

	private int menorDist(Vector<Float> d){
		int j = 0;
		Float daux = d.get(0);
		for (int i= 1; i<d.size();i++){
			if ((d.get(i)< daux) && d.get(i)>T){
				j=i;
				daux = d.get(i);
			}
		}
		return j;
	}
	
    private float distance(float[] dp1, float[] dp2) {
		
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
    
    private float[] sumaVect (float[] muestra, float[] acum){
		float[] result = new float[muestra.length];
		for (int i = 0; i < muestra.length; i++)
			result[i] = muestra[i] + acum[i];
		return result;
	}
    
    private float[] restaVect (float[] muestra, float[] acum){
		float[] result = new float[muestra.length];
		for (int i = 0; i < muestra.length; i++)
			result[i] = muestra[i] + acum[i];
		return result;
	}
    
    public float[] muestraPorEscalar (float[] muestra, double esc){
		float [] resultado = new float[muestra.length];
		for (int i = 0; i < muestra.length; i++){
			resultado[i] = (float)(muestra[i]*esc);
		}
		return resultado;
	}
}
