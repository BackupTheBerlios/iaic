package modelo.problema.mono;

public class OperadorCogerPlatano extends OperadorMono {

	public OperadorCogerPlatano(EstadoMono inicial) {
		super(inicial);
	}

	
	protected void calculaFinal() {
		EstadoMono m = (EstadoMono)getInicial();
		int aux = m.getPlatano();
		if (aux == 0){
			aux = 1;
		}else{
			aux = 0;			
		}
		EstadoFinal = new EstadoMono(m.getPosHor(),m.getPosVer(),m.getPosCaja(),aux);

		
	}

	public String toString() {
		return "El Mono coge el Platano";
	}

}
