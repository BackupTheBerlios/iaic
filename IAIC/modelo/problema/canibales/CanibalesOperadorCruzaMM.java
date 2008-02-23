package modelo.problema.canibales;

class CanibalesOperadorCruzaMM extends CanibalesOperador {

	public CanibalesOperadorCruzaMM(CanibalesEstado inicial) {
		super(inicial);
	}

	protected void calculaFinal() {
		CanibalesEstado c = (CanibalesEstado)getInicial();
		int aux = c.getB();
		int nuevoMisi = c.getNM();
		if (aux == 0){
			aux = 1;
			nuevoMisi -=2;
		}else{
			aux = 0;
			nuevoMisi +=2;
		}
		EstadoFinal = new CanibalesEstado(nuevoMisi,c.getNC(),aux);

		
	}

	public String toString() {
		return "Cruzan dos Misioneros a la otra orilla\n";
	}
	

}
