package modelo.problema.granjero;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
class GranjeroOperadorPasaLobo extends GranjeroOperador {
	
	
	public GranjeroOperadorPasaLobo(GranjeroEstado inicial) {
		super(inicial);
	}
	
	protected void calculaFinal() {
		GranjeroEstado g = (GranjeroEstado)getInicial();
		int aux = g.getGB();
		if (aux == 0) aux = 1;
		else aux = 0;
		EstadoFinal = new GranjeroEstado(aux,aux,g.getCA(),g.getCO());
	}
	
	public String toString() {
		return "Pasa el Lobo con el Granjero \n";
	}
	
}
