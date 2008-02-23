
package modelo.laberinto;
import java.io.IOException;
import java.io.Serializable;
import java.lang.Math;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * @author  Diego
 */
public class Laberinto implements Serializable {
	
	private static final long serialVersionUID = -4662722009639217175L;

	private	List<Habitacion>	habitaciones;
	private	Habitacion			entrada;
	private	List<Habitacion>	salidas;
	private	List<Puerta>		puertas;
	
	public	Laberinto(){
		habitaciones	=	new	LinkedList<Habitacion>();
		salidas			=	new	LinkedList<Habitacion>();
		puertas			=	new	LinkedList<Puerta>();
	}
	
	/** Inicializa el laberinto, tomando como parámetros
	 * cuántas habitaciones, puertas y ventanas tiene 
	 * @param numHab  numero de habitaciones del laberinto
	 * @param numPue  numero de puertas
	 * @param numVen  numero de ventanas en el laberinto
	 * @param numSal  numero máximo de salidas del laberinto
	 * @param numPro  numero de problemas máximo
	 * */
	public	void	inicializa(int numHab,int numPue,int numVen, int numSal, int numPro){
		construyeHabitaciones(numHab);
		construyePuertas(numPue);
		construyeVentanas(numVen);
		escogeEntrada();
		escogeSalidas(numSal);
		otorgaProblemas(numPro);
		calculaLuminosidad();
	}
	
	public	void	vacia(){
		habitaciones.clear();
		entrada		=	null;
		puertas.clear();
		salidas.clear();
	}

	private void construyeHabitaciones(int numHab) {
		for (int i = 0; i< numHab;i++){
			habitaciones.add(new Habitacion(i));
		}
	}

	private void construyePuertas(int numPue) {
		for (int i = 0; i<numPue;i++){
			Random ran	=	new	Random();
			int a = Math.abs(ran.nextInt()) % habitaciones.size();
			int b = Math.abs(ran.nextInt()) % habitaciones.size();
			Habitacion rosa	=	habitaciones.get(a);
			Habitacion verde =	habitaciones.get(b);
			puertas.add(new Puerta(verde,rosa));
		}
	}

	private void construyeVentanas(int numVen) {
		for (int i = 0; i<numVen;i++){
			Random ran	=	new	Random();
			int a = Math.abs(ran.nextInt()) % habitaciones.size();
			Habitacion h = habitaciones.get(a);
			h.setVentanas(h.getVentanas() + 1 );
		}
	}


	private void escogeEntrada() {
		Random ran	=	new	Random();
		int a = Math.abs(ran.nextInt()) % habitaciones.size();
		entrada	=	habitaciones.get(a);
	}


	private void escogeSalidas(int numSal) {
		for (int i = 0; i<numSal;i++){
			Random ran	=	new	Random();
			int a = Math.abs(ran.nextInt()) % habitaciones.size();
			Habitacion h = habitaciones.get(a);
			if (!salidas.contains(h)){
				salidas.add(h);
			}
		}
	}


	private void otorgaProblemas(int numPro) {
		for (int i = 0; i<numPro;i++){
//			Random ran	=	new	Random();
//			int a = Math.abs(ran.nextInt()) % numPro;
			int a = 0;
			Habitacion h = habitaciones.get(i);
			h.setCodigoProblema(a);
		}
	}


	private void calculaLuminosidad() {
		Queue<Habitacion> cola = new	LinkedList<Habitacion>();
		Iterator<Habitacion> itera	=	salidas.iterator();
		while (itera.hasNext()){
			Habitacion h	=	itera.next();
			h.setLuminosidad(0);
			if (! cola.contains(h)){
				cola.add(h);
			}
		}
		itera	=	habitaciones.iterator();
		while (itera.hasNext()){
			Habitacion h	=	itera.next();
			if (h.getVentanas() > 0){
				h.setLuminosidad(0);
			}
			if (! cola.contains(h)){
				cola.add(h);
			}
		}
		
		while (! cola.isEmpty()){
			Habitacion	h	=	cola.poll();
			List<Puerta> aux	=	h.getPuertas();
			// Para cada puerta de la habitación
			for (int i = 0;i<aux.size();i++){
				Habitacion h2 = aux.get(i).cruzar(h);
				if (h2.getLuminosidad() == Integer.MAX_VALUE){
					h2.setLuminosidad(h.getLuminosidad()+1);
					cola.add(h2);
				}
			}
		}
	}

	
	/** Reconstruye el laberinto tomando los datos
	 * escritos en un texto.*/
	public	void	lee(String texto) throws Exception{
		String texto2 = new String(texto.toLowerCase());
		StringTokenizer strTok = new StringTokenizer(texto2);
		leerLab(strTok);
		texto2 = texto2.substring("laberinto".length());
		while (texto2.startsWith(" ")||texto2.startsWith("\n")){
			texto2 = texto2.substring(1);
		}
		// HABITACIONES ***************************************************************
		if (!texto2.startsWith("habitaciones")){
			throw new IOException("El primer campo debe decir la palabra \"Habitaciones\"");
		}
		texto2 = texto2.substring("habitaciones".length());
		while (texto2.startsWith(" ")){
			texto2 = texto2.substring(1);
		}
		int numHab;// = leerHab(strTok);
		try {
			numHab = miparseint(texto2);			
			texto2 = texto2.substring(("" + numHab).length());			
		} catch (NumberFormatException e) {
			throw new IOException("El primer campo debe decir el número de habitaciones.");
		}
		while (texto2.startsWith(" ")||texto2.startsWith("\n")){
			texto2 = texto2.substring(1);
		}		
		LinkedList<Habitacion> habs = new LinkedList<Habitacion>();
		for (int i=0; i<numHab;i++){
			habs.add(new Habitacion(i));
		}
		//LinkedList<Puerta> puertasAux = leerPuer(strTok,numHab,habs);
		// Puertas ***************************************************************
		LinkedList<Puerta> puertasAux = new LinkedList<Puerta>();
		int hab1,hab2;
		boolean seguir = true;
		if (!texto2.startsWith("puertas")){
			throw new IOException("El segundo campo debe decir la palabra \"Puertas\"");
		}
		texto2 = texto2.substring("puertas".length());
		while ((texto2.length()>0) && seguir){
			while (texto2.startsWith(" ")){
				texto2 = texto2.substring(1);
			}
			if (!texto2.startsWith("(")){
				seguir = false;
			} else {
				texto2 = texto2.substring(1);
				while (texto2.startsWith(" ")){
					texto2 = texto2.substring(1);
				}
				try{
					hab1 = miparseint(texto2);					
				}catch (NumberFormatException e){
					throw new IOException("Puertas: El primer campo de cada par debe indicar un número de habitación.");
				}
				texto2 = texto2.substring(("" + hab1).length());
				if (!texto2.startsWith(",")){
					throw new IOException("Puertas: falta una coma.");
				}
				texto2 = texto2.substring(1);  // quitamos la ","
				while (texto2.startsWith(" ")){
					texto2 = texto2.substring(1);
				}
				try{
					hab2 = miparseint(texto2);
					texto2 = texto2.substring(("" + hab2).length());
				}catch (NumberFormatException e){
					throw new IOException("Puertas: El segundo campo de cada par debe indicar un número de habitación.");
				}
				while (texto2.startsWith(" ")){
					texto2 = texto2.substring(1);
				}
				if (!texto2.startsWith(")")){
					throw new IOException("Puertas: falta un parentesis de cierre.");
				}
				texto2 = texto2.substring(1);
				while (texto2.startsWith(" ")){
					texto2 = texto2.substring(1);
				}
				if (!texto2.startsWith(";") && !texto2.startsWith("\n")){
					throw new IOException("Puertas: las puertas van separadas con punto y coma.");
				}
				if (texto2.startsWith(";")){
					texto2 = texto2.substring(1);
				}
				if ((hab1>=numHab)||(hab2>=numHab)||(hab1<0)||(hab2<0)){
					throw new IOException("Puertas: Un número de habitación tiene que ser menor que el numero total de habitaciones y positivo.");
				}
				puertasAux.add(new Puerta(habs.get(hab1),habs.get(hab2)));
			}
		}
		//leerVent(strTok,numHab,habs);
		//Ventana *******************************************************************************
		int hab;
		seguir = true;
		Habitacion habAux;
		while (texto2.startsWith(" ")||texto2.startsWith("\n")){
			texto2 = texto2.substring(1);
		}
		if (!texto2.startsWith("ventanas")){
			throw new IOException("El tercer campo debe decir la palabra \"ventanas\"");
		}
		texto2 = texto2.substring("ventanas".length());
		while ((texto2.length()>0) && seguir){
			while (texto2.startsWith(" ")){
				texto2 = texto2.substring(1);
			}
			if (texto2.startsWith("\n")){
				seguir = false;
			} else {
				try{
					hab = miparseint(texto2);				
					texto2 = texto2.substring(("" + hab).length());					
				}catch (NumberFormatException e){
					throw new IOException("Ventanas: cada elemento de la lista debe ser un número de habitación.");
				}
				while (texto2.startsWith(" ")){
					texto2 = texto2.substring(1);
				}
				if (!texto2.startsWith(",") && !texto2.startsWith("\n")){
					throw new IOException("Ventanas: falta una coma.");
				}
				if (texto2.startsWith(",")){
					texto2 = texto2.substring(1);  // quitamos la ","
				}
				if ((hab>=numHab)||(hab<0)){
					throw new IOException("Puertas: Un número de habitación tiene que ser menor que el numero total de habitaciones y positivo.");
				}
				habAux = habs.get(hab);
				habAux.setVentanas(habAux.getVentanas()+ 1);
				habs.set(hab,habAux);				
			}
		}
		
		// ENTRADA ****************************************************************
		int numEntrada;
		while (texto2.startsWith(" ")||texto2.startsWith("\n")){
			texto2 = texto2.substring(1);
		}
		if (!texto2.startsWith("entrada")){
			throw new IOException("El cuarto campo debe decir la palabra \"Entrada\"");
		}
		texto2 = texto2.substring("entrada".length());
		while (texto2.startsWith(" ")){
			texto2 = texto2.substring(1);
		}
		try {
			numEntrada = miparseint(texto2);
			texto2 = texto2.substring(("" + numEntrada).length());
		} catch (NumberFormatException e) {
			throw new IOException("Entrada: El primer campo debe decir el número" +
					" de la habitación de entrada al laberinto.");
		}
		Habitacion entradaux = habs.get(numEntrada);
		while (texto2.startsWith(" ")||texto2.startsWith("\n")){
			texto2 = texto2.substring(1);
		}			
		
		// SALIDAS ************************************************************
		// LinkedList<Habitacion> salidasAux = leerSal(strTok,numHab,habs);
		LinkedList<Habitacion> salidasAux = new LinkedList<Habitacion>();
		if (!texto2.startsWith("salidas")){
			throw new IOException("El quinto campo debe decir la palabra \"salidas\"");
		}		
		texto2 = texto2.substring("salidas".length());
		seguir = true;
		while ((texto2.length()>0) && seguir){
			while (texto2.startsWith(" ")){
				texto2 = texto2.substring(1);
			}
			if (texto2.startsWith("\n")){
				seguir = false;
			} else {
				try{
					hab = miparseint(texto2);
					texto2 = texto2.substring(("" + hab).length());
				}catch (NumberFormatException e){
					throw new IOException("Salidas: cada elemento de la lista debe ser un número de habitación.");
				}
				while (texto2.startsWith(" ")){
					texto2 = texto2.substring(1);
				}
				if (!texto2.startsWith(",") && !texto2.startsWith("\n")){
					throw new IOException("Salidas: falta una coma.");
				}
				if (texto2.startsWith(",")){
					texto2 = texto2.substring(1);  // quitamos la ","
				}	
				if ((hab>=numHab)||(hab<0)){
					throw new IOException("Salidas: Un número de habitación tiene que ser menor que el numero total de habitaciones y positivo.");
				}
				salidasAux.add(habs.get(hab));				
			}
		}
		
		
		// PROBLEMAS *************************************************************************
		//leerProb(strTok,numHab,habs,NUMEROPROBLEMAS);
		seguir = true;
		int prob;
		int NUMEROPROB = 6;
		while (texto2.startsWith(" ")||texto2.startsWith("\n")){
			texto2 = texto2.substring(1);
		}
		if (!texto2.startsWith("problemas")){
			throw new IOException("El sexto campo debe decir la palabra \"Problemas\"");
		}
		texto2 = texto2.substring("problemas".length());
		while ((texto2.length()>0) && seguir){
			while (texto2.startsWith(" ")||texto2.startsWith("\n")){
				texto2 = texto2.substring(1);
			}
			if (!texto2.startsWith("(")){
				seguir = false;
			} else {
				texto2 = texto2.substring(1);
				while (texto2.startsWith(" ")){
					texto2 = texto2.substring(1);
				}
				try{
					hab = miparseint(texto2);
					texto2 = texto2.substring(("" + hab).length());
				}catch (NumberFormatException e){
					throw new IOException("Problemas: El primer campo de cada par debe indicar un número de habitación.");
				}
				while (texto2.startsWith(" ")){
					texto2 = texto2.substring(1);
				}
				if (!texto2.startsWith(",")){
					throw new IOException("Problemas: falta una coma.");
				}
				texto2 = texto2.substring(1);  // quitamos la ","
				while (texto2.startsWith(" ")){
					texto2 = texto2.substring(1);
				}
				try{
					prob = miparseint(texto2);
					texto2 = texto2.substring(("" + prob).length());
				}catch (NumberFormatException e){
					throw new IOException("Problemas: El segundo campo de cada par debe indicar un número de problema.");
				}
				while (texto2.startsWith(" ")){
					texto2 = texto2.substring(1);
				}
				if (!texto2.startsWith(")")){
					throw new IOException("Problemas: falta un parentesis de cierre.");
				}
				texto2 = texto2.substring(1);
				if ((hab>=numHab)||(prob>=NUMEROPROB)||(hab<0)||(prob<0)){
					throw new IOException("Problemas: Un número de habitación tiene que ser menor que el numero total de habitaciones y positivo, y" +
							" un número de problema tiene que ser menor que el número total de problemas y positivo.");
				}
				habAux = habs.get(hab);
				habAux.setCodigoProblema(prob);
				habs.set(hab,habAux);
				while (texto2.startsWith(" ")){
					texto2 = texto2.substring(1);
				}
				if (!texto2.startsWith("(")&&!texto2.startsWith("\n")){
					throw new IOException("Problemas: los problemas van separados con espacios o con retornos de carro. :: " + texto2);
				}								
			}
		}
		strTok = new StringTokenizer(texto2);		
		leerFin(strTok);		
		//Ahora que el laberinto ha sido correctamente parseado, se puede cambiar el objeto actual
		this.habitaciones = habs;
		this.puertas = puertasAux;
		this.entrada = entradaux;
		this.salidas = salidasAux;
	}
	
	
	private int miparseint(String texto2) throws NumberFormatException{
		int n = 0;		
		while (Character.isDigit(texto2.charAt(0))){
			n = n*10 + Character.digit(texto2.charAt(0),10);
			texto2 = texto2.substring(1);
		}
		return n;
	}

	private void leerLab(StringTokenizer strTok) throws IOException {
		if (!((strTok.nextToken(" \n")).equalsIgnoreCase("Laberinto"))){
				throw new IOException("El fichero de texto debe comenzar con \"Laberinto\\n\".");
		};		
	}	

	private void leerFin(StringTokenizer strTok) throws IOException {
		if (!((strTok.nextToken(" \n")).equalsIgnoreCase("FinLaberinto"))){
				throw new IOException("El fichero de texto debe terminar con \"FinLaberinto\".");
		};		
	}
	
	/** Muestra toda la información del laberinto.*/
	public	String	muestra(){
		return escribe();		
	}
	
	
	public	String	escribe(){
		StringBuffer salida = new StringBuffer();
		salida.append("Laberinto\nhabitaciones ");
		salida.append(this.habitaciones.size() + "\n");
		salida.append("puertas ");
		for (Iterator iter = puertas.iterator(); iter.hasNext();) {
			Puerta p = (Puerta) iter.next();
			salida.append("(" + 
					p.getVerde().getNumero() + "," + 
					p.getRosa().getNumero() + ")");
			if (iter.hasNext()){
				salida.append(";");
			}
		}
		salida.append("\nventanas ");
		LinkedList<Habitacion> listauxVent = new LinkedList<Habitacion>();
		for (Iterator iter = habitaciones.iterator(); iter.hasNext();) {		
			Habitacion h = (Habitacion) iter.next();			
			if (h.getVentanas() > 0){
				listauxVent.add(h);				
			}			
		}
		for (Iterator iter = listauxVent.iterator(); iter.hasNext();) {
			Habitacion h = (Habitacion) iter.next();
			salida.append(h.getNumero());
			if (iter.hasNext()){
				salida.append(",");
			}
		}		
		salida.append("\nentrada " + entrada.getNumero() + "\n");
		salida.append("salidas ");
		for (Iterator iter = salidas.iterator(); iter.hasNext();) {
			Habitacion h = (Habitacion) iter.next();			
			salida.append(h.getNumero());
			if (iter.hasNext()){
				salida.append(",");
			} else 
				salida.append("\n");
		}
		salida.append("problemas\n");
		for (Iterator iter = habitaciones.iterator(); iter.hasNext();) {
			Habitacion h = (Habitacion) iter.next();
			salida.append("(" + 
					h.getNumero() + "," + 
					h.getCodigoProblema() + ")\n");
		}
		salida.append("finLaberinto");
		return salida.toString();		
	}

	/**
	 * @return  the entrada
	 * @uml.property  name="entrada"
	 */
	public Habitacion getEntrada() {
		return entrada;
	}

	public boolean isSalida(Habitacion mihabitacion) {
		return salidas.contains(mihabitacion);
	}

}
