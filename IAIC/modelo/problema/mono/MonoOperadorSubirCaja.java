package modelo.problema.mono;

public class MonoOperadorSubirCaja extends MonoOperador {

	
	public MonoOperadorSubirCaja(MonoEstado inicial) {
		super(inicial);
	}

	protected void calculaFinal() {
		MonoEstado m = (MonoEstado)getInicial();
		int aux = m.getPosVer();
		if (aux == 0){
			aux = 1;
		}else{
			aux = 0;			
		}
		EstadoFinal = new MonoEstado(m.getPosHor(),aux,m.getPosCaja(),m.getPlatano());
	}

	public String getNombre() {
		return "El Mono se sube a la Caja";
	}

}
