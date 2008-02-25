package modelo.problema.mono;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
public class OperadorAndaCentroVentana extends OperadorMono{

	public OperadorAndaCentroVentana(EstadoMono inicial) {
		super(inicial);
	}

	
	protected void calculaFinal() {
		EstadoMono m = (EstadoMono)getInicial();
		int aux = m.getPosHor();
		if (aux == 1){
			aux = 2;
		}else{
			aux = 1;			
		}
		EstadoFinal = new EstadoMono(aux,m.getPosVer(),m.getPosCaja(),m.getPlatano());
	}

	public String toString() {
		return "Anda el mono entre centro y ventana";
	}

}
