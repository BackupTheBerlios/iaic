package modelo.problema.mono;

public class MonoOperadorEmpujarCajaCV extends MonoOperador{

	public MonoOperadorEmpujarCajaCV(MonoEstado inicial) {
		super(inicial);
	}

	
	protected void calculaFinal() {
		MonoEstado m = (MonoEstado)getInicial();
		int aux = m.getPosCaja();
		if (aux == 1){
			aux = 2;
		}else{
			aux = 1;			
		}
		EstadoFinal = new MonoEstado(m.getPosHor(),m.getPosVer(),aux,m.getPlatano());
	}

	public String toString() {
		return "El mono empuja la Caja entre el centro y la ventana\n";
	}

}
