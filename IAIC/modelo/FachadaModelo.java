package modelo;

/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import modelo.busqueda.IAlgoritmo;
import modelo.busqueda.IAlgoritmoServidor;
import modelo.busqueda.ServidorAlgoritmo;
import modelo.problema.IServidorProblemas;
import modelo.problema.Problema;
import modelo.problema.ServidorProblemas;
import modelo.problema.cubo.EstadoCubo;
import modelo.problema.cubo.ProblemaCubo;
import modelo.problema.cubo.Puerta;


public class FachadaModelo implements Modelable, IAvisoLocal {

	private	OyenteModelo	oyente;
	private	ProblemaCubo	cubo;
	private EstadoCubo		estadoCubo;
	private LinkedList<Puerta> problemas;
	protected boolean 		problemaIniciado;
	
//	private LinkedList<Puerta>	colaProblemas;
//	private LinkedList<EstadoCubo>	colaEstados;
//	private LinkedList<OperadorCubo> colaOperadores;
	

	public void nuevoCubo(int dim, int puertas) { //, int ventanas, int salidas
		cubo.inicializa(dim,puertas, probserver.dameNumeroProblemas());
	}

	public void guardarTexto(FileWriter fil) throws Exception {
		fil.write(cubo.escribe());
	}

	public void guardarBinario(ObjectOutputStream output) throws Exception{
		output.writeObject(cubo);		
	}
	
	public void cargarBinario(ObjectInputStream input) throws Exception {
		cubo	=	(ProblemaCubo) input.readObject();
	}

	public void cargarTexto(FileReader input) throws Exception {
		StringBuffer	s = new	StringBuffer();
		while (input.ready()){
			char[]	buf	=	new	char[1];
			input.read(buf,0,1);
			s.append(buf);
		}
		cubo.lee(s.toString());
	}

	public void cerrarCubo() {
		cubo.vacia();
	}
	
	public	FachadaModelo(){
		cubo	=	new	ProblemaCubo();
		probserver	=	new	ServidorProblemas();
		algserver	=	new	ServidorAlgoritmo();
		problemas  = new LinkedList<Puerta>();
		problemaIniciado = false;
//		puerta 	= null;
//		localTerminado = true;
//		colaProblemas = new LinkedList<Puerta>();
//		colaEstados = new LinkedList<EstadoCubo>();
//		colaOperadores = new LinkedList<OperadorCubo>();
	}

	private	IServidorProblemas probserver;
	private	IAlgoritmoServidor algserver;
	private	IAlgoritmo		global;
	private	IAlgoritmo		local;
	private	Problema		problemaGlobal;

	public void cierraGlobal() {
		global	=	null;
		local	=	null;
	}

	public void cierraLocal() {
		local	=	null;
		//problemaIniciado = false;
	}

	public void ejecutaPasoGlobal() {
		global.avanzarPaso();
		if (global.estaResuelto()){
			oyente.terminaGlobal();
		}
	}

	public void ejecutaPasoLocal() {
		if (!problemaIniciado)
			iniciarEjecucionLocalActual();
		local.avanzarPaso();
		if (local.estaResuelto()){
			oyente.terminaLocal();
			//problemas.peek();
			problemaIniciado = false;
			
		//	iniciarEjecucionLocalActual(); //TODO: Borrar si no funciona
			
		}
	}

	public Object[] getListaAlgoritmos() {
		return algserver.dameListaAlgoritmos();
	}

	public void iniciarEjecucionGlobal() {
		global	=	algserver.dameAlgoritmo(oyente.escogeAlgoritmo());
		problemaGlobal	=	new	ProblemaCubo(this,cubo);
		global.setProblema(problemaGlobal);
		global.inicializar();
	}
	
	public	void	iniciarEjecucionLocal(int codigoProblema,boolean resoluble){
		local	=	algserver.dameAlgoritmo(oyente.escogeAlgoritmo());
		Problema	problemaLocal	=	probserver.dameProblema(codigoProblema % (probserver.dameNumeroProblemas()),resoluble);
		local.setProblema(problemaLocal);
		local.inicializar();
		oyente.empiezaLocal();
	
	}	
	
	/**
	 * @return  the oyente
	 * @uml.property  name="oyente"
	 */
	public OyenteModelo getOyente() {
		return oyente;
	}
	
	/**
	 * @param oyente  the oyente to set
	 * @uml.property  name="oyente"
	 */
	public void setOyente(OyenteModelo oyente) {
		this.oyente = oyente;
	}

	public String mostrarCubo() {
		return cubo.toString();
	}

	public String mostrarGlobal() {
		return global.muestra();
	}

	public String mostrarLocal() {
		return local.muestra();
	}

	public boolean getFinEjecucionLocal() {
		return !(local.isFallido());
	}

//	public void lanzarEjecucionLocal(int codigoProblema, boolean resoluble) {
		
//	}

	public void lanzarEjecucionLocal(Puerta puerta) {
		problemas.offer(puerta);
		if (!problemaIniciado)
			iniciarEjecucionLocalActual();
			
		
	}

	public void iniciarEjecucionLocalActual() {
		if (!problemaIniciado && !problemas.isEmpty()){
			Puerta puerta = problemas.poll();
			problemaIniciado = true;
			iniciarEjecucionLocal(puerta.getCodigoProblema(), !puerta.isClausurada());
		}
		
	}

	public void ejecutarLocal(Puerta puerta) {
		if (problemas.isEmpty()){
			iniciarEjecucionLocal(puerta.getCodigoProblema(),!(puerta.isClausurada()));
		}
		problemas.offer(puerta);
//		colaEstados.add(estado);
//		colaOperadores.add(op);
	}
	
	public boolean hayProblemasLocales(){
		return !(problemas.isEmpty());
	}

}
