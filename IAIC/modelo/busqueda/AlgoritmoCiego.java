package modelo.busqueda;

import java.util.List;
import modelo.problema.Estado;
import modelo.problema.Operador;

/**
 * @author  Diego
 */
abstract class AlgoritmoCiego extends AlgoritmoAbstracto {

	private NodoCiego solucion;

	public AlgoritmoCiego() {
		super();
	}

	public void inicializar() {
		cuentaNodo	=	0;
		fallido	=	false;
		expandidos.clear();
		enProceso.clear();
		solucion = null;
		vaciaAbiertos();
		//metemos en abiertos el primer nodo
		NodoCiego	inicial = new NodoCiego(problema.getInicial(), 0, null, null);
		agnadirAbierto(inicial);
	}

	public void prepararPaso() {
		if ((solucion == null) && (quedanAbiertos())){
			NodoCiego nodoAct = sacaAbierto(); //recupera y eliminar el 1�elemento de la lista
			expandidos.add(nodoAct);
			if (problema.esObjetivo(nodoAct.getEstado())) {
				solucion = nodoAct;
			}
			else{
				Estado aux = nodoAct.getEstado();
				/* Operadores del estado actual */
				List<Operador> lista = aux.getOperadoresAplicables();
				for (int i = 0; i < lista.size(); i++){
					Operador opera	=	lista.get(i);	
					NodoCiego	nue	=	new	NodoCiego(opera.getFinal(), cuentaNodo, opera,nodoAct);
					enProceso.add(nue);
				}
			}
		}
	}
	public void avanzarPaso() {
System.out.println("avanzando");
		if ((solucion == null)){
				for (int i = 0; i < enProceso.size(); i++){
					NodoCiego nue = (NodoCiego)enProceso.get(i);
					if (nue.getOperador().isEstadoEstable()){
						if (! expandidos.contains(nue) && ! estaEnAbiertos(nue)){
							cuentaNodo	++;
							nue.setNumero(cuentaNodo);
							agnadirAbierto(nue);
						}
					}else break;
				}
				fallido	=	! quedanAbiertos();
			}
		}  
	
	
	/**
	 * @return  the solucion
	 * @uml.property  name="solucion"
	 */
	protected Nodo getSolucion() {
		return solucion;
	}

	
	protected abstract String getNombreAlgoritmo() ;

	protected abstract void vaciaAbiertos();

	protected	abstract	boolean		quedanAbiertos();
	protected	abstract	void		agnadirAbierto(NodoCiego n);
	protected	abstract	NodoCiego	sacaAbierto();
	protected	abstract	boolean		estaEnAbiertos(NodoCiego n);
}
