package modelo.problema.canibales;

class CanibalesOperadorCruzaM extends CanibalesOperador{

	
	public CanibalesOperadorCruzaM(CanibalesEstado inicial) {
		super(inicial);
	}

	protected void calculaFinal() {
		CanibalesEstado c = (CanibalesEstado)getInicial();
		int aux = c.getB();
		int nuevoMisi = c.getNM();
		if (aux == 0){
			aux = 1;
			nuevoMisi -=1;
		}else{
			aux = 0;
			nuevoMisi +=1;
		}
		EstadoFinal = new CanibalesEstado(nuevoMisi,c.getNC(),aux);
		
	}

	public String toString() {
		return "Cruza un solo Misionero a la otra orilla\n";
	}



}
