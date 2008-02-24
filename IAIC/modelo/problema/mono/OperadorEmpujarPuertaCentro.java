package modelo.problema.mono;

public class OperadorEmpujarPuertaCentro extends OperadorMono {

	public OperadorEmpujarPuertaCentro(EstadoMono inicial) {
		super(inicial);
	}

	
	protected void calculaFinal() {
		EstadoMono m = (EstadoMono)getInicial();
		int aux = m.getPosCaja();
		if (aux == 0){
			aux = 1;
		}else{
			aux = 0;			
		}
		EstadoFinal = new EstadoMono(aux,m.getPosVer(),aux,m.getPlatano());
	}

	public String toString() {
		return "El Mono empuja la Caja entre la puerta y el centro \n";
	}

}
