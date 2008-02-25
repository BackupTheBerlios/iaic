package modelo.busqueda;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
public class ServidorAlgoritmo implements IAlgoritmoServidor {
	
	
	private	enum	Codigo{Anchura,Profundidad,Uniforme,Voraz,Optima}

	public AlgoritmoAbstracto dameAlgoritmo(Object obj) {
		AlgoritmoAbstracto	resul;
		Codigo	cod	=	(Codigo)obj;
		/* Ahora se pone a probar qué codigo es el de */
		if (cod == Codigo.Anchura){
			resul	=	new	Anchura();
		} else if (cod == Codigo.Profundidad){
			resul	=	new	Profundidad();
		} else if (cod == Codigo.Uniforme){
			resul	=	new	Uniforme();
		} else if (cod == Codigo.Voraz){
			resul	=	new	Voraz();
		} else if (cod	==	Codigo.Optima){
			resul	=	new	Optima();
		} else {
			resul	=	null;
		}
		
		
		return resul;
	}

	private	Object[]	lista;
	
	public Object[] dameListaAlgoritmos() {
		if (lista == null){
			Codigo[] original	=	Codigo.values();
			lista	=	new	Object[ original.length];
			for (int i=0;i<lista.length;i++){
				lista[i]	=	original[i];
			}
		}
		return lista;
	}

}
