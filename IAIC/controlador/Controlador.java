package controlador;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import modelo.Modelable;
import modelo.OyenteModelo;
import vista.OyenteVista;
import vista.Visualizable;

/**
 * @author  Diego
 */
public class Controlador implements OyenteVista, OyenteModelo {

	private	Modelable		modelo;
	private	Visualizable	vista;
	/**
	 * @return  the modelo
	 * @uml.property  name="modelo"
	 */
	public Modelable getModelo() {
		return modelo;
	}
	/**
	 * @param modelo  the modelo to set
	 * @uml.property  name="modelo"
	 */
	public void setModelo(Modelable modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return  the vista
	 * @uml.property  name="vista"
	 */
	public Visualizable getVista() {
		return vista;
	}
	/**
	 * @param vista  the vista to set
	 * @uml.property  name="vista"
	 */
	public void setVista(Visualizable vista) {
		this.vista = vista;
	}

	public void nuevoCubo(int habitaciones, int puertas) { //, int ventanas,int salidas
		modelo.nuevoCubo(habitaciones,puertas); //,ventanas,salidas
		vista.muestraCubo(modelo.mostrarCubo());
		vista.atiendeConCubo();
	}

	public void guardarBinario(ObjectOutputStream output) throws Exception {
		modelo.guardarBinario(output);
	}

	public void cargarBinario(ObjectInputStream input) throws Exception {
		modelo.cargarBinario(input);
		vista.muestraCubo(modelo.mostrarCubo());
		vista.atiendeConCubo();
	}

	public void guardarTexto(FileWriter fil) throws Exception {
		modelo.guardarTexto(fil);
	}

	public void cargarTexto(FileReader input) throws Exception {
		modelo.cargarTexto(input);
		vista.muestraCubo(modelo.mostrarCubo());
		vista.atiendeConCubo();
	}

	public void cerrarCubo() {
		modelo.cerrarCubo();
		vista.atiendeSinCubo();
	}

	public void iniciarEjecucionGlobal() {
		modelo.iniciarEjecucionGlobal();
		vista.muestraGlobal(modelo.mostrarGlobal());
		vista.atiendeEjecutandoGlobal();
	}

	public Object[] getListaAlgoritmos() {
		return modelo.getListaAlgoritmos();
	}

	public void ejecutaPasoLocal() {
		modelo.ejecutaPasoLocal();
		vista.muestraLocal(modelo.mostrarLocal());
	}

	public void ejecutaPasoGlobal() {
		modelo.ejecutaPasoGlobal();
		vista.muestraGlobal(modelo.mostrarGlobal());
	}

	public void cierraGlobal() {
		modelo.cierraGlobal();
		vista.atiendeConCubo();
	}

	public void cierraLocal() {
		modelo.cierraLocal();
		vista.atiendeEjecutandoGlobal();
	}

	public Object escogeAlgoritmo() {
		return vista.escogeAlgoritmo();
	}

	public void empiezaLocal() {
		vista.muestraLocal(modelo.mostrarLocal());
		vista.atiendeEjecutandoLocal();
	}

	public void terminaLocal() {
		vista.muestraLocal(modelo.mostrarLocal());
		vista.atiendeFinLocal();		
	}

	public void terminaGlobal() {
		vista.muestraGlobal(modelo.mostrarGlobal());
		vista.atiendeFinGlobal();		
	}
}
