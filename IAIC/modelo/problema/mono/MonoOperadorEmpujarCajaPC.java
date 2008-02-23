package modelo.problema.mono;

public class MonoOperadorEmpujarCajaPC extends MonoOperador {

	public MonoOperadorEmpujarCajaPC(MonoEstado inicial) {
		super(inicial);
	}

	
	protected void calculaFinal() {
		MonoEstado m = (MonoEstado)getInicial();
		int aux = m.getPosCaja();
		if (aux == 0){
			aux = 1;
		}else{
			aux = 0;			
		}
		EstadoFinal = new MonoEstado(m.getPosHor(),m.getPosVer(),aux,m.getPlatano());
	}

	public String toString() {
		return "El Mono empuja la Caja entre la puerta y el centro \n";
	}

}
