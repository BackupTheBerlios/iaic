package modelo.problema.probprueba;

public class ProbpruebaOperadorDeUnoAOtro extends ProbpruebaOperador {
	
	int estadoFinal;
	public ProbpruebaOperadorDeUnoAOtro(ProbpruebaEstado inicial, int destino) {
		super(inicial);
	this.estadoFinal = destino;
	}

	protected void calculaFinal() {				
		EstadoFinal = new ProbpruebaEstado(estadoFinal);		
	}

	public String toString() {
		return "Se pasa del estado " + ((ProbpruebaEstado)getInicial()).getID() + " al " + estadoFinal + ".\n";
	}
	

}
