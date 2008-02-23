package modelo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modelo.busqueda.IAlgoritmo;
import modelo.busqueda.IAlgoritmoServidor;
import modelo.busqueda.ServidorAlgoritmo;
import modelo.laberinto.Laberinto;
import modelo.laberinto.LaberintoProblema;
import modelo.problema.IServidorProblemas;
import modelo.problema.Problema;
import modelo.problema.ServidorProblemas;

/**
 * @author  Diego
 */
public class FachadaModelo implements Modelable, IAvisoLocal {

	private	OyenteModelo	oyente;
	private	Laberinto	laberinto;

	public void nuevoLaberinto(int dim, int puertas) { //, int ventanas, int salidas
		laberinto.inicializa(dim,puertas, probserver.dameNumeroProblemas());//,ventanas, salidas
	}

	public void guardarTexto(FileWriter fil) throws Exception {
		fil.write(laberinto.escribe());
	}

	public void guardarBinario(ObjectOutputStream output) throws Exception{
		output.writeObject(laberinto);		
	}
	
	public void cargarBinario(ObjectInputStream input) throws Exception {
		laberinto	=	(Laberinto) input.readObject();
	}

	public void cargarTexto(FileReader input) throws Exception {
		StringBuffer	s = new	StringBuffer();
		while (input.ready()){
			char[]	buf	=	new	char[1];
			input.read(buf,0,1);
			s.append(buf);
		}
		laberinto.lee(s.toString());
	}

	public void cerrarLaberinto() {
		laberinto.vacia();
	}
	
	public	FachadaModelo(){
		laberinto	=	new	Laberinto();
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
		
		problemaGlobal	=	new	LaberintoProblema(this,laberinto);
		global.setProblema(problemaGlobal);
		global.inicializar();
	}
	
	public	void	iniciarEjecucionLocal(int codigoProblema){
		local	=	algserver.dameAlgoritmo(oyente.escogeAlgoritmo());
		Problema	problemaLocal	=	probserver.dameProblema(codigoProblema % (probserver.dameNumeroProblemas()));
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

	public String mostrarLaberinto() {
		return laberinto.muestra();
	}

	public String mostrarGlobal() {
		return global.muestra();
	}

	public String mostrarLocal() {
		return local.muestra();
	}

}
