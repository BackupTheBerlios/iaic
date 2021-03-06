package modelo.busqueda;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import modelo.problema.Operador;
import modelo.problema.Problema;

abstract class AlgoritmoAbstracto implements IAlgoritmo {
	/** Este campo representa el problema sobre el que el algoritmo 
	 * est� operando. Es un campo de registro, con getter y setter.*/
	protected Problema problema;

	/**
	 * @param problema  the problema to set
	 * @uml.property  name="problema"
	 */
	public	void setProblema(Problema p){
		this.problema = p;
	};
	/**
	 * @return  the problema
	 * @uml.property  name="problema"
	 */
	public	Problema getProblema(){
		return this.problema;
	};

	protected List<Nodo> expandidos;
	protected int cuentaNodo;
	protected boolean fallido;

	public	AlgoritmoAbstracto(){
		super();
		expandidos	=	new	LinkedList<Nodo>();
	}
	
	public boolean estaResuelto() {
		return (getSolucion() != null || fallido);
	}
	
	public String muestra() {
		StringBuffer	informacion	= 	new	StringBuffer();
		informacion.append("PROBLEMA: " + problema.toString());
		informacion.append("ESTADO INICIAL:\n" + problema.getEstado().mostrarInfo() );
		informacion.append("ALGORTIMO USADO: " + getNombreAlgoritmo() + "\n");
		informacion.append(imprimeExpandidos());
		if (haySolucion()){
			informacion.append(imprimeSolucion());
		} else if (fallido){
			informacion.append("Lo sentimos, La busqueda Ha Fracasado y no hay solucion\n");
		}
		return informacion.toString();
	}

	protected	StringBuffer imprimeSolucion() {
		StringBuffer res	=	new	StringBuffer();
		res.append("\n SOLUCION ALCANZADA: \n" + getSolucion().getEstado().mostrarInfo() + "\n");
		res.append("Nodos expandidos: " + expandidos.size());
		Stack<Operador> pila = new Stack<Operador>();
		Nodo aux = getSolucion(); 
		while (aux.getPadre() !=null){
			pila.push(aux.getOperador());
			aux = aux.getPadre();
		}
		int	costeTotal	=	0;
		while	(! pila.isEmpty()){
			Operador	ope	=	pila.pop();   //retira y remueve
			costeTotal	+=	ope.getCoste();
			res.append(ope.toString()  + "\n");
		}
		res.append("Coste total de la solucion: " + costeTotal + "\n");
		return res;		
	}
	
	protected StringBuffer imprimeExpandidos() {
		StringBuffer ret = new StringBuffer();
		ret.append("\nSECUENCIA NODOS EXPANDIDOS\n");
		Iterator<Nodo>	itera	=	expandidos.iterator();
		while (itera.hasNext()){
			ret.append(itera.next().muestra());			
		}		
		return ret;
	}
	
	protected boolean 		haySolucion(){
		return getSolucion() != null;
	}

	protected abstract String 		getNombreAlgoritmo();
	protected abstract Nodo			getSolucion();
	/**
	 * @return the fallido
	 */
	public boolean isFallido() {
		return fallido;
	}

}
