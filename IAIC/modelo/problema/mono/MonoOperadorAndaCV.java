package modelo.problema.mono;

public class MonoOperadorAndaCV extends MonoOperador{

	public MonoOperadorAndaCV(MonoEstado inicial) {
		super(inicial);
	}

	
	protected void calculaFinal() {
		MonoEstado m = (MonoEstado)getInicial();
		int aux = m.getPosHor();
		if (aux == 1){
			aux = 2;
		}else{
			aux = 1;			
		}
		EstadoFinal = new MonoEstado(aux,m.getPosVer(),m.getPosCaja(),m.getPlatano());
	}

	public String toString() {
		return "Anda el mono entre centro y ventana";
	}

}
