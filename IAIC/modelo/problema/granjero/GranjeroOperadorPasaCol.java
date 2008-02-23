package modelo.problema.granjero;

class GranjeroOperadorPasaCol extends GranjeroOperador {

	public GranjeroOperadorPasaCol(GranjeroEstado inicial) {
		super(inicial);
	}


	protected void calculaFinal() {
		GranjeroEstado g = (GranjeroEstado)getInicial();
		int aux = g.getGB();
		if (aux == 0) aux = 1;
		else aux = 0;
		EstadoFinal = new GranjeroEstado(aux,g.getLO(),g.getCA(),aux);
		
	}

	public String toString() {
		return "Pasa la Col con el Granjero \n";
	}

}
