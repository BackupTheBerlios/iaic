package modelo.problema.mono;
/**
 * @author  Paloma de la Fuente, Ines Gonzalez, Federico Mon
 */
public class OperadorEmpujarCentroVentana extends OperadorMono{

	public OperadorEmpujarCentroVentana(EstadoMono inicial) {
		super(inicial);
	}

	
	protected void calculaFinal() {
		EstadoMono m = (EstadoMono)getInicial();
		int aux = m.getPosCaja();
		if (aux == 1){
			aux = 2;
		}else{
			aux = 1;			
		}
		EstadoFinal = new EstadoMono(aux,m.getPosVer(),aux,m.getPlatano());
	}

	public String toString() {
		return "El mono empuja la Caja entre el centro y la ventana";
	}

}
