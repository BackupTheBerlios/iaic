package modelo.problema.mono;

public class MonoOperadorCogerPlatano extends MonoOperador {

	public MonoOperadorCogerPlatano(MonoEstado inicial) {
		super(inicial);
	}

	
	protected void calculaFinal() {
		MonoEstado m = (MonoEstado)getInicial();
		int aux = m.getPlatano();
		if (aux == 0){
			aux = 1;
		}else{
			aux = 0;			
		}
		EstadoFinal = new MonoEstado(m.getPosHor(),m.getPosVer(),m.getPosCaja(),aux);

		
	}

	public String toString() {
		return "El Mono coge el Pl�tano";
	}

}
