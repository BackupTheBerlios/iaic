package modelo.problema.canibales;

class CanibalesOperadorCruzaCC extends CanibalesOperador{

	public CanibalesOperadorCruzaCC(CanibalesEstado inicial) {
		super(inicial);
	}


	protected void calculaFinal() {
		CanibalesEstado c = (CanibalesEstado)getInicial();
		int aux = c.getB();
		int nuevoCani = c.getNC();
		if (aux == 0){
			aux = 1;
			nuevoCani -=2;
		}else{
			aux = 0;
			nuevoCani +=2;
		}
		EstadoFinal = new CanibalesEstado(c.getNM(),nuevoCani,aux);

		
	}

	public String toString() {
		return "Cruzan dos Canibales a la otra orilla\n";
	}

}
