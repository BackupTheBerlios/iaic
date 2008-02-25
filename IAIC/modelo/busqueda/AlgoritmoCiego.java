package modelo.busqueda;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import java.util.List;
import modelo.problema.Estado;
import modelo.problema.Operador;

abstract class AlgoritmoCiego extends AlgoritmoAbstracto {

	private NodoCiego solucion;

	public AlgoritmoCiego() {
		super();
	}

	public void inicializar() {
		cuentaNodo	=	0;
		fallido	=	false;
		expandidos.clear();
		solucion = null;
		vaciaAbiertos();
		//metemos en abiertos el primer nodo
		NodoCiego	inicial = new NodoCiego(problema.getInicial(), 0, null, null);
		agnadirAbierto(inicial);
	}

	public void avanzarPaso() {
		if ((solucion == null) && (quedanAbiertos())){
			NodoCiego nodoAct = sacaAbierto(); //recupera y eliminar el 1�elemento de la lista
			expandidos.add(nodoAct);
			if (problema.esObjetivo(nodoAct.getEstado())) {
				solucion = nodoAct;
			}	else{
				Estado aux = nodoAct.getEstado();
				/* Operadores del estado actual */
				List<Operador> lista = aux.getOperadoresAplicables();
				for (int i = 0; i < lista.size(); i++){
					Operador opera	=	lista.get(i);
					NodoCiego	nue	=	new	NodoCiego(opera.getFinal(), cuentaNodo, opera,nodoAct);
					if (! expandidos.contains(nue) && ! estaEnAbiertos(nue)){
						cuentaNodo	++;
						nue.setNumero(cuentaNodo);
						agnadirAbierto(nue);
					} 
				}
				fallido	=	! quedanAbiertos();
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

	
	protected abstract String getNombreAlgoritmo() ;

	protected abstract void vaciaAbiertos();

	protected	abstract	boolean		quedanAbiertos();
	protected	abstract	void		agnadirAbierto(NodoCiego n);
	protected	abstract	NodoCiego	sacaAbierto();
	protected	abstract	boolean		estaEnAbiertos(NodoCiego n);
}
