package modelo.problema.canibales;

class CanibalesOperadorCruzaC extends CanibalesOperador{

	public CanibalesOperadorCruzaC(CanibalesEstado inicial) {
		super(inicial);
	}

	protected void calculaFinal() {
		CanibalesEstado c = (CanibalesEstado)getInicial();
		int aux = c.getB();
		int nuevoCani = c.getNC();
		if (aux == 0){
			aux = 1;
			nuevoCani -=1;
		}else{
			aux = 0;
			nuevoCani +=1;
		}
		EstadoFinal = new CanibalesEstado(c.getNM(),nuevoCani,aux);


	}

	public String getNombre() {
		return "Cruza un solo Canibal a la otra orilla\n";
	}

}
