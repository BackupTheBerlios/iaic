package modelo.problema.cubo;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import modelo.IAvisoLocal;
import modelo.problema.Estado;
import modelo.problema.Operador;


public class EstadoCubo  implements Estado, Serializable{
	private static final long serialVersionUID = 6006486732624592260L;
	private int numHabitacion;
	private ArrayList<Puerta> puertasAbiertas;
	private IAvisoLocal aviso;
	private ProblemaCubo cubo;
	private OperadorCubo opCubo;

	EstadoCubo(ProblemaCubo cubo){
		this.cubo = cubo;
		int longitud = cubo.get_longitud();
		aviso = cubo.getAvisos();
		numHabitacion = (int)(Math.random()*longitud-1) *100 + (int)(Math.random()*longitud-1) * 10 + (int)(Math.random()*longitud-1);
		puertasAbiertas = new ArrayList<Puerta>();
						
	}

	EstadoCubo(ProblemaCubo cubo, int numHabitacion, ArrayList<Puerta> puertas){
		aviso = cubo.getAvisos();
		this.cubo = cubo;
		this.numHabitacion = numHabitacion;
		this.puertasAbiertas = puertas;
	}

	public int getNumHabitacion(){
		return this.numHabitacion;
	}

	public void setNumHabitacion(int num){
		numHabitacion = num;
	}

	public ArrayList<Puerta> getPuertasAbiertas(){
		return this.puertasAbiertas;
	}

	public void setPuertasAbiertas(ArrayList<Puerta>  puertas){
		this.puertasAbiertas = puertas;
	}

	public ArrayList<Puerta> abrirPuerta(int puerta){
		ArrayList<Puerta> puertasAux = this.puertasAbiertas;
		ArrayList<Puerta> puertas = cubo.getPuertas();
		Puerta puertaAux = puertas.get(puertas.indexOf(new Puerta(puerta)));
		if  (puertaAux.isClausurada())
			puertaAux.setCodigoProblema(puertaAux.getCodigoProblema()%2);
		aviso.lanzarEjecucionLocal(puertaAux);
		
		if (puertaAux.isClausurada()){
			return new ArrayList<Puerta>();
		}
		puertasAux.add(puertaAux);
		return puertasAux;
		
		
	}
	
	public int getHeuristica() {
		int longitudCubo = cubo.get_longitud();
		int x = (numHabitacion % 10);
		int y = (numHabitacion/10) % 10;
		int z = (numHabitacion/100) % 10;
		int h = 0;
		h+= Math.min ((x % (longitudCubo-1)), ((longitudCubo-1-x) % (longitudCubo-1)));
		h+= Math.min ((y % (longitudCubo-1)),((longitudCubo-1-y) % (longitudCubo-1)));
		h+= Math.min ((z % (longitudCubo-1)), ((longitudCubo-1-z) % (longitudCubo-1))) ;
		return h;
	}
	


	public List<Operador> getOperadoresAplicables() {
		int longitudCubo = cubo.get_longitud();		
		List<Operador>	lista	=	new	LinkedList<Operador>();
		
			if ((numHabitacion/100)%10 != longitudCubo-1)
				lista.add(new OperadorArriba(this));			
			if ((numHabitacion/100)%10 != 0)
				lista.add(new OperadorAbajo(this));
			if ((numHabitacion/10)%10 != longitudCubo-1)
				lista.add(new OperadorIzquierda(this));			
			if ((numHabitacion/10)%10 != 0)
				lista.add(new OperadorDerecha(this));			
			if ((numHabitacion % 10 != longitudCubo-1))
				lista.add(new OperadorAdelante(this));	
			if ((numHabitacion % 10 != 0))
				lista.add(new OperadorAtras(this));				

		
		return lista;
	}
		
	public boolean equals(Object e){
		return ((EstadoCubo)e).getNumHabitacion() == numHabitacion;
	}

	public String toString(){
		return new String ("Num Habitacion "+ this.numHabitacion);
	}
	
	public String mostrarInfo() {
		return this.toString();
	}

	/**
	 * @return the cubo
	 */
	public ProblemaCubo getCubo() {
		return cubo;
	}

	/**
	 * @param cubo the cubo to set
	 */
	public void setCubo(ProblemaCubo cubo) {
		this.cubo = cubo;
	}


}
