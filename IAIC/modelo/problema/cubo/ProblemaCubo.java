package modelo.problema.cubo;
//import  EstadoCubo;
//import problema.Problema;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import modelo.IAvisoLocal;
import modelo.problema.Estado;
import modelo.problema.Problema;
/**
 * @author gnufede
 *
 */
public class ProblemaCubo implements Problema {

	/*
	 * (non-javadoc)
	 */
	private int _longitud;
	private ArrayList<Puerta> puertasCerradas;
	private ArrayList<Puerta> puertas;
	
	private IAvisoLocal avisos;
	
	
//	private boolean[][][][] puertasCerradas; 
//	private String strPuertasCerradas;
	/**
	 *
	 */
	private EstadoCubo _estado;

	public ProblemaCubo(){
		_longitud = 0;
		puertasCerradas = new ArrayList<Puerta>();
		puertas = new ArrayList<Puerta>();
		_estado = new EstadoCubo (this);
	}
	
	public ProblemaCubo (int longitud, int puertasCerradasPorHab){
		_longitud = longitud;
		puertasCerradas = new ArrayList<Puerta>();
		puertas = new ArrayList<Puerta>();
		cerrarPuertas(longitud,puertasCerradasPorHab);
		_estado = new EstadoCubo (this);
	}
	
	public ProblemaCubo(IAvisoLocal avisos, ProblemaCubo cubo){
		super();
		this.avisos = avisos;
		_longitud = cubo.get_longitud();
		puertasCerradas = cubo.getPuertasCerradas();
		puertas = cubo.getPuertas();
		_estado = cubo.get_estado();
	}

	public void inicializa (int longitud, int puertasCerradasPorHab, int numPro){
		_longitud = longitud;
		_estado = new EstadoCubo (this);
		int a = 0;
		for (int i = 0; i<longitud; i++)
			for (int j = 0; j<longitud; j++)
				for (int k = 0; k<longitud; k++)
					for (int l = 0; l<3; l++){
						a = (int)Math.random() * numPro;
						puertas.add(new Puerta(l*1000+i*100+j*10+k, a));
					}
		cerrarPuertas(longitud,puertasCerradasPorHab);
	}
	
	public void vacia(){
		puertas.clear();
		puertasCerradas.clear();
		_estado = null;
		_longitud = 0;
	}

	public EstadoCubo getEstado(){
		return this._estado;
	}

	public void setEstado(EstadoCubo newEstado){
		this._estado = newEstado;
	}
	
	private int contarPuertasCerradas(int habitacion){
		int numhc = 0;
		if (estaCerrada(habitacion)) numhc++;
		if (estaCerrada(1000+habitacion)) numhc++;
		if (estaCerrada(2000+habitacion)) numhc++;
		if (estaCerrada(habitacion - 100)) numhc++;
		if (estaCerrada(1000+habitacion-10)) numhc++;
		if (estaCerrada(2000+habitacion-1)) numhc++;
		return numhc;
	}
	
	private void cerrarPuertas(int longitud, int puertasCerradasPorHab){
	//	numHabCerrables = longitud*longitud*longitud*2;
	//	for (int i = 0; i<numHabCerrables; i++){}
		int numHab = 0;
		int aux = (int)Math.random()*3;
		for (int i = 0; i<longitud; i++)
			for (int j = 0; j<longitud; j++)
				for (int k = 0; k<longitud; k++){
					numHab = i*100+j*10+k;
					while (contarPuertasCerradas(numHab)<puertasCerradasPorHab){
						cerrarPuerta((aux%3)*1000+numHab);
				//		strPuertasCerradas = strPuertasCerradas +","+(aux*1000+numHab);
						aux++;
					}
					
				}
						
	}
	
	public void cerrarPuerta(int puerta){
		puertasCerradas.add(new Puerta(puerta));
		Puerta puertaAux = new Puerta(puerta);
		int aux = puertas.indexOf(puertaAux);
		puertaAux = puertas.get(aux);
		puertaAux.setClausurada(true);
	}

	public boolean estaCerrada(int puerta){
		return puertasCerradas.contains(new Puerta(puerta));
	}

	public boolean isExit (){
		return isExit(this._estado);
	}

	private boolean isExit (EstadoCubo estado) {
		int num = estado.getNumHabitacion();
		if ((num % (_longitud-1) != 0) 
			|| ((num/10) % (_longitud-1) != 0)
			||((num/100) % (_longitud-1) != 0))
				return false;
		return true;
	}

	
	public String toString (){
		String cadena = "";
		cadena = cadena + "Tamaño: " + _longitud + "\n";
		cadena = cadena + "Salidas: \n"+ "000,00"+(_longitud-1)+",0"+(_longitud-1)+"0,"+"0"+(_longitud-1)+""+(_longitud-1)+","+
		(_longitud-1)+"00,"+(_longitud-1)+"0"+(_longitud-1)+","+(_longitud-1)+""+(_longitud-1)+"0,"+
		(_longitud-1)+""+(_longitud-1)+""+(_longitud-1);
		puertasCerradas.trimToSize();
		cadena = cadena+ "\n" + "Puertas clausuradas: \n";
		String aux = "";
		for (Iterator<Puerta> iterator = puertasCerradas.iterator(); iterator.hasNext();) {
			if (aux.length() > 0) aux = aux + ",";
			Puerta puertaAux = (Puerta) iterator.next();
			aux = aux + puertaAux.getNumeroPuerta();
		}
		cadena = cadena + aux + "\n";
		cadena = cadena+ "Estado Inicial: " + _estado.getNumHabitacion() + "\n";	
		return cadena;
	}

	public boolean esObjetivo(Estado e) {
		return isExit((EstadoCubo)e);
	}

	public int evaluarHeuristica(Estado e) {
		return ((EstadoCubo)e).getHeuristica();
	}

	public Estado getInicial() {
		return new EstadoCubo(this);
	}

	/**
	 * @return the _estado
	 */
	public EstadoCubo get_estado() {
		return _estado;
	}
	/**
	 * @return the _longitud
	 */
	public int get_longitud() {
		return _longitud;
	}
	/**
	 * @param _longitud the _longitud to set
	 */
	public void set_longitud(int _longitud) {
		this._longitud = _longitud;
	}

	
	/**
	 * @return the puertas
	 */
	public ArrayList<Puerta> getPuertas() {
		return puertas;
	}

	/**
	 * @param puertas the puertas to set
	 */
	public void setPuertas(ArrayList<Puerta> puertas) {
		this.puertas = puertas;
	}
	/**
	 * @return the puertasCerradas
	 */
	public ArrayList<Puerta> getPuertasCerradas() {
		return puertasCerradas;
	}

	/**
	 * @param puertasCerradas the puertasCerradas to set
	 */
	public void setPuertasCerradas(ArrayList<Puerta> puertasCerradas) {
		this.puertasCerradas = puertasCerradas;
	}

	public IAvisoLocal getAvisos() {
		return this.avisos;
	}

	/**
	 * @param avisos the avisos to set
	 */
	public void setAvisos(IAvisoLocal avisos) {
		this.avisos = avisos;
	}

}
