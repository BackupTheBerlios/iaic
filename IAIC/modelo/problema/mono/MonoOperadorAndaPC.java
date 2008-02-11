package modelo.problema.mono;

public class MonoOperadorAndaPC extends MonoOperador{

	
	public MonoOperadorAndaPC(MonoEstado inicial) {
		super(inicial);
	}

	protected void calculaFinal() {
		MonoEstado m = (MonoEstado)getInicial();
		int aux = m.getPosHor();
		if (aux == 0){
			aux = 1;
		}else{
			aux = 0;			
		}
		EstadoFinal = new MonoEstado(aux,m.getPosVer(),m.getPosCaja(),m.getPlatano());
		
		
	}

	public String getNombre() {
		return "Anda el Mono entre puerta y centro";
	}

}
