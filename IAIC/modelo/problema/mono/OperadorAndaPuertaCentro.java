package modelo.problema.mono;

public class OperadorAndaPuertaCentro extends OperadorMono{

	
	public OperadorAndaPuertaCentro(EstadoMono inicial) {
		super(inicial);
	}

	protected void calculaFinal() {
		EstadoMono m = (EstadoMono)getInicial();
		int aux = m.getPosHor();
		if (aux == 0){
			aux = 1;
		}else{
			aux = 0;			
		}
		EstadoFinal = new EstadoMono(aux,m.getPosVer(),m.getPosCaja(),m.getPlatano());
		
		
	}

	public String toString() {
		return "Anda el Mono entre puerta y centro";
	}

}
