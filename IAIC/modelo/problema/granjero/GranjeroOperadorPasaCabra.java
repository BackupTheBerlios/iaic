package modelo.problema.granjero;

class GranjeroOperadorPasaCabra extends GranjeroOperador {

	public GranjeroOperadorPasaCabra(GranjeroEstado inicial) {
		super(inicial);
	}

	protected void calculaFinal() {
		GranjeroEstado g = (GranjeroEstado)getInicial();
		int aux = g.getGB();
		if (aux == 0) aux = 1;
		else aux = 0;
		EstadoFinal = new GranjeroEstado(aux,g.getLO(),aux,g.getCO());
		
	}

	public String getNombre() {
		return "Pasa la Cabra con el Granjero \n";
	}

}
