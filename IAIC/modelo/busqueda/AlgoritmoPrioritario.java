package modelo.busqueda;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
//import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import modelo.problema.Estado;
import modelo.problema.Operador;


abstract class AlgoritmoPrioritario extends AlgoritmoAbstracto {

	private 	NodoInformado solucion;
	private 	PriorityQueue<NodoInformado> abiertos;
//	private		Hashtable<NodoInformado,Integer> records;
	private		List<NodoInformado>	visitados;
	
	public void inicializar() {
		cuentaNodo	=	0;
		fallido	=	false;
		solucion = null;		
		expandidos.clear();
		abiertos.clear(); 	//metemos en la lista de abiertos el primer nodo
		visitados.clear();
//		records.clear();
		NodoInformado inicial	=	construyeNodo(problema.getInicial(), 0, null, null);
		abiertos.add(inicial);
		visitados.add(inicial);
//		records.put( inicial, new Integer(inicial.getCoste()));
	}

	public	AlgoritmoPrioritario(){
		super();
		abiertos	=	new	PriorityQueue<NodoInformado>(100);
//		records		=	new	Hashtable<NodoInformado,Integer>();
		visitados	=	new	LinkedList<NodoInformado>();
	}

	/* Pasamos al siguiente estado desde el actual */
	public void avanzarPaso() {
		if ((solucion == null) && (!abiertos.isEmpty())){
			NodoInformado nodoAct = abiertos.poll();
			expandidos.add(nodoAct);
			if (problema.esObjetivo(nodoAct.getEstado())) {
				solucion = nodoAct;
			}	else{
				Estado aux = nodoAct.getEstado();
				/* Operadores del estado actual */
				List<Operador> lista = aux.getOperadoresAplicables();
				for (int i = 0; i < lista.size(); i++){
					Operador opera	=	lista.get(i);
					//Invariante: todo nodo accedido estará en records.
					NodoInformado	nue	=	construyeNodo(opera.getFinal(), cuentaNodo,nodoAct,opera);
					if (! expandidos.contains(nue) && ! abiertos.contains(nue)){
						cuentaNodo	++;
						nue.setNumero(cuentaNodo);
						abiertos.add(nue);
						visitados.add(nue);
					} else {//control de repeticiones
						NodoInformado otro = visitados.get(visitados.indexOf(nue));
						if (nue.getCoste() < otro.getCoste()){
							visitados.remove(nue);
							visitados.add(nue);
							cuentaNodo	++;
							nue.setNumero(cuentaNodo);
							abiertos.add(nue);
						}
					}
				}
				fallido	=	abiertos.isEmpty();
			}
		}  
	}

	/**
	 * @return  the solucion
	 * @uml.property  name="solucion"
	 */
	protected Nodo getSolucion() {
		return solucion;
	}

	protected	abstract	NodoInformado 	construyeNodo(Estado estado, int numero, NodoInformado padre, Operador opera);
	protected 	abstract 	String 			getNombreAlgoritmo();

}
