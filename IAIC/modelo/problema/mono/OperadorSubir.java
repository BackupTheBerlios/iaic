package modelo.problema.mono;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
public class OperadorSubir extends OperadorMono {

	
	public OperadorSubir(EstadoMono inicial) {
		super(inicial);
	}

	protected void calculaFinal() {
		EstadoMono m = (EstadoMono)getInicial();
		int aux = m.getPosVer();
		if (aux == 0){
			aux = 1;
		}else{
			aux = 0;			
		}
		EstadoFinal = new EstadoMono(m.getPosHor(),aux,m.getPosCaja(),m.getPlatano());
	}

	public String toString() {
		return "El Mono se sube a la Caja";
	}

}
