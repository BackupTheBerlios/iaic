package modelo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modelo.busqueda.IAlgoritmo;
import modelo.busqueda.IAlgoritmoServidor;
import modelo.busqueda.ServidorAlgoritmo;
//import modelo.laberinto.Laberinto;
//import modelo.laberinto.LaberintoProblema;
import modelo.problema.IServidorProblemas;
import modelo.problema.Problema;
import modelo.problema.ServidorProblemas;
import modelo.problema.cubo.ProblemaCubo;


public class FachadaModelo implements Modelable, IAvisoLocal {

	private	OyenteModelo	oyente;
	private	ProblemaCubo	cubo;

	public void nuevoCubo(int dim, int puertas) { //, int ventanas, int salidas
		cubo.inicializa(dim,puertas, probserver.dameNumeroProblemas());
	}

	public void guardarTexto(FileWriter fil) throws Exception {
		//FIXME: fil.write(cubo.escribe());
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
		//FIXME: cubo.lee(s.toString());
	}

	public void cerrarCubo() {
		cubo.vacia();
	}
	
	public	FachadaModelo(){
		cubo	=	new	ProblemaCubo();
		probserver	=	new	ServidorProblemas();
		algserver	=	new	ServidorAlgoritmo();
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
	}

	public void ejecutaPasoGlobal() {
		global.avanzarPaso();
		if (global.estaResuelto()){
			oyente.terminaGlobal();
		}
	}

	public void ejecutaPasoLocal() {
		local.avanzarPaso();
		if (local.estaResuelto()){
			oyente.terminaLocal();
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

}
