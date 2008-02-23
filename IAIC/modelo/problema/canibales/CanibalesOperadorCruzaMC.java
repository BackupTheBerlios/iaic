package modelo.problema.canibales;

class CanibalesOperadorCruzaMC extends CanibalesOperador {

	public CanibalesOperadorCruzaMC(CanibalesEstado inicial) {
		super(inicial);
	}

	protected void calculaFinal() {
		CanibalesEstado c = (CanibalesEstado)getInicial();
		int aux = c.getB();
		int nuevoMisi = c.getNM();
		int nuevoCani = c.getNC();
		if (aux == 0){
			aux = 1;
			nuevoMisi -= 1;
			nuevoCani -=1;
		}else{
			aux = 0;
			nuevoMisi +=1;
			nuevoCani +=1;
		}
		EstadoFinal = new CanibalesEstado(nuevoMisi,nuevoCani,aux);

		
	}

	public String toString() {
		return "Cruzan un Misionero y un Canibal a la otra orilla\n";
	}

}
